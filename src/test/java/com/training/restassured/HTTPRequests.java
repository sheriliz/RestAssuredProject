package com.training.restassured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*given() -prerequiste
 content type,set cookies,add auth ,add param,set headers info etc...
 
 
when() -request
get,post,put,delete

then() -validation
 validate statusCode,extract response,extract headers cookies and response body

*/

public class HTTPRequests {
	
	
	int id ;
	
	
	@Test(priority=1)
	void getUsers()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
	}
	
	@Test(priority=2)
	void createUsers()
	{
		HashMap data = new HashMap();
		data.put("name","Noah");
		data.put("job","trainer");

		id=given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");

//		.then()
//			.statusCode(201)
//			.log().all();
			
			
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
		 .get("https://reqres.in/api/users/2" +id)
		 
		.then()
		.statusCode(200);
	}
	

}
