package Model;

import org.json.simple.JSONObject;

public interface DatabaseService_interface {
    JSONObject getAllGauBus();

    //auth section
    JSONObject registerUser( String name_, String surname_, String email_, String password_, String confirmPassword_);
    JSONObject loginUser(String email_, String password_);
    JSONObject verifyToken(String token_);

    //trip section
    JSONObject bookTrip(JSONObject tripInfo, int userIk);
    JSONObject cancelTrip(int ik);
    JSONObject RescheduleTrip(JSONObject tripInfo, int ik);
    JSONObject viewTrip(int ik);
    JSONObject viewTripByUser(int userik);
}
