**Requirements:**
Java 8, maven, Chrome browser.

**How to start:**
1. Open cmd and go to the folder with project (it includes pom.xml)
2. put: '  mvn clean install  '
next run can be just 'mvn test'

**Tests:**
1. Add comment on card
2. Drag and Drop
3. Scroll

**Remarks:**
Due to the lack of "restore" functionality, the card that is moved in the 'Drag and Drop' test, should be changed to another (in feature file) before the next test execution (or state of the board should be reverted).
