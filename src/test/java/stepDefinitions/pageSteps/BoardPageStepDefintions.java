package stepDefinitions.pageSteps;

import cucumber.api.java8.En;
import pageObjects.BoardPage;
import stepDefinitions.core.TestContext;
import utils.browsers.Browser;

public class BoardPageStepDefintions implements En {

    private Browser browser;
    private BoardPage boardPage;

    public BoardPageStepDefintions(TestContext context) {
        browser = context.getBrowser();
        boardPage = new BoardPage(browser);

        When("^I proceed to the board \"([^\"]*)\"$", (String boardName) -> {
            boardPage.clickOnTile(boardName);
        });


    }


}



