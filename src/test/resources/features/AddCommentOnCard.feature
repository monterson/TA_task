Feature: Adding comment on card

  @SmokeTests
  Scenario Outline: Add comment on card
    Given I log in to the application with default credentials
    And I proceed to the board <boardName>
    When I open the card <cardName>
    And I add comment <comment> on the card
    Then I verify that the comment is visible on the card <cardName>
    Examples:
      | boardName   | cardName | comment      |
      | "TestBoard" | "Test1"  | "New Comment |
