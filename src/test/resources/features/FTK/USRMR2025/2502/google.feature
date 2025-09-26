Feature: Validate search button on tools QA page

  Scenario: Validate tools QA page
    Given I load the tools qa page
    When I click tutorials bar icon
    Then I validate the list of menus visible
    And I close the window

  Scenario Outline: Validate tools QA page
    Given I load the tools qa page
    When I enter "<keywords>" in the searchbar
    And I close the window
    Examples:
        | keywords |
        | cypress |
        | WebIO |
        | Playwright |
        | Selenium |

  Scenario: Validate tools QA page
    Given I load the tools qa page
    When I enter each keywords in the searchbar
      | cypress |
      | WebIO |
      | Playwright |
      | Selenium |
    And I close the window

  @current
  Scenario: Validate tools QA page
    Given I load the tools qa page
    When I enter each keywords using maps in the searchbar
      | QA         | DEV         |
      | cypress    | java        |
      | WebIO      | .net        |
      | Playwright | csharp      |
      | Selenium   | vue.js      |
    And I close the window




