package Model;

import org.json.simple.JSONObject;

public class BusStop implements BusStop_interface{
    private JSONObject response;

    public JSONObject allBusStops(){
        response = new JSONObject();
        response.put("results","success");

        return response;
    }
}
