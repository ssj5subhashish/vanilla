package amazon.utils;

import amazon.factories.DriverFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CommonUtils {

    final static Logger logger = Logger.getLogger(CommonUtils.class);

    public static WebDriver _driver = DriverFactory.getDriver();
    public static WebDriverWait wait;
    public static Actions actions;

    private static int timeout = 10;

    public static void navigateToURL(String URL) {
        try {
            _driver.navigate().to(URL);
            logger.info("Navigated to the URL: "+URL);
        } catch (Exception e) {
            logger.error("FAILURE: URL did not load: " + URL);
            e.printStackTrace();
            throw new TestException("URL did not load");
        }
    }

    public static String getCurrentURL() {
        try {
            return _driver.getCurrentUrl();
        } catch (Exception e) {
            throw new TestException(String.format("Current URL is: %s", _driver.getCurrentUrl()));
        }
    }

    public static WebElement getElement(By selector) {
        try {
            return _driver.findElement(selector);
        } catch (Exception e) {
            System.out.println(String.format("Element %s does not exist - proceeding", selector));
        }
        return null;
    }

    public static String getElementText(By selector) {
        waitUntilElementIsDisplayedOnScreen(selector);
        try {
            return StringUtils.trim(_driver.findElement(selector).getText());
        } catch (Exception e) {
            System.out.println(String.format("Element %s does not exist - proceeding", selector));
        }
        return null;
    }

    public static void click(By selector) {
        WebElement element = getElement(selector);
        waitForElementToBeClickable(selector);
        try {
            element.click();
        } catch (Exception e) {
            throw new TestException(String.format("The following element is not clickable: [%s]", selector));
        }
    }

    public static void click(By elementBy, int implicitWaitSec) {
        boolean elementFound = false;
        _driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSec));
        waitForElementToBeVisible(elementBy);
        List<WebElement> elements = _driver.findElements(elementBy);
        for (WebElement el : elements) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(el));
                actions = new Actions(_driver);
                actions.click(el).build().perform();
                logger.info("Clicked on:" + el);
                elementFound = true;
                break;
            } catch (Exception e) {
                elementFound = false;
            }
        }
        if (!elementFound) {
            logger.error("WebElement not found hence unable to perform click operation for:" + elementBy.toString());
            throw new ElementNotVisibleException("WebElement not found hence unable to perform click operation: " + elementBy.toString());
        }
    }

    public static void scrollToThenClick(By selector) {
        WebElement element = _driver.findElement(selector);
        actions = new Actions(_driver);
        try {
            ((JavascriptExecutor) _driver).executeScript("arguments[0].scrollIntoView(true);", element);
            actions.moveToElement(element).perform();
            actions.click(element).perform();
        } catch (Exception e) {
            throw new TestException(String.format("The following element is not clickable: [%s]", element.toString()));
        }
    }

    public static void waitForElementToBeVisible(By selector) {
        try {
            wait = new WebDriverWait(_driver, timeout);
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        } catch (Exception e) {
            throw new NoSuchElementException(String.format("The following element was not visible: %s", selector));
        }
    }

    public static void waitUntilElementIsDisplayedOnScreen(By selector) {
        try {
            wait = new WebDriverWait(_driver, timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        } catch (Exception e) {
            throw new NoSuchElementException(String.format("The following element was not visible: %s ", selector));
        }
    }

    public static void waitForElementToBeClickable(By selector) {
        try {
            wait = new WebDriverWait(_driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(selector));
        } catch (Exception e) {
            throw new TestException("The following element is not clickable: " + selector);
        }
    }

    public static void switchToWindowOpened() {
        Set windowHandles = new LinkedHashSet<>();
        windowHandles.add(_driver.getWindowHandle());
        try {
            wait.until(d -> d.getWindowHandles().size() > windowHandles.size());
        } catch (TimeoutException e) {
            throw new NoSuchWindowException("New Window not found.", e);
        }
        _driver.switchTo().window(
                _driver.getWindowHandles().stream()
                        .filter(
                                handle -> !windowHandles.contains(handle)
                        ).findFirst().orElseThrow(
                                () -> new NoSuchWindowException("New Window not found.")
                        )
        );
        windowHandles.add(_driver.getWindowHandle());
    }

    public static void closeAndQuitDriver(){
        logger.info("Shutting down the browser");
        _driver.close();
        _driver.quit();
    }
}
