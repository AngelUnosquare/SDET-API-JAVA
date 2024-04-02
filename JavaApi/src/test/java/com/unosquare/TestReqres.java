package com.unosquare;

import static io.restassured.RestAssured.given;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.*;

import io.restassured.http.ContentType;

public class TestReqres {
	   @Test
	 public void f_Gherkin_get() {
		  
			String Testresponse2 = given().contentType(ContentType.JSON)
		  .when()
		  	.get("https://reqres.in/api/users/2")
		  		.then().assertThat().statusCode(200).assertThat().contentType(ContentType.JSON).assertThat()
		  		.body("data.first_name", equalTo("Janet")).extract().response().asString();
					
		  Reporter.log("Sucess 200 validation");
		  Reporter.log("Response is: " + Testresponse2);
		  
	}
	 @BeforeMethod
	 public void beforeMethod() {
	 }
	 //////////////////////////////////////////
	 @Test
	  public void f_Gherkin_delete() {
		  
			String Testresponse = given()
		  .when()
		  	.delete("https://reqres.in/api/users/2")
		  		.then().assertThat().statusCode(204).extract().response().asString();
					
		  Reporter.log("Sucess 204 validation");
		  Reporter.log("Response is: " + Testresponse);
		  
	}
	 @BeforeMethod
	 
		public void beforeMethod2() {
		}
	 
	 //////////////////////////////////////////
	 
	 @Test
	  public void f_Gherkin_post() {
		  
			String Testresponse = given().contentType(ContentType.JSON).body("{\"name\": \"angel\",\"job\": \"leader\"}")
		  .when()
		  	.post("https://reqres.in/api/users/")
		  		.then().assertThat().statusCode(201).assertThat().contentType(ContentType.JSON).extract().response().asString();
					
		  Reporter.log("Sucess 201 validation");
		  Reporter.log("Response is: " + Testresponse);
		  
	}
	 @BeforeMethod
	 public void beforeMethod3() {
	 }
	 
	 //////////////////////////////////////////
	 
	 @Test
	  public void f_Gherkin_post_register() {
		  
			String Testresponse = given().contentType(ContentType.JSON).body("{\"email\": \"eve.holt@reqres.in\",\"password\": \"pistol\"}")
		  .when()
		  	.post("https://reqres.in/api/register/")
		  		.then().assertThat().statusCode(200).assertThat().contentType(ContentType.JSON).extract().response().asString();
					
		  Reporter.log("Sucess 201 validation");
		  Reporter.log("Response is: " + Testresponse);
		  
	}
	 @BeforeMethod
	 public void beforeMethod4() {
	 }
	 
	 
}
