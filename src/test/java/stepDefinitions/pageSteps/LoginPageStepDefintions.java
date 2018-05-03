package stepDefinitions.pageSteps;

import cucumber.api.java8.En;
import pageObjects.LoginPage;
import stepDefinitions.core.TestContext;
import utils.browsers.Browser;

public class LoginPageStepDefintions implements En {

    private Browser browser;
    private LoginPage loginPage;

    public LoginPageStepDefintions(TestContext context) {

        browser = context.getBrowser();
        loginPage = new LoginPage(browser);

        Given("^I log in to the application with default credentials$", () -> {
            loginPage.login("piotr.wisniewski@hotmail.com", "P@ssw0rd1");
        });
    }
}



