@regression
Feature: Testing Client Search and Order Functionalities

  Background: User logins and proceeds to clientsPage
    Given User provides username and password to the loginPage
    When User clicks Clients button

  Scenario: Happy Path Client Name Search Functionality
    And User provides 'ad' in the search bar in the clientsPage
    Then User validates all the names contain 'ad' in the search result

  Scenario: Happy Path Client Email Search Functionality
    And User provides a word 'gmail' in the search bar in the clientsPage
    Then User validates all the emails contain 'gmail' in the search result

  Scenario: Happy Path Client Search Box Functionality
    And User provides 'gmail' in the search bar in the clientsPage
    And User clears the text in the search bar
    Then User validates the size of the list is bigger than 0

  Scenario: Happy Path Client Ascending Order Functionality
    When User clicks UpAndDown arrow next to the ID column on the Client list
    Then User validates that all the IDs are listed in Ascending Order

#  TC 7    Validate Client Search functionality
#  navigate to url: https://techtorialwork.com/worksuit/public/login
#  Enter correct email and password
#  Click login button
#  Click Clients on the left side of the page
#  Enter "ad" to search
#  Verify all the names contains "ad" in the search result
#  Enter "gmail" to search
#  Verify all the emails has "gmail" in the search result
#  Delete text in search box
#  Verify the size of list is bigger than 0
  
  #  TC 8     Validate order in Client page
#  navigate to url: https://techtorialwork.com/worksuit/public/login
#  Enter correct email and password
#  Click login button
#  Click Clients on the left side of the page
#  Click Up and Down arrow next to the ID on Client list
#  Validate all IDs are listed in ascending order


