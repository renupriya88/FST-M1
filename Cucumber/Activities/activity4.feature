@activity4
Feature: Login Test
@NoExample
Scenario: Testing Login without Examples
   Given User is on the Login page
   When User enters "admin" and "password"
   Then Read the pages title and confirmation message
   And Quit the Browser