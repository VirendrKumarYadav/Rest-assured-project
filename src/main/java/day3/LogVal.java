package day3;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;


public class LogVal {

	@Test
	public void getLog() {
		given()
				.when().get("https://www.google.com")
				
				.then()
//				.log().body()
//		        .log().cookies()
//		        .log().headers()
//		        .log().status();
				.log().all();
		        
     
		
	}

}
