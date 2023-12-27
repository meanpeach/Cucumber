Feature: Testing Login Functionality for SauceLab
  Background: Navigation
    Given User navigates to the website 'https://www.saucedemo.com/'

  Scenario Outline: Happy Path Login
    When User provides '<username>' and password 'secret_sauce' to the SauceLoginPage
    Then User validates title 'Swag Labs' from SauceMainPage
    Examples:
      | username |
      | standard_user |
      | problem_user |
      | performance_glitch_user|
      | error_user |
      | visual_user |




