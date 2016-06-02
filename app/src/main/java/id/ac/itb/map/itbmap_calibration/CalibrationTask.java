package id.ac.itb.map.itbmap_calibration;

import android.os.AsyncTask;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Profisien on 6/3/2016.
 */
public class CalibrationTask extends AsyncTask<Data, Integer, Response> {

    CalibrationListener calibrationListener;

    public CalibrationTask(CalibrationListener calibrationListener){
        this.calibrationListener = calibrationListener;
    }

    @Override
    protected Response doInBackground(Data... params) {
        String url = "http://216.126.192.36/itbmap-webservice/calibration?"+params[0].toHttpQuery();
        try {
            String json = IOUtils.toString(new URL(url));
            JsonElement jelement = new JsonParser().parse(json);
            JsonObject jobject = jelement.getAsJsonObject();

            jobject = jobject.getAsJsonObject("data");
            String message = jobject.get("message").getAsString();
            int code = jobject.get("code").getAsInt();
            jobject = jobject.getAsJsonObject("data");
            Response response = new Response();
            response.setCode(code);
            response.setMessage(message);

            return response;
        } catch (IOException e) {
            calibrationListener.onCalibrationListenerError(e.getMessage());
        }
        return null;
    }

    protected void onPostExecute(Response response) {
        calibrationListener.onCalibrationListenerComplete(response);
    }
}
