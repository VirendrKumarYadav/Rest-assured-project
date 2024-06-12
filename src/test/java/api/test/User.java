package api.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import api.endpoints.Endpoints;
import api.payload.UserPayloads;
import io.restassured.response.Response;

public class User {

	Faker faker;
	UserPayloads userPayload;
	
	@BeforeClass
	public void setUpData() {
		faker=new Faker();
		userPayload= new UserPayloads();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
			
	}
	
	
	@Test (priority = 1)
	public void createUser() {
		
		Response res=Endpoints.createUser(userPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	

	@Test(priority = 2)
	public void getUser() {
		
		Response res= Endpoints.getUser(this.userPayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);

	}
	@Test(priority = 3)
	public void updateUser() {
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
	
		
		Response res= Endpoints.updateUser(this.userPayload.getUsername(),userPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);

	}
	@Test(priority = 4)
	public void deleteUser() {
		
		Response res= Endpoints.getUser(this.userPayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);

	}
}
