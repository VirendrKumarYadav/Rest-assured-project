package day5;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.matcher.RestAssuredMatchers;


public class JSONSchemaValidator {

	@Test
	void getUsers() {
	         	given()
				.when().get("https://reqres.in/api/users?page=2")
				.then().
				 assertThat().body(RestAssuredMatchers.matchesDtdInClasspath(""));
	}
}
