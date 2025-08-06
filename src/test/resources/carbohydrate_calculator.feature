
Feature: Carbohydrate Calculator - Automated Tests

  Scenario: TC-001 - Valid Age Input
    Given I am on the carbohydrate calculator page
    When I enter valid demographic data with age "25"
    And I click the Calculate button
    Then I should see a carbohydrate result

  Scenario: TC-005 - Valid Male Input with Average Stats
    Given I am on the carbohydrate calculator page
    When I fill out the form with gender "Male", age "25", height "180", weight "75", and activity "Moderate: exercise 4-5 times/week"
    And I click the Calculate button
    Then I should see a carbohydrate result

  Scenario: TC-014 - Open in Chrome
    Given I open the carbohydrate calculator in Chrome
    Then the page title should contain "Carbohydrate Calculator"
