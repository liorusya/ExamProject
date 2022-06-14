package pages.elementsPageTabs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class WebTablesTab extends ParentPage {
    Logger logger = Logger.getLogger(getClass());
    @FindBy(xpath = ".//*/div[text ()='Web Tables']")
    @Name(" Web Tables Title")
    private WebElement webTablesTitle;
    @FindBy(xpath = ".//span[(text()='Web Tables')]")
    private WebElement webTablesMenuItem;
    @FindBy(xpath = ".//button[@id ='addNewRecordButton']")
    private WebElement addNewRecordButton;

    @FindBy(xpath = ".//input[@placeholder ='First Name']")
    private WebElement inputFirstNameField;
    @FindBy(xpath = ".//input[@placeholder ='Last Name']")
    private WebElement inputLastNameField;
    @FindBy(xpath = ".//input[@placeholder ='name@example.com']")
    private WebElement inputEmailField;
    @FindBy(xpath = ".//input[@placeholder ='Age']")
    private WebElement inputAgeField;
    @FindBy(xpath = ".//input[@placeholder ='Salary']")
    private WebElement inputSalaryField;
    @FindBy(xpath = ".//input[@placeholder ='Department']")
    private WebElement inputDepartmentField;
    @FindBy(xpath = ".//button[@id ='submit']")
    private WebElement submitButton;

    @FindBy(xpath = ".//input[@placeholder ='Type to search']")
    private WebElement searchField;

    @FindBy(xpath = ".//*[@class='rt-tr -odd']//div[1]")
    private WebElement firstNameInTable;
    @FindBy(xpath = ".//*[@class='rt-tr -odd']//div[2]")
    private WebElement lastNameInTable;
    @FindBy(xpath = ".//*[@class='rt-tr -odd']//div[3]")
    private WebElement ageInTable;
    @FindBy(xpath = ".//*[@class='rt-tr -odd']//div[4]")
    private WebElement emailInTable;
    @FindBy(xpath = ".//*[@class='rt-tr -odd']//div[5]")
    private WebElement salaryInTheTable;
    @FindBy(xpath = ".//*[@class='rt-tr -odd']//div[6]")
    private WebElement departmentInTheTable;


    public WebTablesTab(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getRelativeUrl() {
        return "/webtables";
    }

    public WebTablesTab openWebTablesTabOfTheElementsPage() {
        clickOnElement(webTablesMenuItem);
        return this;
    }

    public WebTablesTab checkIsRedirectedToTheWebTablesTab() {
        checkUrl();
        Assert.assertTrue("Web Table Title is not displayed",
                isElementDisplayed(webTablesTitle));
        return this;
    }

    public WebTablesTab clickAddButton() {
        clickOnElement(addNewRecordButton);
        return this;
    }

    public WebTablesTab enterFirstName(String firstName) {
        enterTextInToElement(inputFirstNameField, firstName);
        return this;
    }

    public WebTablesTab enterLastName(String lastName) {
        enterTextInToElement(inputLastNameField, lastName);
        return this;
    }

    public WebTablesTab enterEmail(String email) {
        enterTextInToElement(inputEmailField, email);
        return this;
    }

    public WebTablesTab enterAge(String age) {
        enterTextInToElement(inputAgeField, age);
        return this;
    }

    public WebTablesTab enterSalary(String salary) {
        enterTextInToElement(inputSalaryField, salary);
        return this;
    }

    public WebTablesTab enterDepartment(String department) {
        enterTextInToElement(inputDepartmentField, department);
        return this;
    }

    public WebTablesTab fillInTheRegistrationForm(String firstName, String lastName,
                                                  String email, String age, String salary, String department) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterAge(age);
        enterSalary(salary);
        enterDepartment(department);
        return this;
    }

    public WebTablesTab clickSubmitButton() {
        // clickOnElement(submitButton);
        submitButton.sendKeys(Keys.ENTER);
        logger.info("Submit button clicked");
        return this;
    }

    public WebTablesTab enterTheFirstNameInToTheSearchField(String fistName) {
        enterTextInToElement(searchField, fistName);
        searchField.sendKeys(Keys.ENTER);
        return this;
    }


    public WebTablesTab checkTheLastNameInTheTable(String lastName) {
        isElementDisplayed(lastNameInTable);
        Assert.assertEquals("The lasName was not found", lastName, lastNameInTable.getText());
        return this;
    }

    public WebTablesTab checkTheFirstNameInTheTable(String firstName) {
        isElementDisplayed(lastNameInTable);
        Assert.assertEquals("The FistName was not found", firstName, firstNameInTable.getText());
        return this;
    }

    public WebTablesTab checkTheAgeInTheTable(String age) {
        isElementDisplayed(ageInTable);
        Assert.assertEquals("The Age was not found in the table", age, ageInTable.getText());
        return this;
    }

    public WebTablesTab checkTheEmailInTheTable(String email) {
        isElementDisplayed(emailInTable);
        Assert.assertEquals("The email was not found", email, emailInTable.getText());
        return this;
    }

    public WebTablesTab checkSalaryInTheTable(String salary) {
        isElementDisplayed(salaryInTheTable);
        Assert.assertEquals("The Salary was not found", salary, salaryInTheTable.getText());
        return this;
    }


    public WebTablesTab checkDepartmentInTheTable(String salary) {
        isElementDisplayed(departmentInTheTable);
        Assert.assertEquals("The name of Department was not found",
                salary, departmentInTheTable.getText());
        return this;
    }

}
