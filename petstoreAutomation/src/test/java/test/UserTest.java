package test;

import com.github.javafaker.Faker;

import endpoints.UserEndPoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import payload.User;

public class UserTest {
	// create data
	Faker faker;
	User userPayload;
	
	public Logger logger;
	@BeforeClass
	public void setupData()
	{
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger=LogManager.getLogger(getClass());
	}
	@Test(priority=1)
	public void testPostUser()
	{
		Response res=UserEndPoints.createUser(userPayload);// it will return hole response
		res.then().log().all();
		//res.statusCode();
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	  @Test(priority=2) 
	  public void testGetUserByName() { 
	  Response res=UserEndPoints.readUser(this.userPayload.getUsername()); // it will return only username 
	  res.then().log().all();
	  Assert.assertEquals(res.getStatusCode(), 200); }
	  
	  @Test(priority=3) 
	  public void testPutUser() { //update data using payload
	  userPayload.setFirstname(faker.name().firstName());
	  userPayload.setLastname(faker.name().lastName());
	  userPayload.setEmail(faker.internet().safeEmailAddress());
	  
	  
	  Response res=UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);//existing username along with updated payload 
	  res.then().log().all();
	  //res.then().log().body().statusCode(200); //chai assertion
	  //res.statusCode();
	  
	  Assert.assertEquals(res.getStatusCode(), 200); // testNG assertion
	  
	  //checking data after updation //again send get user 
	  Response resAfterUpdation=UserEndPoints.readUser(this.userPayload.getUsername()); // it will return only username 
	  res.then().log().all();
	  Assert.assertEquals(res.getStatusCode(), 200); }
	  
	  @Test(priority=4) public void testDeleteUserByName() {
	 Response res=UserEndPoints.deleteUser(this.userPayload.getUsername());
	  Assert.assertEquals(res.getStatusCode(), 200); }
	  
	 	
}
