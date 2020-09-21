package Model;

import org.json.simple.JSONObject;

public class tripManager implements tripManager_interface {
    @Override
    public JSONObject bookTrip(JSONObject tripInfo, int userik) {
        DatabaseService_interface iDatabaseService = new DatabaseService();
        return iDatabaseService.bookTrip(tripInfo,userik);
    }

    @Override
    public JSONObject cancelTrip(int ik) {
        DatabaseService_interface iDatabaseService = new DatabaseService();
        return iDatabaseService.cancelTrip(ik);
    }

    @Override
    public JSONObject rescheduleTrip(JSONObject tripInfo, int ik) {
        DatabaseService_interface iDatabaseService = new DatabaseService();
        return iDatabaseService.RescheduleTrip(tripInfo,ik);
    }

    @Override
    public JSONObject viewTrip(int ik) {
        DatabaseService_interface iDatabaseService = new DatabaseService();
        return iDatabaseService.viewTrip(ik);
    }

    @Override
    public JSONObject viewTripByUser(int userik) {
        DatabaseService_interface iDatabaseService = new DatabaseService();
        return iDatabaseService.viewTripByUser(userik);
    }
}
