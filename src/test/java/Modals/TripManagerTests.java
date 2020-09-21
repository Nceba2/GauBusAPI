package Modals;
import Model.UserAuth;
import Model.UserAuth_interface;
import Model.tripManager;
import Model.tripManager_interface;
import org.json.simple.JSONObject;
import org.junit.*;
import org.json.simple.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TripManagerTests {
    private JSONObject Object_;

    @Test
    public void TripManager_test_Booking_pass(){
        int userIk = 1;
        int stopIk = 1;
        Object_ = new JSONObject();

        Object_.put("date","22-09-2020");
        Object_.put("time","21h00");
        Object_.put("stopIk",stopIk);
        Object_.put("userIk",userIk);
        tripManager_interface iTripManager = new tripManager();

        Assert.assertNotEquals("failed",iTripManager.bookTrip( Object_, userIk));
    }

    @Test
    public void TripManager_test_Cancel_pass(){
        int ik = 1;

        tripManager_interface iTripManager = new tripManager();

        Assert.assertNotEquals("failed",iTripManager.cancelTrip(ik));
    }

    @Test
    public void TripManager_test_reschedule_pass(){
        int ik = 1;//record to be updated
        Object_ = new JSONObject();

        Object_.put("date","22-09-2020");
        Object_.put("time","21h00");
        Object_.put("stopIk", 1);
        Object_.put("userIk", 1);
        tripManager_interface iTripManager = new tripManager();

        Assert.assertNotEquals("failed",iTripManager.rescheduleTrip( Object_, ik));
    }
}
