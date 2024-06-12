package day4;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Iterator;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BodyValidation {

	boolean status = false;

	@Test
	void getUsers() {
		Response res = given().contentType(ContentType.JSON)

				.when().get("https://reqres.in/api/users?page=2");

		JSONObject jObj = new JSONObject(res.asString());
//		validation firstname
		for (int i = 0; i < jObj.getJSONArray("data").length(); i++) {
			String arrayData = jObj.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			System.out.println(arrayData);
			if (arrayData.equals("Michael")) {
				status = true;
			}
		}
		Assert.assertEquals(status, true);
		
//		validation email
		for (int i = 0; i < jObj.getJSONArray("data").length(); i++) {
			String arrayData = jObj.getJSONArray("data").getJSONObject(i).get("email").toString();
			System.out.println(arrayData);
			if (arrayData.equals("michael.lawson@reqres.in")) {
				status = true;
			}
		}
		Assert.assertEquals(status, true);
		
	//like that way we can verify all the body
		

	}

}
