package endpoints;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

// UserEndPoints.Java
// Create for perform create,Read,update,Delete requests the user API
public class UserEndPoints {

	public static Response createUser(User payload)
	{
		
		Response res=given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(payload)
		
		.when()
		.post(Routes.post_url);
		
		return res;
	}
	public static Response readUser(String userName)
	{
		
		Response res=given()
		  .pathParam("username", userName)
		  		
		.when()
		.get(Routes.get_url);
		
		return res;
	}
	public static Response updateUser(String userName,User payload)
	{
		Response res=given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .pathParam("username", userName)
		  .body(payload)
		
		.when()
		.put(Routes.update_url);
		
		return res;
	}
	public static Response deleteUser(String userName)
	{
		
		Response res=given()
		  .pathParam("username", userName)
		  		
		.when()
		.get(Routes.delete_url);
		
		return res;
	}
	
}
