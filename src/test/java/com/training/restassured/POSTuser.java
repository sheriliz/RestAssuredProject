package com.training.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class POSTuser {
	
	@Test
	public void postUser()
	{
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("name","Sheri");
		map.put("job","Trainer");
		
		System.out.println(map);

		given()
		
		
		
		.when()
		   .post("https://reqres.in/api/users")
		
		.then()
			.statusCode(200)
			.log().all();
	}

	//Creating data using JSONObject
	@Test
	public void postUserWithoutMap()
	{
		
		JSONObject request = new JSONObject();
		request.put("name", "Thomas");
		request.put("job", "IT");
		System.out.println(request);
		
//		System.out.println(request.toJSONString()); //If serialization error is thrown
		
		
		given()
			.header("Content-Type" ,"application/json")
			.contentType(ContentType.JSON).accept(ContentType.JSON)
			.body(request.toJSONString())
		
		.when()
			.post("https://reqres.in/api/users")
		
		.then()
			.statusCode(201)
			.log().all();
	}
}
