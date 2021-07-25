Feature: NewTours Feature

@login
Scenario Outline: Sign On to New Tours demo site
When user logged in using "<IP_URL>", "<IP_UserName>" and "<IP_Password>"
Then dashboard page is displayed
Examples:
|IP_URL|IP_UserName|IP_Password|
##@dataSource@TestData.xlsx@NewTours
|http://demo.guru99.com/test/newtours/|mercury|mercury|