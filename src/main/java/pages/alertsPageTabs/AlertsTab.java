package pages.alertsPageTabs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class AlertsTab extends ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    public AlertsTab(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getRelativeUrl() {
        return "/alerts";
    }

    @FindBy(className = "main-header")
    private WebElement alertsTabTitle;
    @FindBy(id = "//*[@id='confirmButton']")
    //  //*[@id="confirmButton"]  .//div[@id='javascriptAlertsWrapper']//*[@id='confirmButton']
    private WebElement confirmButton;

    public AlertsTab checkIsRedirectedToTheAlertsPage() {
        checkUrl();
        isElementDisplayed(alertsTabTitle);
        Assert.assertTrue("AlertsTab Title is not displayed",
                isElementDisplayed(alertsTabTitle));
        return this;
    }

    public AlertsTab clickTheBtnToOpenConfirmBox() {
        // N1
//     confirmButton.click();
        clickOnElement(confirmButton);
//     logger.info(" clicked confirmButton");

        //N2
//            JavascriptExecutor jse = (JavascriptExecutor) webDriver;
//            jse.executeScript("arguments[0].click();", confirmButton);
//            logger.info("The confirmButton was clicked");

        //N3

        Actions actions = new Actions(webDriver);
//            //Hovering
        actions.moveToElement(confirmButton);
//           //build()- used to compile all the actions into a single step
        actions.build().perform();
        logger.info(" Btn hovering");
        confirmButton.click();
        logger.info(" hovering element was clicked");

       return this;
    }



}
