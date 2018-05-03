package stepDefinitions.core;

import cucumber.api.java.After;
import utils.browsers.Browser;
import utils.browsers.ChromeBrowser;

public class TestContext {
    private static final String HTTPS_TRELLO = "https://trello.com/login";
    private Browser browser;

    public TestContext() {
        setupBrowser();
    }

    public void setupBrowser() {
        browser = new ChromeBrowser();
        browser.getDriver().manage().window().maximize();
        browser.getDriver().get(HTTPS_TRELLO);
    }

    public Browser getBrowser() {
        return browser;
    }

    @After
    public void tearDownBrowser() {
        browser.getDriver().quit();
    }

}
