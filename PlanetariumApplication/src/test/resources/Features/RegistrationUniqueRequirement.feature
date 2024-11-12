@RegistrationUniqueRequirement
Feature: RegistrationUniqueRequirement

	@PLAN-TC-12 @JREQ-PLAN-4 @JREQ-PLAN-5 @JREQ-PLAN-14 @JREQ-PLAN-15 @JREQ-PLAN-16 @JREQ-PLAN-17 @JREQ-PLAN-18 @JREQ-PLAN-19 @AIO-FOLDER-Sprint_2/User_Registration
	Scenario Outline: Automated User Registration Unique Username Requirement
	Validating Users can open a new User account with the Planetarium when they provide valid credentials and the username is unique, and that they are rejected when they dont provide valid credentials or the username is not unique. 
		Given The user is on the login page at URL "<Login Page URL>"
		When the user clicks the registration button
		When The user enters the username "<Username>"
		When The user enters the password "<Password>"
		And The user clicks the register button
		And The user clicks the registration button
		Then Then an alert should appear "<User Created>" for "<Username>"
		And The "<User redirected to login page result>"

	Examples: 
		| Username | Password                       | User Created     | User redirected to login page result |
		| Robin    | BatmanAndRobinToTheRescue20202 | User Created     | User redirected to login page        |
		| Batman   | BatmanAndRobinToTheRescue20202 | User Not Created | User remains on creation page        |