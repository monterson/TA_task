package stepDefinitions.pageSteps;

import cucumber.api.java8.En;
import pageObjects.ItemPage;
import stepDefinitions.core.TestContext;
import utils.browsers.Browser;

public class ItemPageStepDefintions implements En {

    private Browser browser;
    private ItemPage itemPage;

    public ItemPageStepDefintions(TestContext context) {

        browser = context.getBrowser();
        itemPage = new ItemPage(browser);




        When("^I add comment (.*) on the card$", (String comment) -> {
            itemPage.setNewComment(comment);
            itemPage.saveChanges();
            itemPage.pressCloseButton();

        });

    }


}



