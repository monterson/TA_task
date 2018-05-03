package stepDefinitions.pageSteps;

import cucumber.api.java8.En;
import pageObjects.MainPage;
import stepDefinitions.core.TestContext;
import utils.browsers.Browser;

public class MainPageStepDefintions implements En {

    private Browser browser;
    private MainPage mainPage;

    public MainPageStepDefintions(TestContext context) {
        browser = context.getBrowser();
        mainPage = new MainPage(browser);

        Given("^I open board menu$", () -> {
            mainPage.clickBoardLink();
        });
    }
}



