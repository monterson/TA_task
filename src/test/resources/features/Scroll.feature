Feature: Google Searching
  As a web surfer,
  I want to search Google,
  So that I can learn new things.

  @SmokeTests
  Scenario Outline: Scrollbar functionality
    Given I log in to the application with default credentials
    And I open board menu
    And I proceed to the board <boardName>
    When I use zoom functionality with value <zoom> percent
    And  I scroll to the <cardName> card
    Then The <cardName> card is visible
    Examples:
      | boardName   | cardName | zoom |
      | "TestBoard" | "Test8"  | 170  |
