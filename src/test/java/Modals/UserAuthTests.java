package Modals;

import Model.ServiceManager;
import Model.ServiceManager_interface;
import Model.UserAuth;
import Model.UserAuth_interface;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserAuthTests {
    private JSONObject expectationJson;
    private JSONObject Object_;

    @Before
    public void initialValues(){
        expectationJson = new JSONObject();
    }

    @Test
    public void ServiceOject_test_Login_pass(){
        Object_ = new JSONObject();
        Object_.put("email","Ncebasobikwa1@hotmail.com");
        Object_.put("password","pass@55");

        UserAuth_interface iUserAuth = new UserAuth();
        Assert.assertNotEquals("incorrect email or password",iUserAuth.Login(Object_));
    }

    @Test
    public void ServiceOject_test_Register_pass(){
        Object_ = new JSONObject();
        Object_.put("name","Nceba");
        Object_.put("suname","Sobikwa");
        Object_.put("email","Ncebasobikwa1@hotmail.com");
        Object_.put("password","pass@55");
        Object_.put("confirmPassword","pass@55");

        UserAuth_interface iUserAuth = new UserAuth();
        Assert.assertNotEquals("failed",iUserAuth.Register(Object_));
    }
}
