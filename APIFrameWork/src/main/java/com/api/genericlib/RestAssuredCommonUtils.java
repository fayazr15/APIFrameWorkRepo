package com.api.genericlib;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

//Note:- To add formatting element comment in eclipse we should use (ALT + Shift+J)

//ALT+Shift+j  (Right click-->Source-->Generate Element comment)


/**
 * @author Fayaz
 * 
 * {@code} This is useful for all common scenarios for RestApi
 * @since 2020
 */


public class RestAssuredCommonUtils
{
	/**
	 * @param Response to fetch status code  
	 * @param expected status code for validation
	 * {@code} It is useful for validation of status code of a API Response
	 */
	public void ValidateStatusCode(Response resp,int expectedStatusCode)
	{
		resp.then().assertThat().statusCode(expectedStatusCode);
		System.out.println("Status code Validation is Successfull");
	}
	
	public void ValidateContentType(Response resp)
	{
		resp.then().assertThat().contentType(ContentType.JSON);
		System.out.println("contentType Validation is Successfull");
	}
	
	/**
	 * @author Fayaz
	 * @param resp to fetch Response Time
	 * @param rangeOfWithinTime to ensure maximum time limit for response
	 *
	 */
	public void ValidateResponseTime(Response resp,long rangeOfWithinTime)
	{
		resp.then().assertThat().time(Matchers.lessThan(rangeOfWithinTime));
		System.out.println("Response Time Validation is Successfull");
	}
	
	public void validateKVPair(Response resp,String jsonpath,String expectedValue)
	{
		Object obj = resp.jsonPath().get(jsonpath);
		String actualValue =obj.toString();
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	/**
	 * @author RajSekhar
	 * @param ArrayList<Object> to fetch one by one object from list  
	 * {@code} It is useful to convert Object List to String List
	 * @return ArrayList<String>
	 */
	public ArrayList<String> convertObjectList_To_StringList(ArrayList<Object> list)
	{
		ArrayList<String> s = new ArrayList<String>();
		
		for (Object obj : list) 
		{
		String s1 = obj.toString();	
		s.add(s1);
		}
		return s;
	}
	
	public String fetchTokenID(Response resp,String jsonpath )
	{
		Object objtoken = resp.jsonPath().get(jsonpath);
		return objtoken.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
