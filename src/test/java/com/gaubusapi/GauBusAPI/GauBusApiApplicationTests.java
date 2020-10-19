package com.gaubusapi.GauBusAPI;
//import Model.BusStop;
//import Model.BusStop_interface;
import Model.BusStop;
import Model.BusStop_interface;
import org.json.simple.JSONObject;
import org.junit.*;
import org.json.simple.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class GauBusApiApplicationTests {
	private JSONObject ticketJson;

	@Before
	public void initialValues(){
		ticketJson = new JSONObject();
	}

	@Test
	public void testJsonOject() {
		ticketJson.put("id", 1);
		ticketJson.put("date", "22-09-2020");
		ticketJson.put("time", "21h00");

		String date = (String) ticketJson.get("date");

		Assert.assertEquals("22-09-2020",date);
	}

	@Test
	public void allBusStops_test_JsonResponce(){
		BusStop_interface iBusStop = new BusStop();
		Assert.assertEquals("success",iBusStop.allBusStops().get("results"));
	}
}

