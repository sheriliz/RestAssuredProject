package com.training.restassured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetUser {
	
	@Test
	public void getUser()
	{
		given()
		.header("Content_Type" ,"application/json")
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.body("data.id[1]", equalTo(8))
		.body("data.first_name",hasItems("Michael","LindSay"))
		
		.log().all();
	}

}
