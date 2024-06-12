package day2;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.core.IsEqual;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo; 


public class DiffWayToCreatePost {
	
//	by hashmap
	@Test
	public void createUser() {
		Map hm = new HashMap();
		hm.put("name", "pavan");
		hm.put("job", "tainer");

		 given().contentType("application/json").body(hm)

				.when().post("https://reqres.in/api/users")

		 .then()
		 .statusCode(201)
		 .body("name", equalTo("pavan"))
		 .header("Content-type", equalTo("application/json; charset=utf-8"))
		 .log().all();
		 
	}
	
//	by org.json
	@Test
	public void createUserJsonObj() {
		JSONObject hm = new JSONObject();
		hm.put("name", "pavan");
		hm.put("job", "tainer");
		String course[]= {"java","Pythan"};
		hm.put("course", course);
		
		 given().contentType("application/json").body(hm.toString())

				.when().post("https://reqres.in/api/users")

		 .then()
		 .statusCode(201)
		 .body("name", equalTo("pavan"))
		 .header("Content-type", equalTo("application/json; charset=utf-8"))
		 .log().all();
		 
	}
	
//	by using POJO Class 
	@Test
	public void createUserPojoClass() {
		Pojo_Rquest hm = new Pojo_Rquest();
		hm.setName("pavan");
		hm.setLocation("tainer");
		String course[]= {"java","Pythan"};
		hm.setCourse( course);
		hm.setPhone("3456787654");
		
		 given().contentType("application/json").body(hm)

				.when().post("https://reqres.in/api/users")

		 .then()
		 .statusCode(201)
		 .body("name", equalTo("pavan"))
		 .header("Content-type", equalTo("application/json; charset=utf-8"))
		 .log().all();
		 
	}
//	by using external Json  `
	@Test
	public void createUserUsingExternalJson() throws JSONException, FileNotFoundException {
		JSONObject js=new JSONObject( new JSONTokener(new FileReader(new File(System.getProperty("user.dir")+"/body.json"))));
		
		 given().contentType("application/json").body(js.toString())

				.when().post("https://reqres.in/api/users")
		 .then()
		 .statusCode(201)
		 .body("name", equalTo("pavan"))
		 .header("Content-type", equalTo("application/json; charset=utf-8"))
		 .log().all();
		 
	}
}
