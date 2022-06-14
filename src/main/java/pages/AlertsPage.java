package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends ParentPage {
    Logger logger = Logger.getLogger(getClass());

    public AlertsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getRelativeUrl() {
        return "/alertsWindows";
    }

    @FindBy(className = "main-header")
    private WebElement alertsTitle;

    public AlertsPage checkIsRedirectedToTheAlertsPage() {
        checkUrl();
        Assert.assertTrue("Alerts Title is not displayed",
                isElementDisplayed(alertsTitle));
        return this;
    }

    @FindBy(xpath = "//*[@class='element-list collapse show']//li[2]")
    //  //*[@id='item-1']   ".//span[(text()='Alerts')]"  //*[@class='element-list collapse show']//li[2]
    protected WebElement alertsTabMenuItem;

    public AlertsPage openTheAlertTab() {
        // webDriver.navigate().refresh();
        if (!isElementDisplayed(alertsTabMenuItem)) {
            scrollDownUntilElementDisplayed(alertsTabMenuItem);
            logger.info("scrolled down");
            JavascriptExecutor jse = (JavascriptExecutor) webDriver;
            jse.executeScript("arguments[0].click();", alertsTabMenuItem);
            logger.info("JSE clicked alertsTabMenuItem");
        } else {
            JavascriptExecutor jse = (JavascriptExecutor) webDriver;
            jse.executeScript("arguments[0].click();", alertsTabMenuItem);
            logger.info("JSE clicked alertsTabMenuItem element");
        }

        return this;
    }


}
