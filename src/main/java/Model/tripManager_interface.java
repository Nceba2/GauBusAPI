package Model;

import org.json.simple.JSONObject;

public interface tripManager_interface {
    JSONObject bookTrip(JSONObject tripInfo);
    JSONObject cancelTrip(int ik);
    JSONObject updateTrip(JSONObject tripInfo, int ik);
}
