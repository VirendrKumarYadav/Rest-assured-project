package day1;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class HTTP_Requests {

//	@Test
//	void getUsers() {
//		given()
//				.when().get("https://reqres.in/api/users?page=2")
//
//				.then().statusCode(200).body("page", equalTo(2)).log().all();
//	}
//
//	String res = "";
//
//	@Test
//	public void createUser() {
//		Map hm = new HashMap();
//		hm.put("name", "pavan");
//		hm.put("job", "tainer");
//
//		res = given().contentType("application/json").body(hm)
//
//				.when().post("https://reqres.in/api/users")
//				.then().
//				extract().path("id").toString();
//				
//		System.out.println(res);
//
//	}
//
//	@Test
//	public void updateUser() {
//		Map hm = new HashMap();
//		hm.put("name", "virendra");
//		hm.put("job", "teacher");
//
//	 given().contentType("application/json").body(hm)
//
//				.when().patch("https://reqres.in/api/users/515")
//				
//				.then().statusCode(200).log().all();
//
//	
//
//	}
//	@Test
//	public void deleteUser() {
//	
//	 given().contentType("application/json")
//
//				.when().delete("https://reqres.in/api/users/515")
//				
//				.then().statusCode(204).log().all();
//
//	
//
//	}
	
	@Test
	public void hitUrl() {
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when().get("https://reqres.in/api/users/2")
		
		
		.then()
		.statusCode(200)
		.body("data.id", equalTo(2))
		.log().all();
		
	}
}
