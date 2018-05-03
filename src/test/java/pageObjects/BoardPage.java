package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.browsers.Browser;

import java.util.List;

public class BoardPage extends AbstractBasePage {

    @FindAll(@FindBy(css = "[class='board-tile']"))
    private List<WebElement> boardTiles;

    public BoardPage(Browser browser) {
        super(browser);
    }

    @Override
    public void initializePageFactory() {
        PageFactory.initElements(new AjaxElementLocatorFactory(browser.getDriver(), 15), this);
    }

    public WebElement getBoardTileByName(String name) {
        String locator = String.format(".board-tile [title ='%s'", name);
        List<WebElement> listOfTiles = this.boardTiles;
        for (WebElement tile : listOfTiles) {
            if (tile.findElements(By.cssSelector(locator)).size() > 0) {
                return tile;
            }
        }
        throw new Error("No matching tiles found");
    }

    public void clickOnTile(String name) {
        getBoardTileByName(name).click();
    }
}
