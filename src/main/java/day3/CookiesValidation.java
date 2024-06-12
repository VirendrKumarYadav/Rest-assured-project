package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesValidation {

	
	String cookies="";
	@Test(priority = 1)
	public void getCookies() {
		Response res=given()
				.when().get("https://www.google.com");

		Map<String,String> cookies=res.getCookies();
		for(String cooki:cookies.keySet()) {
			System.out.println(cooki+" : "+cookies.get(cooki));
		}
		
	}

//	@Test(priority = 2)
	public void getUsers() {
		given()

				.when().get("https://www.google.com")

				.then().cookie("AEC", "123456789").log().all();
	}

}
