package co.api.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.genericlib.ApiConfig;
import com.api.genericlib.BaseClass;

import io.restassured.response.Response;

public class UpdatePartiallyTest extends BaseClass

{
	@Test
	public void checkPartialUpdate() throws IOException   
	{
			String apiTestData = config.getApiTestData("updateDataPartially");
			Response resp = config.executeRequest(apiTestData);
			resp.then().log().all();
	}

}
