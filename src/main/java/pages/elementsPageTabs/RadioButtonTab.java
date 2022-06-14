package pages.elementsPageTabs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class RadioButtonTab extends ParentPage {

    Logger logger = Logger.getLogger(getClass());
    @FindBy(xpath = ".//span[(text()='Radio Button')]")
    private WebElement radioButtonMenuItem;
    @FindBy(xpath = ".//span[(text()='Radio Button')]")
    protected WebElement radioButtonTabTitle;
    @FindBy(xpath = ".//*[(text()='Yes')]")
    //.//*[@id ='yesRadio']
    protected WebElement yesRadioBtn;
    @FindBy(xpath = ".//span[(text()='Yes')]")
    protected WebElement yesSelectedBtn;


    public RadioButtonTab(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getRelativeUrl() {
        return "/radio-button";
    }

    public RadioButtonTab openRadioButtonTab() {
        clickOnElement(radioButtonMenuItem);
        return this;
    }

    public RadioButtonTab checkIsRedirectedRadioButtonTab() {
        checkUrl();
        Assert.assertTrue("Wrong title", isElementDisplayed(radioButtonTabTitle));
        return this;
    }

    public RadioButtonTab clickYesRadioBtn() {
        clickOnElement(yesRadioBtn);
        return this;
    }

    public RadioButtonTab checkTheMessageYesAppeared() {
        isElementDisplayed(yesSelectedBtn);
     Assert.assertTrue("No success message", isElementDisplayed(yesSelectedBtn));
        return this;

    }

}
