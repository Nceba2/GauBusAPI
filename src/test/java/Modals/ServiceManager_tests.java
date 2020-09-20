package Modals;
import Model.*;
import org.json.simple.JSONObject;
import org.junit.*;
import org.json.simple.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ServiceManager_tests {
    private JSONObject ticketJson;

    @Before
    public void initialValues(){
        ticketJson = new JSONObject();
    }

    @Test
    public void ServiceOject_test_returnsBusStops() {
        ServiceManager_interface iServiceManager = new ServiceManager();
        System.out.println(iServiceManager.getAllGauBus());
        Assert.assertNotEquals("failed",iServiceManager.getAllGauBus());
    }
}
