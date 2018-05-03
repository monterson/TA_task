package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.browsers.Browser;

public class ItemPage extends AbstractBasePage {

    public ItemPage(Browser browser) {
        super(browser);
    }

    @FindBy(css = "[class='comment-box-input js-new-comment-input']")
    private WebElement commentField;

    @FindBy(css = ".comment-controls  input.primary.confirm")
    private WebElement saveButton;

    @FindBy(css = ".dialog-close-button")
    private WebElement closeButton;

    @Override
    public void initializePageFactory() {
        PageFactory.initElements(new AjaxElementLocatorFactory(browser.getDriver(), 15), this);
    }

    public void setNewComment(String comment) {
        this.commentField.sendKeys(comment);
    }

    public void saveChanges() {
        this.saveButton.click();
    }

    public void pressCloseButton() {
        this.closeButton.click();
    }
}
