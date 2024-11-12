@UserRegistrationUsernamePassword
Feature: UserRegistrationUsernamePassword


	Scenario Outline: Automated User Registration Username/Password Length Requirements 
	Validating Users can open a new User account with the Planetarium when they provide valid username/password that meet the character limit, and that they are rejected when they dont provide valid username/password that meet the character limit.
		Given The user is on the login page at URL "<Login Page URL>"
		When the user clicks the Registration button
		When the user enters the username "<Username>"
		And the user enters the password "<Password>"
		And the user clicks the register button
		Then Then an alert should appear "<Account Creation Result>" for "<Username>"
		And The "<User redirected to login page result>"

	Examples: 
		| Login Page Url         | Username                        | Password                        | Account Creation Result | User redirected to login page |
		| http://localhost:8080/ | (no values)                     | (no values)                     | User Created            | User redirected to login page |
		| http://localhost:8080/ | (no values)                     | GordonIsMyHeroForeverGoodMan11  | User Created            | User redirected to login page |
		| http://localhost:8080/ | (no values)                     | LexLuthorIsSchemingAgainOhNo!!! | User Not Created        | User remains on creation page |
		| http://localhost:8080/ | BatmanAndRobinToTheRescue20202  | (no values)                     | User Created            | User redirected to login page |
		| http://localhost:8080/ | BatmanAndRobinToTheRescue20202  | GordonIsMyHeroForeverGoodMan11  | User Created            | User redirected to login page |
		| http://localhost:8080/ | BatmanAndRobinToTheRescue20202  | LexLuthorIsSchemingAgainOhNo!!! | User Not Created        | User remains on creation page |
		| http://localhost:8080/ | JokerAndRiddlerAreAtItAgain1010 | (no values)                     | User Not Created        | User redirected to login page |
		| http://localhost:8080/ | JokerAndRiddlerAreAtItAgain1010 | GordonIsMyHeroForeverGoodMan11  | User Not Created        | User remains on creation page |
		| http://localhost:8080/ | JokerAndRiddlerAreAtItAgain1010 | LexLuthorIsSchemingAgainOhNo!!! | User Not Created        | User remains on creation page |