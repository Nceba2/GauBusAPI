package Model;

import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseService implements DatabaseService_interface {
    private JSONObject results;
    protected String url_ = "jdbc:mysql://192.168.8.101:3306/GauBusDB";
    protected String user_ = "root";
    protected String pass_ = "";

//Database config
    private Connection openDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url_, user_, pass_);
            return con;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
//Database config ends

//Stops section
    public JSONObject getAllGauBus() {
        try {
            results = new JSONObject();
            Statement stmt=openDB().createStatement();
            ResultSet rs=stmt.executeQuery("CALL allStops();");
            while(rs.next()) {
                results.put("id",rs.getInt(1));
                results.put("location",rs.getString(2));
                results.put("coordinates",rs.getString(3));
                results.put("status",rs.getString(4));
            }
            openDB().close();
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
            results = new JSONObject();
            Statement stmt=openDB().createStatement();
            ResultSet rs=stmt.executeQuery("CALL registerUser('"+name_+"','"+surname_+"','"+email_+"','"+password_+"','"+confirmPassword_+"');");
            while(rs.next()) {
                results.put("status",rs.getString(1));
            }
            openDB().close();
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
            results = new JSONObject();
            Statement stmt=openDB().createStatement();
            ResultSet rs=stmt.executeQuery("CALL loginUser('"+email_+"','"+password_+"');");
            while(rs.next()) {
                results.put("id",rs.getString(1));
                results.put("name",rs.getString(2));
                results.put("surname",rs.getString(3));
                results.put("email",rs.getString(4));
            }
            openDB().close();
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
            results = new JSONObject();
            Statement stmt=openDB().createStatement();
            ResultSet rs=stmt.executeQuery("CALL verifyToken('"+token_+"');");
            while(rs.next()) {
                results.put("response",rs.getString(1));
            }
            openDB().close();
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


//trip section
    @Override
    public JSONObject bookTrip(JSONObject tripInfo, int userIk) {
        try {
            results = new JSONObject();
            Statement stmt=openDB().createStatement();
            ResultSet rs=stmt.executeQuery("CALL trip_book('"+
                    tripInfo.get("date")+"','"+
                    tripInfo.get("time")+"','"+
                    tripInfo.get("type")+"','"+
                    tripInfo.get("stopIk")+"','"+
                    userIk+"');");

            while(rs.next()) {
                results.put("response",rs.getString(1));
            }
            openDB().close();
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
    public JSONObject cancelTrip(int ik) {
        try {
            results = new JSONObject();
            Statement stmt=openDB().createStatement();
            ResultSet rs=stmt.executeQuery("CALL trip_cancel('"+ik+"');");
            while(rs.next()) {
                results.put("response",rs.getString(1));
            }
            openDB().close();
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
    public JSONObject RescheduleTrip(JSONObject tripInfo, int ik) {
        try {
            results = new JSONObject();
            Statement stmt=openDB().createStatement();
            ResultSet rs=stmt.executeQuery("CALL trip_reschedule('"+
                            tripInfo.get("date")+"','"+
                            tripInfo.get("time")+"','"+
                            tripInfo.get("type")+"','"+
                            tripInfo.get("stopIk")+"','"+
                            tripInfo.get("userIk")+"','"+ik+"');");

            while(rs.next()) {
                results.put("response",rs.getString(1));
            }
            openDB().close();
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
    public JSONObject viewTrip(int ik) {
        try {
            results = new JSONObject();
            Statement stmt=openDB().createStatement();
            ResultSet rs=stmt.executeQuery("CALL trip_view('"+ik+"');");
            while(rs.next()) {
                results.put("ik",rs.getString(1));
                results.put("date",rs.getString(2));
                results.put("time",rs.getString(3));
                results.put("stopIk",rs.getString(4));
                results.put("userIk",rs.getString(5));
                results.put("type",rs.getString(6));
                results.put("status",rs.getString(7));
                results.put("created_on",rs.getString(8));
            }
            openDB().close();
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
    public JSONObject viewTripByUser(int userik) {
        try {
            results = new JSONObject();
            Statement stmt=openDB().createStatement();
            ResultSet rs=stmt.executeQuery("CALL trip_viewByUser('"+userik+"');");
            while(rs.next()) {
                results.put("ik",rs.getString(1));
                results.put("date",rs.getString(2));
                results.put("time",rs.getString(3));
                results.put("stopIk",rs.getString(4));
                results.put("userIk",rs.getString(5));
                results.put("type",rs.getString(6));
                results.put("status",rs.getString(7));
                results.put("created_on",rs.getString(8));
            }
            openDB().close();
            System.out.println("results: "+results);

            return results;
        }catch (Exception e){
            results = new JSONObject();
            results.put("results","failed");
            System.out.println(e);
            return results;
        }
    }
//trip section ends
}
