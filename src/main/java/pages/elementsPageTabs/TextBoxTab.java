package pages.elementsPageTabs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class TextBoxTab extends ParentPage {
    Logger logger = Logger.getLogger(getClass());
    @FindBy(className = "main-header")
    @Name("Elements Title")
    private WebElement textBoxTitle;

    @FindBy(xpath = "//span[text ()='Text Box']")
    private WebElement textBoxMenuItem;

    @FindBy(xpath = ".//input[@id='userName']")
    // @Name("Full Name field")
    private TextInput fullNameField;

    @FindBy(xpath = ".//input[@id='userEmail']")
    private TextInput emailField;

    @FindBy(xpath = ".//textarea[@id='currentAddress']")
    private TextInput currentAddressField;

    @FindBy(xpath = ".//textarea[@id='permanentAddress']")
    private TextInput permanentAddressField;

    @FindBy(xpath = ".//*[@class='btn btn-primary']")
    private Button submitButton;

    @FindBy(id = "name")
    private WebElement fullNameSaved;

    @FindBy(id = "email")
    @Name("Email")
    private WebElement emailSaved;

    @FindBy(xpath = ".//p[@id='currentAddress']")
    private WebElement currentAddressSaved;

    @FindBy(xpath = ".//p[@id='permanentAddress']")
    private WebElement permanentAddressSaved;

    public TextBoxTab(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getRelativeUrl() {
        return "/text-box";
    }

    public TextBoxTab checkIsRedirectToTextBoxTab() {
        checkUrl();
        Assert.assertTrue("ElementsTitle is not displayed",
                isElementDisplayed(textBoxTitle));
        return this;
    }

    public TextBoxTab openTheTexBoxTab() {
        clickOnElement(textBoxMenuItem);
        return this;
    }

    public TextBoxTab enterFullNameInTheField(String fullName) {
        enterTextInToElement(fullNameField, fullName);
        return this;
    }

    public TextBoxTab enterEmailInTheField(String email) {
        enterTextInToElement(emailField, email);
        return this;
    }

    public TextBoxTab enterCurrentAddress(String currentAddress) {
        enterTextInToElement(currentAddressField, currentAddress);
        return this;
    }

    public TextBoxTab enterPermanentAddress(String permanentAddress) {
        enterTextInToElement(permanentAddressField, permanentAddress);
        return this;
    }

    public TextBoxTab clickSubmitButton() {
        clickOnElement(submitButton);
        return this;
    }

    public TextBoxTab checkIsFullNameSaved(String fullName) {
        isElementDisplayed(fullNameSaved);
        Assert.assertEquals("FullName was not saved", "Name:" + fullName, fullNameSaved.getText());
        return this;
    }

    public TextBoxTab checkIsEmailSaved(String email) {
        isElementDisplayed(emailSaved);
        Assert.assertEquals("Email was not saved", "Email:" + email, emailSaved.getText());
        return this;
    }

    public TextBoxTab checkIsCurrentAddressSaved(String currentAddress) {
        isElementDisplayed(currentAddressSaved);
        Assert.assertEquals("currentAddress was not saved", "Current Address :" + currentAddress, currentAddressSaved.getText());
        return this;
    }

    public TextBoxTab checkIsPermanentAddressSaved(String permanentAddress) {
        isElementDisplayed(permanentAddressSaved);
        Assert.assertEquals("permanentAddress was not saved", "Permananet Address :" + permanentAddress, permanentAddressSaved.getText());
        return this;
    }

    public TextBoxTab checkIsAllDataSavedCorrectly(String fullName, String email, String currentAddress, String permanentAddress) {
        checkIsFullNameSaved(fullName);
        checkIsEmailSaved(email);
        checkIsCurrentAddressSaved(currentAddress);
        checkIsPermanentAddressSaved(permanentAddress);
        logger.info("All data was saved correctly in the TexBox form");
        return this;
    }
}
