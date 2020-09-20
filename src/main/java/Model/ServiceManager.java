package Model;

import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ServiceManager implements ServiceManager_interface{
    private JSONObject results;

//Stops section
    public JSONObject getAllGauBus() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://192.168.8.101:3306/GauBusDB","root","");
            results = new JSONObject();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("CALL allStops();");
            while(rs.next()) {
                results.put("id",rs.getInt(1));
                results.put("location",rs.getString(2));
                results.put("coordinates",rs.getString(3));
                results.put("status",rs.getString(4));
            }
            con.close();
            System.out.println("locatotions: "+results);

            return results;
        }catch (Exception e){
            results = new JSONObject();
            results.put("results","failed");
            return results;
        }
    }
//stops section ends

//auth section
    public JSONObject registerUser( String name_, String surname_, String email_, String password_, String confirmPassword_) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://192.168.8.101:3306/GauBusDB","root","");
            results = new JSONObject();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("CALL registerUser('"+name_+"','"+surname_+"','"+email_+"','"+password_+"','"+confirmPassword_+"');");
            while(rs.next()) {
                results.put("status",rs.getString(1));
            }
            con.close();
            System.out.println("results: "+results);

            return results;
        }catch (Exception e){
            results = new JSONObject();
            results.put("results","failed");
            System.out.println(e);
            return results;
        }
    }

    @Override
    public JSONObject loginUser(String email_, String password_) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://192.168.8.101:3306/GauBusDB","root","");
            results = new JSONObject();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("CALL loginUser('"+email_+"','"+password_+"');");
            while(rs.next()) {
                results.put("id",rs.getString(1));
                results.put("name",rs.getString(2));
                results.put("surname",rs.getString(3));
                results.put("email",rs.getString(4));
            }
            con.close();
            System.out.println("results: "+results);

            return results;
        }catch (Exception e){
            results = new JSONObject();
            results.put("results","failed");
            System.out.println(e);
            return results;
        }
    }

    @Override
    public JSONObject verifyToken(String token_) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://192.168.8.101:3306/GauBusDB","root","");
            results = new JSONObject();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("CALL verifyToken('"+token_+"');");
            while(rs.next()) {
                results.put("response",rs.getString(1));
            }
            con.close();
            System.out.println("results: "+results);

            return results;
        }catch (Exception e){
            results = new JSONObject();
            results.put("results","failed");
            System.out.println(e);
            return results;
        }
    }
//auth section ends

}
