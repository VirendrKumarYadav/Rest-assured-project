package api.endpoints;

import org.testng.annotations.Test;

import api.payload.UserPayloads;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class Endpoints {

	public static Response createUser(UserPayloads payload) {
		Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)

				.when().post(Route.POST_URL);
		return res;

	}

	public static Response getUser(String username) {
		Response res = given().pathParam("username", username).contentType(ContentType.JSON).accept(ContentType.JSON)

				.when().get(Route.GET_URL);
		return res;
	}

	public static Response updateUser(String username, UserPayloads payload) {
		Response res = given().pathParam("username", username).contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(payload)

				.when().put(Route.UPDATE_URL);

		return res;
	}

	public static Response DeleteUser(String username) {
		Response res = given().pathParam("username", username).contentType(ContentType.JSON).accept(ContentType.JSON)

				.when().delete(Route.DELETE_URL);
		return res;

	}

}
