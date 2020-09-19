package com.gaubusapi.GauBusAPI;
import org.json.simple.JSONObject;
import org.junit.*;
import org.json.simple.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class, loader = AnnotationConfigContextLoader.class)
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

}

