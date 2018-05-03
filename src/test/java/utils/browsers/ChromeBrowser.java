package utils.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser implements Browser{

    private WebDriver driver;

    public ChromeBrowser(){
        String chromeDriverPath = "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

}
