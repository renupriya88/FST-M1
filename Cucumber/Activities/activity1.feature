@activity1
Feature: First Test


Scenario: Opening a webpage using Selenium
  Given user is on the google website
  When user types cheese and hits enter
  Then we should see the number of results
  And close the browser