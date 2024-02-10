Feature: login functionality

Background:
Given user should  be on login page


Scenario: Test Login with invalid data
When user enters Invalid userid as "<Userid>" and entered Invalid password as "<Password>"
And click on login button
Then validation should be displayed

Examples:
| Userid | Password  |
| Admin  | Test@123  |
| Admin1 | Test@1234 |
| Admin2 | Test@1235 |

Scenario: valid login
When user enters valid userid and entered valid password
And click on login button

Scenario: Close WebBwowser
Then Close WebBwowser



