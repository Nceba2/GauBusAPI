package Modals;
import Model.*;
import org.json.simple.JSONObject;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DatabaseService_tests {
    private JSONObject expectationJson;

    @Before
    public void initialValues(){
        expectationJson = new JSONObject();
    }

    @Test
    public void ServiceOject_test_getAllStops_pass(){
        DatabaseService_interface iServiceManager = new DatabaseService();
        Assert.assertNotEquals("failed",iServiceManager.getAllGauBus());
    }

    @Test
    public void ServiceOject_test_register_pass(){
        expectationJson.put("status","user registered");
        DatabaseService_interface iServiceManager = new DatabaseService();
        Assert.assertEquals(expectationJson,
                iServiceManager.registerUser(
                        "Tom",
                        "Dlamini",
                        "TestingTom@hotmail.com",
                        "pass@77","pass@77"));
    }

    @Test
    public void ServiceOject_test_login_pass(){
        expectationJson.put("name","Tom");
        DatabaseService_interface iServiceManager = new DatabaseService();
        Assert.assertEquals(expectationJson.get("name"),
                iServiceManager.loginUser("TestingTom@hotmail.com","pass@77").get("name"));
    }
}
