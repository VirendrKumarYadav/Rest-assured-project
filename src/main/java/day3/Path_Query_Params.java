package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Path_Query_Params {
	
	
	
	@Test	
  public void getUsers() {
		given()
		.pathParam("mypath", "users") //path parameter
		.queryParam("page", "2")  //Query Parameter
		.queryParam("id", "5")  // Query Parameter
		
				.when().get("https://reqres.in/api/{mypath}")

				.then().statusCode(200)
				.log().all();
	}

}
