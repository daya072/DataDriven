Feature: SignOn Feature

@test
Scenario Outline: Signon
When user logged in using "<IP_URL>", "<IP_UserName>" and "<IP_Password>"
Then dashboard page is displayed
Examples:
|IP_URL|IP_UserName|IP_Password|
|https://paytm.com/flights|daya072@gmail.com|RetHme@17|