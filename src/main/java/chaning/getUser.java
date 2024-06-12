package chaning;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class getUser {

	@Test
	public void getUsers(ITestContext context) {
		int id=(Integer) context.getSuite().getAttribute("userID");
	
		given()
		.when().get("https://reqres.in/api/users?page="+id)

		.then().statusCode(200)
		.body("page", equalTo(2)).log().all();
	}
}
