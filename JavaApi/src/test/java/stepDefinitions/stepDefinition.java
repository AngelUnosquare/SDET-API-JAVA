package stepDefinitions;

import java.util.HashMap;
import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import junit.framework.Assert;

public class stepDefinition {
	
	public HashMap<String, String> map = new HashMap<String, String>();
	String res;

	@Given("add {string} and {string}")
	public void add_and(String name, String job) {
		RestAssured.baseURI = "https://reqres.in/api/users/";
		map.put("name", "angel");
		map.put("job", "leader");
		
	}
	
	
	@When("user calls {string} with post http request")
	public void user_calls_with_post_http_request(String APIurl) {
		
		res = given().contentType(ContentType.JSON).body(map).when().post().then().statusCode(201).contentType(ContentType.JSON).extract().response().asString();

	}
	@Then("The api call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer statusCode) {
		
		Assert.assertEquals(statusCode,Integer.valueOf(201));
		System.out.println("Status code is: " + statusCode);
		System.out.println("Response is: " + res);

	}



}
