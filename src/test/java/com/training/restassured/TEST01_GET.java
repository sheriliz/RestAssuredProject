package com.training.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class TEST01_GET {
	
	@Test
	void test_01(){
		
		
		//Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		System.out.println(response.asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statusCode= response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
	}
	
	@Test
	void test02() {
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[2]",equalTo(9));
		
	}
	
	@Test
	public void test03()
	{
		given().
		//header("Content-Type","application/json").
		get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[0]",equalTo(7))
			.body("data.first_name",hasItems("Michael","LindSay"))
			.log().all();
		
	}
	
	@Test(priority=3)
	void updateUser()
	{
		
		HashMap data = new HashMap();
		
		data.put("name","Thomas");
		data.put("job", "Trainer");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		 .get("https://reqres.in/api/users/2")
		 
		.then()
		.statusCode(200);
	}
	

}
