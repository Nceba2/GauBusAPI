package Model;

import Services.DatabaseService;
import Services.DatabaseService_interface;
import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.Statement;

public class BusStop implements BusStop_interface{
    private JSONObject results;

    public JSONObject allBusStops(){
        DatabaseService_interface databaseService = new DatabaseService();
        try {
            ResultSet rs = databaseService.request("CALL allStops();");
            while(rs.next()) {
                results.put("id",rs.getInt(1));
                results.put("location",rs.getString(2));
                results.put("coordinates",rs.getString(3));
                results.put("status",rs.getString(4));
            }

            System.out.println("locatotions: "+results);
            return results;
        }catch (Exception e){
            results = new JSONObject();
            results.put("results","failed");

            return results;
        }
    }
}
