package com.unosquare;

import static io.restassured.RestAssured.*;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;



public class FirstAPITest {
	 @Test
	  public void f_Gherkin() {
		  
			String Testresponse = given().contentType(ContentType.JSON).body("{\"name\": \"angel\",\"job\": \"leader\"}")
		  .when()
		  	.post("https://reqres.in/api/users/")
		  		.then().assertThat().statusCode(201).assertThat().contentType(ContentType.JSON).extract().response().asString();
					
		  Reporter.log("Sucess 201 validation");
		  Reporter.log("Response is: " + Testresponse);
		  
	}
	 @BeforeMethod
  public void beforeMethod() {
  }

}

