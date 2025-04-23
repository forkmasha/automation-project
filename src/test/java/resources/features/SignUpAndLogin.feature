Feature: Signup and Login Functionality

 Background:
     Given open the main page

 Scenario Outline: Signup new user
      When click on the signup-login button
      * enter the name <userName> and email <email> for the signup
      * click on the signup button
      * enter the password <password>
      * enter the first name <firstName> and last name <lastName>
      * enter the address <address>
      * enter the country <country>, state <state> and city <city>
      * enter the zip code <zipCode>
      * enter the mobile number <mobileNumber>   
      * click on the create account button
      Then verify the success message "Account created!"
      * click on the continue button
      * click on the logout button
 Examples:
      | userName | email                 | password     | firstName | lastName | address     | country | state | city      | zipCode | mobileNumber |
      |"testuser"|"testuser594@gmail.com"|"testpassword"|"FirstName"|"LastName"|"123 Main St"|"Canada" | "NY"  |"New York" | "10001" | "1234567890" |
      |"premuser"|"premus45671@ukr.net"  |"testpassword"|"FirstName"|"LastName"|"123 Main St"|"India"  | "NY"  |"New York" | "387"   | "1232434300" |
 

 Scenario Outline: Login and logout existing user
      When click on the signup-login button
      * enter the email <email> for the login
      * enter the password <password> for the login
      Then click on the login button
      * verify the user is logged in as <userName>
      * click on the logout button
      * verify the user is logged out and the login page is displayed
 Examples:
      | userName | email                 | password     |
      |"testuser"|"testuser594@gmail.com"|"testpassword"|
      |"premuser"|"premus45671@ukr.net"  |"testpassword"|


 Scenario Outline: Delete account
      When click on the signup-login button  
      * enter the email <email> for the login
      * enter the password <password> for the login
      * click on the login button
      Then click on the delete account button
      * verify the account deletion message "ACCOUNT DELETED!"
 Examples:
      | email                   | password       |
      | "testuser594@gmail.com" | "testpassword" |
      | "premus45671@ukr.net"   | "testpassword" |