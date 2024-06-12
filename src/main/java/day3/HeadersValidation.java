package day3;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersValidation {

	@Test(priority = 1)
	public void getHeaders() {
		Response res=given()
				.when().get("https://www.google.com");

		Headers cookies=res.getHeaders();
		for(Header cooki:cookies.asList()) {
			System.out.println(cooki.getName()+" : "+ cooki.getValue());
		}
		
	}
	@Test(priority = 2)
	public void setHeaders() {
		  given()
		     
				.when().get("https://www.google.com")
				
				.then()
				.header("Content-Type", "text/html; charset=ISO-8859-1")
				.and()
				.header("Content-Encoding", "gzip")
				.and()
				.header("Server", "gws")
				.log().all();
		  
		
		
	}
	
}
