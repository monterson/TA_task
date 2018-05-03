package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.Status;
import utils.WaitHelpers;
import utils.browsers.Browser;

import java.util.List;

public class TablePage extends AbstractBasePage {

    public TablePage(Browser browser) {
        super(browser);
    }

    @Override
    public void initializePageFactory() {
        PageFactory.initElements(new AjaxElementLocatorFactory(browser.getDriver(), 15), this);
    }

    @FindAll(@FindBy(css = ".js-list-content"))
    private List<WebElement> statusColumns;

    @FindAll(@FindBy(css = ".list-card-details"))
    private List<WebElement> listOfCards;

    @FindBy(css = ".icon-comment")
    private WebElement commentIcon;

    By cardLocator = By.cssSelector(".list-card-title");
    By commentIconLocator = By.cssSelector(".icon-comment");

    String cardWithTextLocator = "//span[text()='XXX']/../..";

    public WebElement getColumnByStatus(Status status) {
        if (status == Status.IN_PROGRESS) {
            return statusColumns.get(1);
        }
        if (status == Status.DONE) {
            return statusColumns.get(2);
        }
        return statusColumns.get(0);
    }

    private WebElement getCardByNumber(WebElement column, int number) {
        return column.findElements(cardLocator).get(number);
    }

    public WebElement getCardByName(String cardName) {
        String xpathToCard = cardWithTextLocator.replace("XXX", cardName);
        for (WebElement card : listOfCards) {
            List<WebElement> results = card.findElements(By.xpath(xpathToCard));
            if (results.size() > 0) {
                return results.get(0);
            }
        }
        throw new Error("No matching cards found");
    }

    public void openCardByName(String cardName) {
        getCardByName(cardName).click();
    }

    public boolean isCommentVisibleOnCard(String cardName) {
        WaitHelpers.waitForJQuery(browser.getDriver());
        int results = getCardByName(cardName).findElements(commentIconLocator).size();
        if (results >= 1) {
            return true;
        }
        return false;
    }

    public void dragAndDropCard(String cardName, Status columnName) {
        WebElement source = getCardByName(cardName);
        WebElement destination = getColumnByStatus(columnName);
        Actions action = new Actions(browser.getDriver());
        Action dragDrop = action.dragAndDrop(source, destination).build();
        dragDrop.perform();
    }

    public boolean isCardContainedInColumn(String cardName, Status columnName) {
        String xpathToCard = cardWithTextLocator.replace("XXX", cardName);
        WebElement statusColumn = getColumnByStatus(columnName);
        int results = statusColumn.findElements(By.xpath(xpathToCard)).size();
        if (results >= 0) {
            return true;
        }
        return false;
    }

    public boolean isCardVisible(String cardName) {
        return getCardByName(cardName).isDisplayed();
    }
}
