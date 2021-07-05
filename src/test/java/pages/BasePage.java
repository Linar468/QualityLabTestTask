package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        return;
    }

    public void waitVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void click(WebElement element) {
        waitVisibility(element);
        element.click();

    }

    public void isElementDisplayed(WebElement element) {
        waitVisibility(element);
        assertTrue(element.isDisplayed());
    }

    public void writeText(WebElement element, String text) {
        waitVisibility(element);
        element.clear();
        element.sendKeys(text);
    }
}