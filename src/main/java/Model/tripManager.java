package Model;

import Services.DatabaseService;
import Services.DatabaseService_interface;
import org.json.simple.JSONObject;

import java.sql.ResultSet;

public class tripManager implements tripManager_interface {
    private JSONObject results;

    @Override
    public JSONObject bookTrip(JSONObject tripInfo, int userik) {
        DatabaseService_interface iDatabaseService = new DatabaseService();

        try {
            ResultSet rs=iDatabaseService.request("CALL trip_book('"+
                    tripInfo.get("date")+"','"+
                    tripInfo.get("time")+"','"+
                    tripInfo.get("type")+"','"+
                    tripInfo.get("stopIk")+"','"+
                    userik+"');");

            while(rs.next()) {
                results.put("response",rs.getString(1));
            }
            System.out.println("results: "+results);

            return results;
        }catch (Exception erl){
            results = new JSONObject();
            results.put("results","failed");
            System.out.println(erl);
            return results;
        }
    }

    @Override
    public JSONObject cancelTrip(int ik) {
        DatabaseService_interface iDatabaseService = new DatabaseService();

        try {
            ResultSet rs=iDatabaseService.request("CALL trip_cancel('"+ik+"');");
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

    @Override
    public JSONObject rescheduleTrip(JSONObject tripInfo, int ik) {
        DatabaseService_interface iDatabaseService = new DatabaseService();
        try {
            ResultSet rs=iDatabaseService.request("CALL trip_reschedule('"+
                    tripInfo.get("date")+"','"+
                    tripInfo.get("time")+"','"+
                    tripInfo.get("type")+"','"+
                    tripInfo.get("stopIk")+"','"+
                    tripInfo.get("userIk")+"','"+ik+"');");

            while(rs.next()) {
                results.put("response",rs.getString(1));
            }
            System.out.println("results: "+results);

            return results;
        }catch (Exception erl){
            results = new JSONObject();
            results.put("results","failed");
            System.out.println(erl);
            return results;
        }
    }

    @Override
    public JSONObject viewTrip(int ik) {
        DatabaseService_interface iDatabaseService = new DatabaseService();
        try {
            ResultSet rs=iDatabaseService.request("CALL trip_view('"+ik+"');");
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
            System.out.println("results: "+results);

            return results;
        }catch (Exception erl){
            results = new JSONObject();
            results.put("results","failed");
            System.out.println(erl);
            return results;
        }
    }

    @Override
    public JSONObject viewTripByUser(int userik) {
        DatabaseService_interface iDatabaseService = new DatabaseService();
        try {
            ResultSet rs=iDatabaseService.request("CALL trip_viewByUser('"+userik+"');");
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
            System.out.println("results: "+results);

            return results;
        }catch (Exception erl){
            results = new JSONObject();
            results.put("results","failed");
            System.out.println(erl);
            return results;
        }
    }
}
