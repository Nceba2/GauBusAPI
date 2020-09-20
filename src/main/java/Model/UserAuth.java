package Model;

import org.json.simple.JSONObject;

public class UserAuth implements UserAuth_interface {
    private JSONObject response;

    public JSONObject Register(JSONObject newUser){
        response = new JSONObject();
        response.put("results","success");

        return response;
    }

    public JSONObject Login(JSONObject User){
        response = new JSONObject();
        response.put("results","success");

        return response;
    }

    public JSONObject Verify(JSONObject token){
        response = new JSONObject();
        response.put("results","success");

        return response;
    }
}
