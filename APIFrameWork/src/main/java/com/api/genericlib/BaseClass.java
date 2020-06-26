package com.api.genericlib;

import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseClass 
{

	public ApiConfig config = new ApiConfig();
	public RestAssuredCommonUtils rutil = new RestAssuredCommonUtils();
	
//	Here we comment bcoz we are dealing with ,Multiple domain URI's
	
/*	@BeforeSuite
	public void congigBS()
	{
		baseURI ="https://restcountries.eu/";
		basePath="rest/v2";
	}*/
	
	
	}
