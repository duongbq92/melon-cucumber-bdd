 @login
Feature: Face book login page

Background:
Given Open Facebook application 

  @displayed
  Scenario: Verify login page
    #Given Open Facebook application 
    Then Verify email textbox is displayed
    And Verify password textbox is displayed
    And Close application


  @param_mark
  Scenario: Scenario have parameter
    #Given Open Facebook application 
    When Input email textbox with "duong1@gmail.com"
    And Input password textbox with "123456"
    And Click to Submit button
    And Close application
    
  @param_no_mark
  Scenario: Scenario have no parameter
    #Given Open Facebook application 
    When Input email textbox with duong1@gmail.com
    And Input password textbox with 123456
    And Click to Submit button
    And Close application
   