package chaning;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class UpdateUser {

	@Test
	public void updateUsers(ITestContext context) {
		int id=(Integer) context.getSuite().getAttribute("userID");

		Map hm = new HashMap();
		hm.put("name", "virendra");
		hm.put("job", "teacher");

	      given().
	      contentType("application/json").body(hm)

	      .when().patch("https://reqres.in/api/users/"+id)
				
				.then().statusCode(200).log().all();

	
	}
}
