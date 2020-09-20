package Model;

import org.json.simple.JSONObject;

public class UserAuth implements UserAuth_interface {

    public JSONObject Register(JSONObject newUser){
        ServiceManager_interface iServiceManager = new ServiceManager();
        return iServiceManager.registerUser(
                (String) newUser.get("name"),
                (String) newUser.get("suename"),
                (String) newUser.get("email"),
                (String) newUser.get("password"),
                (String) newUser.get("confirmPassword"));
    }

    public JSONObject Login(JSONObject User){
        ServiceManager_interface iServiceManager = new ServiceManager();
        return iServiceManager.loginUser( (String) User.get("email"), (String) User.get("password"));
    }

    public JSONObject Verify(JSONObject token){
        ServiceManager_interface iServiceManager = new ServiceManager();
        return iServiceManager.verifyToken( (String) token.get("token"));
    }
}
