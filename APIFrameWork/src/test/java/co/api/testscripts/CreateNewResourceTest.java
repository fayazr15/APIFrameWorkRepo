package co.api.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.genericlib.BaseClass;

import io.restassured.response.Response;

public class CreateNewResourceTest extends BaseClass
{
	@Test
	public void checkCreateNewResource() throws IOException
	{
		String apiTestData = config.getApiTestData("createNewData");
		Response resp = config.executeRequest(apiTestData);
		resp.then().log().all();
		System.out.println("pass");
	}
}