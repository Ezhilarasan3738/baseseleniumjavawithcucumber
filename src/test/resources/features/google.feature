Feature: Validate search button on tools QA page

  Scenario: Validate tools QA page
    Given I load the tools qa page
    When I click tutorials bar icon
    Then I validate the list of menus visible
    And I close the window