Feature: Web form functionality
@Test

  Scenario: Test web form
    Given the user navigates to the web form
    Then the page title should be "Web form"
@Test

  Scenario: Submit the form
    Given the user navigates to the web form
    When the user submits the form
    Then the message should be "Received!"
@Test
  Scenario: User fills out the web form
    Given the user navigates to the web form
    When the user fills out the form
    When the user submits the form
    Then the message should be "Received!"
