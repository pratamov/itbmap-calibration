package id.ac.itb.map.itbmap_calibration;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class Data {
    private String uuid;
    private String minor_id;
    private String major_id;
    private double distance_prediction;
    private double distance_measured;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMinor_id() {
        return minor_id;
    }

    public void setMinor_id(String minor_id) {
        this.minor_id = minor_id;
    }

    public String getMajor_id() {
        return major_id;
    }

    public void setMajor_id(String major_id) {
        this.major_id = major_id;
    }

    public double getDistance_prediction() {
        return distance_prediction;
    }

    public void setDistance_prediction(double distance_prediction) {
        this.distance_prediction = distance_prediction;
    }

    public double getDistance_measured() {
        return distance_measured;
    }

    public void setDistance_measured(double distance_measured) {
        this.distance_measured = distance_measured;
    }

    public String toHttpQuery(){
        HashMap<String, String> param = new HashMap<>();
        param.put("uuid", this.uuid);
        param.put("minor_id", this.minor_id);
        param.put("major_id", this.major_id);
        param.put("distance_prediction", this.distance_prediction+"");
        param.put("distance_measured", this.distance_measured+"");
        StringBuilder sb = new StringBuilder();
        for(HashMap.Entry<String, String> e : param.entrySet()){
            try {
                if(sb.length() > 0){
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(e.getKey(), "UTF-8")).append('=').append(URLEncoder.encode(e.getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
            }
        }
        return sb.toString();
    }
}
