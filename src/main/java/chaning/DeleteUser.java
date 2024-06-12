package chaning;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {

	@Test
	public void deleteUsers(ITestContext context) {
		int id = (Integer) context.getSuite().getAttribute("userID");

		given().contentType("application/json")

				.when().delete("https://reqres.in/api/users/" + id)

				.then().statusCode(204).log().all();

	}
}
