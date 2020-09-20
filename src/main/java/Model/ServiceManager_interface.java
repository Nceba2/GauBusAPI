package Model;

import org.json.simple.JSONObject;

public interface ServiceManager_interface {
    JSONObject getAllGauBus();

    JSONObject registerUser( String name_, String surname_, String email_, String password_, String confirmPassword_);
    JSONObject loginUser(String email_, String password_);
    JSONObject verifyToken(String token_);
}
