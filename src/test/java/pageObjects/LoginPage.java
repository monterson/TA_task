package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.browsers.Browser;

public class LoginPage extends AbstractBasePage {

    @FindBy(id = "user")
    private WebElement inputUser;
    @FindBy(id = "password")
    private WebElement inputPassword;
    @FindBy(id = "login")
    private WebElement buttonLogin;

    public LoginPage(Browser browser) {
        super(browser);
    }

    public void login(String user, String password) {
        this.inputUser.sendKeys(user);
        this.inputPassword.sendKeys(password);
        this.buttonLogin.click();
    }

    @Override
    public void initializePageFactory() {
        PageFactory.initElements(new AjaxElementLocatorFactory(browser.getDriver(), 15), this);
    }
}
