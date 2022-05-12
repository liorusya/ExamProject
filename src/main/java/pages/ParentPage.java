package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import static org.hamcrest.CoreMatchers.containsString;

abstract public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    WebDriverWait webDriverWait10, webDriverWait15;
    protected String baseUrl = "https://demoqa.com";

    @FindBy(xpath = ".//*[@title='Ad.Plus Advertising']")
    private WebElement bannerOnTheBottom;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(
                new HtmlElementDecorator(
                        new HtmlElementLocatorFactory(webDriver))
                , this);
        webDriverWait10 = new WebDriverWait(webDriver, 10);
        webDriverWait15 = new WebDriverWait(webDriver, 15);
    }

    public abstract String getRelativeUrl();

    protected void checkUrl() {
        Assert.assertEquals("Invalid page"
                , baseUrl + getRelativeUrl()
                , webDriver.getCurrentUrl());
    }

    protected void checkUrlWithPattern() {
        Assert.assertThat("Invalid page"
                , webDriver.getCurrentUrl()
                , containsString(baseUrl + getRelativeUrl()));
    }

    protected void enterTextInToElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info((text + " was inputted in the " + getElementName(webElement)));

        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private String getElementName(WebElement webElement) {
        String elementName = "";
        if (webElement instanceof TypifiedElement) {
            elementName = " '" + ((TypifiedElement) webElement).getName() + "' ";
        }
        return elementName;
    }

    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement)).click();
            logger.info((getElementName(webElement) + "WebElement clicked"));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }


    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element  " + e);
        Assert.fail("Can not work with element  " + e);
    }

    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            if (state) {
                logger.info("Element is displayed " + getElementName(webElement));
            } else {
                logger.error("Element is NOT  displayed");
            }
            return state;
        } catch (Exception e) {
            logger.error("Element is NOT  displayed");
            return false;
        }
    }

    protected void selectTextInDropDown(WebElement dropDown, String text) {
        try { //get all elements in Dropdown
            Select select = new Select(dropDown);
            // choose by visible text
            select.selectByVisibleText(text);
            logger.info(text + " was selected in Dropdown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }

    // the method is faster than select by text
    protected void selectValueInDropDown(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info(value + " was selected in Dropdown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    //scroll down to an element in Selenium until it will be visible????null
    protected void scrollDownUntilElementDisplayed(WebElement webElement) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].scrollIntoView();", webElement);
            //  WebDriverWait webDriverWait10 = this.webDriverWait10;
            logger.info("Scrolled down to the element " + webElement);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void closeBannerOnThePage() {
        clickOnElement(bannerOnTheBottom);

    }

}
