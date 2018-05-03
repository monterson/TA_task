**About project** <br />
This project includes a TA framework (with some examples) for testing of the trello.com page.<br />
Technology:  Selenium WD + Cucumber JVM. <br />
Page Object Pattern is used for the design of the page. <br />
To avoid a waits command, AjaxElementLocatorFactory is used for intialization of the page elements.<br />
Dependency Injection mechanism  (PicoContainer) is applied to deliver one instance of webdriver to every page.<br />
Due to the time limitation, some functions are hardcoded (credentials, browsers)

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
1. Due to the lack of "restore" functionality, the card that is moved in the 'Drag and Drop' test, should be changed to another (in feature file) before the next test execution (or state of the board should be reverted).
2. Testdata -> TestData.png
 
