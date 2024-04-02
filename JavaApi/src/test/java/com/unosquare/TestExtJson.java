package com.unosquare;

import static io.restassured.RestAssured.given;

import java.io.FileReader;

import org.json.simple.parser.JSONParser;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class TestExtJson {
	
	@Test
	  public void f_Gherkin_post_register() throws Exception {
		  	
		 	JSONParser json = new JSONParser();
		 	FileReader reader = new FileReader("./src/test/java/Json/register.json");
		 	Object obj = json.parse(reader);
		
			String Testresponse = given().contentType(ContentType.JSON).body(obj)
		  .when()
		  	.post("https://reqres.in/api/register")
		  		.then().assertThat().statusCode(200).assertThat().contentType(ContentType.JSON).extract().response().asString();
			System.out.println(obj);
		  Reporter.log("Sucess 200 validation");
		  Reporter.log("Response is: " + Testresponse);
		  Reporter.log("Response is: " + obj);
		  
		  
	}
	
	
	 @BeforeMethod
	 public void beforeMethod4() {
		 
	 }
}
