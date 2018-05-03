package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.browsers.Browser;

public abstract class AbstractBasePage {

    protected Browser browser;

    public AbstractBasePage(Browser browser) {
        this.browser = browser;
        initializePageFactory();
    }

    public abstract void initializePageFactory();
}
