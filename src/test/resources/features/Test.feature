Feature: Test Hotel Domain


@Test
Scenario: Login to Hotel
Given user is on hotel website
When user click on signin button
Then user should see signin page