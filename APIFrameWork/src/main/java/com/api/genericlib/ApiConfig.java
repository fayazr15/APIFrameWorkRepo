package com.api.genericlib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ApiConfig
{
	private String[] keyValuePairArray;
	
	public String getApiTestData(String apiTestName) throws IOException 
	{
			FileInputStream fis = new FileInputStream("./src/test/resources/ApiList.properties");
			Properties pobj = new Properties();
			pobj.load(fis);
			String apiData = pobj.getProperty(apiTestName);
			return apiData;
	}
	
	
	public Response executeRequest(String apiData)
	{
		Response resp=null;
		String[] apiDataArray = apiData.split(";");
		if (apiDataArray[0].equals("get")) 
		{
			resp =given()
//			.queryParam("id", 2)
			.when()
			.get(apiDataArray[1]);
			
		}else if (apiDataArray[0].equals("post")) 
		{
			String jsonobj = createJsonObject(apiDataArray[2]);
			resp =given()
			.body(jsonobj)
			.contentType(ContentType.JSON)
			.when()
			.post(apiDataArray[1]);
			
		}else if (apiDataArray[0].equals("put")) 
		{
			String jsonobj = createJsonObject(apiDataArray[2]);
			resp =given()
			.body(jsonobj)
			.contentType(ContentType.JSON)
			.when()
			.put(apiDataArray[1]);
		}
		else if (apiDataArray[0].equals("patch")) 
		{
			String jsonobj = createJsonObject(apiDataArray[2]);
			resp =given()
			.body(jsonobj)
			.contentType(ContentType.JSON)
			.when()
			.patch(apiDataArray[1]);
			
		}
		else if (apiDataArray[0].equals("delete")) 
		{
			resp =given()
			.when()
			.delete(apiDataArray[1]);
		}
		
		return resp;
	}
	

	public String createJsonObject(String jsonData)
	{
		JSONObject jobj = new JSONObject();
		String[] jsonDataArray = jsonData.split(",");
		for (int i = 0; i < jsonDataArray.length; i++) 
		{
			keyValuePairArray = jsonDataArray[i].split(":");
			jobj.put(keyValuePairArray[0], keyValuePairArray[1]);
		}
		
		return jobj.toJSONString();
		
	}
	
	public Response excuteBulkPostRequest(String apiData) throws Exception
	{
		String[] arrData = apiData.split(";");
		if (arrData[0].equals("post"))
		{
			File f = new File(arrData[2]);
			FileInputStream fis = new FileInputStream(f);
			String jsondata = IOUtils.toString(fis, "UTF-8");

			Response resp = given()
			.body(jsondata)
			.contentType(ContentType.JSON)
			.when()
			.post("http://localhost:3000/posts");

			return resp;
			
		}else
		{
			throw new RuntimeException("Invalid HTTP Method for Bulk Data Post");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
