package com.unosquare;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class NasaTestApi {
	
	@Test
	public void f_Gherkin_get() {
		  
		String Testresponse2 = given().contentType(ContentType.JSON)
		.when()
	  	.get("https://api.nasa.gov/planetary/apod?api_key=C2qhy2AIA3scBkhFv5bCFcL8RDvgjW8mPwIziSEa")
	  	.then().assertThat().statusCode(200).assertThat().contentType(ContentType.JSON).extract().response().asString();
				
	  Reporter.log("Sucess 200 validation");
	  Reporter.log("Response is: " + Testresponse2);
	  
}
 @BeforeMethod
 public void beforeMethod() {
 }
	
	
}
