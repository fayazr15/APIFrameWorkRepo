package co.api.testscripts;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class AddBulkData 
{
	@Test
	public void checkBulkPosting() throws Exception
	{
		File f = new File("./src/test/resources/BulkComplexData.json");
		FileInputStream fis = new FileInputStream(f);
		String jsondata = IOUtils.toString(fis, "UTF-8");

		Response resp = given()
		.body(jsondata)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:3000/posts");
		
		resp.then().log().all();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
