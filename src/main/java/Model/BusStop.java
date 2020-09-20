package Model;

import org.json.simple.JSONObject;

public class BusStop implements BusStop_interface{

    public JSONObject allBusStops(){
        ServiceManager_interface iServiceManager = new ServiceManager();
        return iServiceManager.getAllGauBus();
    }
}
