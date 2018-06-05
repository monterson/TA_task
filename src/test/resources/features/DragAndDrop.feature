Feature: Drag and Drop existing card

  @SmokeTests
  Scenario Outline: Drag and Drop card
    Given I log in to the application with default credentials
    And I open board menu
    And I proceed to the board <boardName>
    When I move the card <cardName> to the <columnName> column
    Then I verify that the <cardName> card is contained in the column <columnName>
    Examples:
      | boardName   | cardName | columnName    |
      | "TestBoard" | "Test2"  | "In progress" |
