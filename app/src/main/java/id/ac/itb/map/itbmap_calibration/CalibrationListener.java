package id.ac.itb.map.itbmap_calibration;

/**
 * Created by Profisien on 6/3/2016.
 */
public interface CalibrationListener {
    void onCalibrationListenerComplete(Response response);
    void onCalibrationListenerError(String message);
}
