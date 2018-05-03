package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {

    public static Status ConvertStringToStatus(String stringStatus) {
        Status status;
        if (stringStatus.contains("To do")) {
            return Status.TO_DO;
        }
        if (stringStatus.contains("In progress")) {
            return Status.IN_PROGRESS;
        }
        if (stringStatus.contains("Done")) {
            return Status.DONE;
        }
        throw new Error("Unknown status");
    }

    public static void setZoomOnPage(WebDriver driver, String zoomValue) {
        String jsCommand = "document.body.style.zoom = 'XX%';";
        String zoomCommand = jsCommand.replace("XX", zoomValue);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(zoomCommand);
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
