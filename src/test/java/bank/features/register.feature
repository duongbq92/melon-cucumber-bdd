
@register
Feature: Register/Login and New customer

  @register_login
  Scenario: Register and Login to system
    Given Get login page URL
    When Open Register page
    And Input to email textbox
    And Click to submit
    Then Get user and password infor
    When Back to Login page
    And Submit vaid infor to login form
    Then Home page display
	@new_customer
	Scenario Outline: New customer
    Given Open "New Customer" page
    When Input to "Customer Name" textbox with value "<CustomerName>"
    And Click to "f" radio button
    And Input to "Date of Birth" textbox with value "<DobIn>"
    And Input to "Address" textarea with value "<Address>"
    And Input to "City" textbox with value "<City>"
    And Input to "State" textbox with value "<State>"
    And Input to "PIN" textbox with value "<PIN>"
    And Input to "Mobile Number" textbox with value "<MobileNumber>"
    And Input to "E-mail" textbox with value "<E-mail>"
    And Input to "Password" textbox with value "<Password>"
    And Click to "Submit" button
    Then Succes message display with "Customer Registered Successfully!!!"
    And The valid value display at "Customer Name" with "<CustomerName>"
    And The valid value display at "Gender" with "<Gender>"
    And The valid value display at "Birthdate" with "<DobOut>"
    And The valid value display at "Address" with "<Address>"
    And The valid value display at "City" with "<City>"
    And The valid value display at "State" with "<State>"
    And The valid value display at "Pin" with "<PIN>"
    And The valid value display at "Mobile No." with "<MobileNumber>"
    And The valid value display at "Email" with "<E-mail>"
  Examples:
      | CustomerName | DobIn      | DobOut     | Gender | Address  | City    | State      | PIN    | MobileNumber  | E-mail              | Password|
      | Hana         | 10/04/2020 | 2020-10-04 | female	| Vinh loc | Sai gon | Binh Chanh | 123456 | 092313932     | quyduong2@gmail.com | kocopass|
    