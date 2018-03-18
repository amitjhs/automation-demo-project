package demo.testng.page;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {


    protected WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }


    public BasePage clickOnLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
        return this;
    }


    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isElementPresent(final WebElement element) {
        try {
            element.getTagName();
        } catch (final NoSuchElementException ignored) {
            return false;
        } catch (final StaleElementReferenceException ignored) {
            return false;
        }
        return true;
    }

    public void waitForElement(WebElement element) throws Error {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void setElementInVisibleArea(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void MoveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
    }

    public void waitForPageLoad() {
        //wait.until((driver ->((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")));

        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }


    public void waitfor(int n)
    {
    	try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}