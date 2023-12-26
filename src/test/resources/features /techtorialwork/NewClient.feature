@regression
Feature: Testing New Client Create, Search and Order Functionality

  Scenario: Happy Path create functionality for new client
    Given User provides username and password to the loginPage
    When User clicks Clients button
    And User clicks Add client and provides 'Alina Peres', 'alina99@gmail.com', 'United States','1234567891' for ClientPage
    And User provides company information 'Techtorial', 'http://www.doeconstruction.com','1234567891'
    And User provides address information '456 Oak Avenue, Springfield, IL, 62701',' 789 Birch Lane, Springfield, IL, 62702'
    Then User clicks save button and validates 'Alina Peres','Techtorial','alina99@gmail.com','Active' from table.


#  TC 6    Validate adding new client
#  navigate to url: https://techtorialwork.com/worksuit/public/login
#  Enter correct email and password
#  Click login button
#  Click Clients on the left side of the page
#  Click Add client button
#  "Enter a client details with the following information:
#  (You can also create your own mock data)
#
#  Name: John Doe
#  Email: john.doe@example.com
#  Country: United States
#  Phone Number: +1 (555) 123-4567
#
#  Company Information:
#  Name: Doe Construction Inc.
#  Email: contact@doeconstruction.com
#  Website: http://www.doeconstruction.com
#  Phone: (555) 001-2345
#  Address: 456 Oak Avenue, Springfield, IL, 62701
#  Shipping Address: 789 Birch Lane, Springfield, IL, 62702"
#  Click Save button
#  Verify Client information is saved
