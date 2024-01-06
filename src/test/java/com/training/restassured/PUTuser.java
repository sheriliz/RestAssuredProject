package com.training.restassured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PUTuser {

	
	@Test
	public void putUser() {
		
		JSONObject request = new JSONObject();
		request.put("name", "Neha");
		request.put("job", "Dancer");
		
		given()
			.header("Content-Type","application/json")
			.body(request.toJSONString())
		 
		.when()
			.put("https://reqres.in/api/users/2")
			
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	@Test
	public void delUser() {
		
		given()
		
		 
		.when()
			.delete("https://reqres.in/api/users/2")
			
		.then()
			.statusCode(204)
			.log().all();
		
	}
	

}


// .contentType(ContentType.JSON).accept(ContentType.JSON)
