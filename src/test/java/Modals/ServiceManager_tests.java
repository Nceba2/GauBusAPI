package Modals;
import Model.*;
import org.json.simple.JSONObject;
import org.junit.*;
import org.json.simple.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
public class ServiceManager_tests {
    private JSONObject expectationJson;

    @Before
    public void initialValues(){
        expectationJson = new JSONObject();
    }

    @Test
    public void ServiceOject_test_getAllStops_pass(){
        ServiceManager_interface iServiceManager = new ServiceManager();
        Assert.assertNotEquals("failed",iServiceManager.getAllGauBus());
    }

    @Test
    public void ServiceOject_test_register_pass(){
        expectationJson.put("status","user registered");
        ServiceManager_interface iServiceManager = new ServiceManager();
        Assert.assertEquals(expectationJson,
                iServiceManager.registerUser(
                        "Tom",
                        "Dlamini",
                        "TestingTom@hotmail.com",
                        "pass@77","pass@77"));
    }

    @Test
    public void ServiceOject_test_login_pass(){
        expectationJson.put("status","user registered");
        ServiceManager_interface iServiceManager = new ServiceManager();
        Assert.assertNotEquals("incorrect email or password",
                iServiceManager.loginUser("TestingTom@hotmail.com","pass@77"));
    }
}
