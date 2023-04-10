Feature: Testing login functionality

  Scenario Outline: Checking login is successful with valid credentials
    Given open browser
    And user navigates to login page
    When user entering <username> and <password>
    And user clicking on login
    Then user is navigated to home page

    Examples: 
      | username | password |
      | Raghav   |    12345 |
      | Ele      |    12345 |
