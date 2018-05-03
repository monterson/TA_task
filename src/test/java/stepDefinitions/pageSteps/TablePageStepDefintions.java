package stepDefinitions.pageSteps;

import cucumber.api.java8.En;
import org.openqa.selenium.WebElement;
import pageObjects.TablePage;
import stepDefinitions.core.TestContext;
import utils.CommonUtils;
import utils.Status;
import utils.browsers.Browser;

import static org.assertj.core.api.Assertions.assertThat;

public class TablePageStepDefintions implements En {

    private Browser browser;
    private TablePage tablePage;

    public TablePageStepDefintions(TestContext context) {

        browser = context.getBrowser();
        tablePage = new TablePage(browser);

        When("^I open the card \"([^\"]*)\"$", (String cardName) -> {
            tablePage.openCardByName(cardName);
        });

        Then("^I verify that the comment is visible on the card \"([^\"]*)\"$", (String cardName) -> {
            assertThat(tablePage.isCommentVisibleOnCard(cardName)).isTrue();
        });

        When("^I move the card \"([^\"]*)\" to the \"([^\"]*)\" column$", (String cardName, String columnName) -> {
            Status status = CommonUtils.ConvertStringToStatus(columnName);
            tablePage.dragAndDropCard("Test2", status);
        });

        Then("^I verify that the \"([^\"]*)\" card is contained in the column \"([^\"]*)\"$", (String cardName, String columnName) -> {
            Status status = CommonUtils.ConvertStringToStatus(columnName);
            assertThat(tablePage.isCardContainedInColumn(cardName, status)).isTrue();
        });


        When("^I use zoom functionality with value (.*) percent$", (String zoomValue) -> {
            CommonUtils.setZoomOnPage(browser.getDriver(), zoomValue);
        });

        When("^I scroll to the \"([^\"]*)\" card$", (String cardName) -> {
            WebElement card = tablePage.getCardByName(cardName);
            CommonUtils.scrollToElement(browser.getDriver(), card);
        });

        Then("^The \"([^\"]*)\" card is visible$", (String cardName) -> {
            assertThat(tablePage.isCardVisible(cardName)).isTrue();
        });
    }
}



