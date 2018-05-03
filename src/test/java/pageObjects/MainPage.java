package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.browsers.Browser;

public class MainPage extends AbstractBasePage {

    public MainPage(Browser browser) {
        super(browser);
    }

    @FindBy(css = "[class = 'home-tab-link'] .icon-board")
    private WebElement linkToBoard;

    @Override
    public void initializePageFactory() {
        PageFactory.initElements(new AjaxElementLocatorFactory(browser.getDriver(), 15), this);
    }

    public void clickBoardLink() {
        this.linkToBoard.click();
    }
}
