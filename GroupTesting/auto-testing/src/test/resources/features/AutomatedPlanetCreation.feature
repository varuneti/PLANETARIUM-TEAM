@AutomatedPlanetCreation
Feature: AutomatedPlanetCreation

	@PLAN-TC-28 @JREQ-PLAN-9 @JREQ-PLAN-20 @JREQ-PLAN-21 @AIO-FOLDER-Sprint_2/Automated_Planet_Creation
	Scenario Outline: Automation Planet Creation Validation
	Validating that logged in Users can create Planets after entering valid information and validating that users cannot create planets when they input invalid information. 
		Given The user is on the login page at URL "<Login Page URL>"
		When The user enters the username on the login page "<Username>"
		And The user enters the password "<Password>"
		And The user clicks the login button
		Then The "<User Redirected to Home Page>"
		When The user clicks on dropdown menu
		And The user selects Planet option
		And The user enters a planet name "<Planet Name>"
		And The user clicks the choose file button
		And The user inserts photo "<Photo Insertion>"
		And The user clicks the submit button
		Then "<Creation>"

	Examples: 
		| Username | Password       | Login Page URL         | User Redirected to Home Page | Home Page URL                     | Photo Insertion | Planet Name | Creation    |
		| Batman   | I am the night | http://localhost:8080/ | User redirected to Home Page | http://localhost:8080/planetarium | No Photo        | Mars        | Not Created |
		| Batman   | I am the night | http://localhost:8080/ | User redirected to Home Page | http://localhost:8080/planetarium | Photo           | Mars        | Not Created |
		| Batman   | I am the night | http://localhost:8080/ | User redirected to Home Page | http://localhost:8080/planetarium | No Photo        | Kypton      | Created     |
		| Batman   | I am the night | http://localhost:8080/ | User redirected to Home Page | http://localhost:8080/planetarium | Photo           | Kypton      | Created     |
		| Batman   | I am the night | http://localhost:8080/ | User redirected to Home Page | http://localhost:8080/planetarium | No Photo        | (No Values) | Not Created |
		| Batman   | I am the night | http://localhost:8080/ | User redirected to Home Page | http://localhost:8080/planetarium | Photo           | (No Values) | Not Created |