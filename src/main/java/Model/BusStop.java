package Model;

import org.json.simple.JSONObject;

public class BusStop implements BusStop_interface{

    public JSONObject allBusStops(){
        DatabaseService_interface iServiceManager = new DatabaseService();
        return iServiceManager.getAllGauBus();
    }
}
