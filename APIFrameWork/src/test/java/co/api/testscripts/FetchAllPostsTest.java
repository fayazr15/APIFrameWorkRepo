package co.api.testscripts;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.api.genericlib.ApiConfig;
import com.api.genericlib.BaseClass;

import io.restassured.response.Response;

public class FetchAllPostsTest  extends BaseClass
{
	@Test
	public void checkFetchAllPosts() throws IOException 
	{
//			here URI is provided
			String apiTestData = config.getApiTestData("fetchAllPosts");
			
			Response resp = config.executeRequest(apiTestData);
/*			
//						To Fetch Data From Response
			
//			 here it will return object but need to change as ArrayList
			
			ArrayList<Object> desg = resp.jsonPath().get("Designation");
			
//			Fetch by index from ArrayList and convert object into string for comparision
			
			System.out.println("Designation is : "+desg.get(0).toString());*/
			
			resp.then().log().all();
	}
}