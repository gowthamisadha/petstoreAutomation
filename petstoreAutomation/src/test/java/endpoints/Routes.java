package endpoints;

/*
Swagger URL--> https://petstore.swagger.io

https://petstore.swagger.io/v2/user/
Create user(Post): https://petstore.swagger.io/v2/user/{username}
Get User(Get):https://petstore.swagger.io/v2/user/{username}
Update user(Put):https://petstore.swagger.io/v2/user/{username}
Delete user(Delete): https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {

   public static String base_url="https://petstore.swagger.io/v2";
   
   //user module
   
      public static String post_url=base_url+"/user";
      public static String get_url=base_url+"/user/{username}";
      public static String update_url=base_url+"/user/{username}";
      public static String delete_url=base_url+"/user/{username}";
    
      //Store module
          
        // here u will create store module URL'S
      
      // PET module
        // Here you will create pet module URL
   
}
