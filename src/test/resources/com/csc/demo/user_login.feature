Feature: Salesforce User Login
	To allow users to login/logout into/from salesforce home page

Scenario: Successfully Login
	Given user is on https://login.salesforce.com/
	When user enters a valid credential
	Then user goes to salesforce home page

Scenario: User Logout
    Given user is logged
    When user click logout
    Then user goes back to https://login.salesforce.com/