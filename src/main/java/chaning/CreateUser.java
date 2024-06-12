package chaning;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CreateUser {

	@Test
	public void createUsers(ITestContext context) {
		Map hm = new HashMap();
		hm.put("name", "pavan");
		hm.put("job", "tainer");

		String id = given().contentType("application/json")
				.body(hm).when()
				.post("https://reqres.in/api/users")
				.then()
				.extract().path("id").toString();
		context.getSuite().setAttribute("userID", id);
		
		System.out.println("Created user ID: " + id);
	}
}
