 @datatable
Feature: data table

   @datatable_step
  Scenario: Scenario input <Username> and <Password>
    Given Open Facebook application 
    When Input email and pass textbox 
    |Username|Password|
    |duong01@gmail.com|123456|
    |duong04@gmail.com|123456|
    And Click to Submit button
    And Close application
    
    #Examples:
    #|Username				|Password|
    #|duong@gmail.com|123456|
    
    @datatable_scenario
  	Scenario Outline: Scenario have parameter
	    Given Open Facebook application 
	    When Input email textbox with "<Username>"
	    And Input password textbox with "<Password>"
	    And Click to Submit button
	    And Close application
	    	Examples:
		    |Username				|Password|
		    |duong@gmail.com|123456|
		    |duong01@gmail.com|123456|