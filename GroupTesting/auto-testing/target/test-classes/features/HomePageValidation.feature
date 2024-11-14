Feature: HomePageValidation

	Scenario Outline: Automated User Homepage Visibility Validation
	Validating that Users that enter valid credentials and are logged in can see the planets and moons that they created on their dashboard. While Users who enter invalid credentials should not be able to reach the homepage. 
		Given The user is on the login page at URL "<Login Page URL>"
		When The user enters the username on the login page "<Username>"
		When The user enters the password on the login page "<Password>"
		When The user clicks the login button
		Then The user should be redirected to home page

	Examples: 
		| Username | Password                       | Home Page URL                     | User Redirected to Home Page | Login Page URL         |
		| Batman   | I am the night                 | http://localhost:8080/planetarium | User redirected to Home Page | http://localhost:8080/ |
		| Robin    | BatmanAndRobinToTheRescue20202 | http://localhost:8080/planetarium | User redirected to Home Page | http://localhost:8080/ |