Feature: Scroll the card after zoom

  @SmokeTests
  Scenario Outline: Scrollbar functionality
    Given I log in to the application with default credentials
    And I proceed to the board <boardName>
    When I use zoom functionality with value <zoom> percent
    And  I scroll to the <cardName> card
    Then The <cardName> card is visible
    Examples:
      | boardName   | cardName | zoom |
      | "TestBoard" | "Test8"  | 170  |
