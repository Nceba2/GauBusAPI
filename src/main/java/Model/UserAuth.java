package Model;

import Services.DatabaseService;
import Services.DatabaseService_interface;
import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.Statement;

public class UserAuth implements UserAuth_interface {
    private JSONObject results;

    public JSONObject Register(JSONObject newUser){
        DatabaseService_interface iServiceManager = new DatabaseService();

        try{
            ResultSet rs=iServiceManager.request("CALL registerUser('"
                    +newUser.get("name")+"','"
                    +newUser.get("suename")+"','"
                    +newUser.get("email")+"','"
                    +newUser.get("password")+"','"
                    +newUser.get("confirmPassword")+"');");
            while(rs.next()) {
                results.put("status",rs.getString(1));
            }
            System.out.println("results: "+results);

            return results;
        }catch (Exception e){
            results = new JSONObject();
            results.put("results","failed");

            System.out.println(e);
            return results;
        }
    }

    public JSONObject Login(JSONObject User){
        DatabaseService_interface iServiceManager = new DatabaseService();

        try {
            ResultSet rs= iServiceManager.request("CALL loginUser('"+User.get("email")+"','"+User.get("password")+"');");
            while(rs.next()) {
                results.put("id",rs.getString(1));
                results.put("name",rs.getString(2));
                results.put("surname",rs.getString(3));
                results.put("email",rs.getString(4));
            }
            System.out.println("results: "+results);

            return results;
        }catch (Exception e){
            results = new JSONObject();
            results.put("results","failed");
            System.out.println(e);
            return results;
        }
    }

    public JSONObject Verify(JSONObject token){
        DatabaseService_interface iServiceManager = new DatabaseService();

        try {
            ResultSet rs=iServiceManager.request("CALL verifyToken('"+token.get("token")+"');");
            while(rs.next()) {
                results.put("response",rs.getString(1));
            }
            System.out.println("results: "+results);

            return results;
        }catch (Exception e){
            results = new JSONObject();
            results.put("results","failed");
            System.out.println(e);
            return results;
        }
    }
}
