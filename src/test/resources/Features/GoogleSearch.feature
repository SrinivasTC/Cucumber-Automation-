Feature: feature to test google search functionality

  Scenario: Validate google search is working
    Given browser is open
    And user is on google search page
    When user enters text on google search page
    And hits enter
    Then user navigated to search results page
