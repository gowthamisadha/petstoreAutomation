package test;


import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import payload.User;
import utilities.DDT;


public class DDTests {

	@Test(priority=1,dataProvider="Data",dataProviderClass=DDT.class)
	public void testPostuser(String userID,String userName,String fname,String lname,String useremail,String pwd,String ph)
	{
		User userPayload=new User();
		userPayload.setId(Integer.parseInt(userID)); // Converting string format to number format
		userPayload.setUsername(userName);
		userPayload.setFirstname(fname);
		userPayload.setLastname(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		// Post request create user
		Response res=UserEndPoints.createUser(userPayload); // it will return only username 
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DDT.class)
	public void testDeleteUserByName(String userName)
	{
		Response res=UserEndPoints.deleteUser(userName);
		Assert.assertEquals(res.getStatusCode(), 200);
	}
}
