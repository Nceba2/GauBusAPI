package Model;

import org.json.simple.JSONObject;

public interface tripManager_interface {
    JSONObject bookTrip(JSONObject tripInfo, int userIk);
    JSONObject cancelTrip(int ik);
    JSONObject rescheduleTrip(JSONObject tripInfo, int ik);
    JSONObject viewTrip(int ik);
    JSONObject viewTripByUser(int userik);
}
