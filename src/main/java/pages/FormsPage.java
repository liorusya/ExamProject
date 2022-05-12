package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextInput;


public class FormsPage extends ParentPage {
    Logger logger = Logger.getLogger(getClass());

    @FindBy(className = "main-header")
    private WebElement formsTitle;
    @FindBy(xpath = ".//span[text()='Practice Form']")
    private WebElement practiceFormMenuItem;
    @FindBy(xpath = ".//div[text()='Practice Form']")
    private WebElement practiceFormTabTitle;

    @FindBy(xpath = ".//*[@id='firstName']")
    private TextInput firstNameField;
    @FindBy(xpath = ".//*[@id='lastName']")
    private TextInput lastNameField;
    @FindBy(xpath = "//*[@id='userEmail']")
    private TextInput emailField;

    @FindBy(xpath = "//input[@name='gender' and @value='Male']")
    private WebElement male;
    @FindBy(xpath = "//*[@id='genterWrapper']//div[2]/label")
    private WebElement female;
    @FindBy(xpath = "//*[@id='genterWrapper']//div[3]/label")
    private WebElement other;
    @FindBy(xpath = "//input[@name='gender' and @type='radio']")
    private WebElement allGenderTypes;
    @FindBy(xpath = ".//input[@id='userNumber']")
    private TextInput userPhoneNumber;
    @FindBy(xpath = ".//input[@id='dateOfBirthInput']")
    private TextInput dateOfBirthField;
    @FindBy(xpath = "//*[@class = ' css-2b097c-container']")
    private TextInput subjectField;
    @FindBy(xpath = "//*[@placeholder = 'Current Address']")
    private TextInput currentAddressField;
    @FindBy(xpath = "//*[@id='state']")
    private WebElement stateCity;

    @FindBy(xpath = ".//*[@id = 'submit']")
    private WebElement submit;

    @FindBy(xpath = "//*[@class ='modal-title h4']")
    private WebElement modalTitle;

    public FormsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getRelativeUrl() {
        return "/forms";
    }


    public FormsPage checkIsRedirectedToTheFormsPage() {
        checkUrl();
        Assert.assertTrue("Forms Title is not displayed",
                isElementDisplayed(formsTitle));
        return this;
    }

    public FormsPage openPracticeForm() {
        clickOnElement(practiceFormMenuItem);
        closeBannerOnThePage();
        Assert.assertTrue("Practice Form tab title is not displayed"
                , isElementDisplayed(practiceFormTabTitle));
        return this;
    }

    public FormsPage enterFirstName(String firstName) {
        enterTextInToElement(firstNameField, firstName);
        return this;
    }

    public FormsPage enterLastName(String lastName) {
        enterTextInToElement(lastNameField, lastName);
        return this;
    }

    public FormsPage enterEmail(String email) {
        enterTextInToElement(emailField, email);
        return this;
    }

    // the methods chooseMaleGender & chooseFemaleGender -will be refactoring
    public FormsPage chooseMaleGender() {

        if (!webDriver.findElement(By.xpath("//*[@id='genterWrapper']//div[1]/label")).isSelected()) {
            webDriver.findElement(By.xpath("//*[@id='genterWrapper']//div[1]/label")).click();
            logger.info(" Male as the type of Gender was selected");
            Assert.assertTrue("Gender was not chose correct", male.isSelected());
        }
        return this;

    }

    public FormsPage chooseFemaleGender() {

        if (!webDriver.findElement(By.xpath("//*[@id='genterWrapper']//div[2]/label")).isSelected()) {
            webDriver.findElement(By.xpath("//*[@id='genterWrapper']//div[2]/label")).click();
            logger.info(" Female as the type of Gender was selected");
            Assert.assertTrue("Gender was not chose correct", female.isSelected());
        }
        return this;

    }

    public FormsPage selectHobbyType1() {
        // scrollDownUntilElementDisplayed(webDriver.findElement(By.xpath("//input[@type='checkbox' and @value='1']")));
        if (!webDriver.findElement(By.xpath("//label[@class='custom-control-input' and @value='1']")).isSelected()) {
            webDriver.findElement(By.xpath("//input[@type='checkbox' and @value='1']")).click();
            logger.info("Selected type of hobby");
        }
        return this;
    }


    public FormsPage enterUserPhoneNumber(String number) {
        enterTextInToElement(userPhoneNumber, number);
        Assert.assertEquals("Number is incorrect", number, userPhoneNumber.getText());
        return this;
    }

    public FormsPage enterDateOfBirth(String dateOfBirth) {
        // clean with hot keys
        String selectText = Keys.chord(Keys.CONTROL, "A");
        enterTextInToElement(dateOfBirthField, selectText + dateOfBirth);
        dateOfBirthField.sendKeys(Keys.ENTER);
        Assert.assertEquals("Date is incorrect", dateOfBirth, dateOfBirthField.getText());
        return this;
    }

    public FormsPage typeCurrentAddress(String currentAddress) {
        scrollDownUntilElementDisplayed(currentAddressField);
        enterTextInToElement(currentAddressField, currentAddress);
        currentAddressField.sendKeys(Keys.TAB);
        return this;
    }


    public FormsPage submitForm() {
        submit.sendKeys(Keys.ENTER);
        logger.info("Submit button clicked ");
        return this;
    }

    public FormsPage checkTheSubmitModalDisplayed() {
        modalTitle.isDisplayed();
        Assert.assertEquals("Modal is not displayed", "Thanks for submitting the form",
                modalTitle.getText());
        return this;

    }

    public FormsPage selectValueInStateDD(String state) {
        scrollDownUntilElementDisplayed(submit);
        webDriver.findElement(By.xpath(".//*[@class=' css-tlfecz-indicatorContainer']")).click();
        selectValueInDropDown(webDriver.findElement(By.xpath("//*[@class=' css-1uccc91-singleValue']")), state);
        return this;
    }

    public FormsPage selectHobbies() {
        webDriver.findElement(By.xpath(".//*[@id='hobbies-checkbox-1']")).click();
        return this;
    }

}
