@regression
Feature: Testing New Order Functionality

  Background: User logins and presses AddNewOrder button
    Given User provides username and password to the loginPage
    And  User clicks Orders button on the left side
    And   User clicks AddNewOrder button in the Order page



  Scenario: Happy Path New Order Functionality
    And   User clicks FilterByCategory button in between SelectProduct and Add fields
    Then  User validates 'Select Product Category','Select the client to show billing address.' are displayed
    And   User validates 'Add Shipping Address' button and 'Add at-least 1 item.' are displayed

  Scenario: Happy Path Client Select Functionality in Orders
    And User validates 'Select the client to show billing address.' is displayed
    And User validates 'Add Shipping Address' button is displayed
    When User selects client 'David Wilson'
    Then User validates Billing Address is '890 Maple Avenue, Seattle, WA, 98102'
    And User validates Shipping Address is '123 Rainier Blvd, Seattle, WA, 98104'

  Scenario: Happy Path Product Select Functionality
    And User selects client 'David Wilson'
    When User selects product 'Mid-Size Wheeled Paver'
    Then User validates Total "257400.00"

  Scenario: Happy Path Submit Order Functionality
    And User selects client 'David Wilson'
    And User selects product 'Mid-Size Wheeled Paver'
    When User inputs Client Note 'New product for the Wilson. The delivery date should be before January.'
    And User clicks Submit button
    Then User validates the order is for 'David Wilson' with '$257,400.00' on '26-12-2023' status is 'Pending'


#  TC 9     Validate new order page
#  navigate to url: https://techtorialwork.com/worksuit/public/login
#  Enter correct email and password
#  Click login button
#  Click Order on the left side of the page
#  Click Add New Order button
#  "Validate ""Select the client to show billing address."" is displayed
#  "
#  Validate "Add Shipping Address" button is displayed
#  Validate "Add at-least 1 item." text is displayed
#  Click filter button next to the Select Product
#  Validate Select Product Category is displayed

#  TC 10    Validate Adding New Order
#  navigate to url: https://techtorialwork.com/worksuit/public/login
#  Enter correct email and password
#  Click login button
#  Click Order on the left side of the page
#  Click Add New Order button
#  "Validate ""Select the client to show billing address."" is displayed
#  "
#  Validate "Add Shipping Address" button is displayed
#  Select client David Wilson
#  "Validate billing address: 890 Maple Avenue, Seattle, WA, 98102
#  "
#  "Validate Shipping Address: 123 Rainier Blvd, Seattle, WA, 98104
#  "
#  Select product : Mid-Size Wheeled Paver
#  Validate product is added total price is 257400
#  Add client note: "New product for the Wilson. The delivery date should be before January."
#  Click Submit button
#  Validate the order is added to the order page
#

