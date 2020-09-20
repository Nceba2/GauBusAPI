package Model;

import org.json.simple.JSONObject;

public interface UserAuth_interface {
    JSONObject Register(JSONObject newUser);

    JSONObject Login(JSONObject User);

    JSONObject Verify(JSONObject token);
}
