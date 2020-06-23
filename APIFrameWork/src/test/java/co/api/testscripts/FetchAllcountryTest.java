 package co.api.testscripts;

import org.testng.annotations.Test;

import com.api.genericlib.BaseClass;

import io.restassured.response.Response;

public class FetchAllcountryTest extends BaseClass
{
	@Test
	public void checkAllCountries() throws Exception
	{
		String apiTestData = config.getApiTestData("fetchAllCountry");
		Response resp = config.executeRequest(apiTestData);
		resp.then().log().all();
		
	}
}
