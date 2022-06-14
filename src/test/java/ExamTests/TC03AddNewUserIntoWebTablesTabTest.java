package ExamTests;

import BaseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import suits.TestSuit1;

@RunWith(JUnitParamsRunner.class)
@Category(TestSuit1.class)

public class TC03AddNewUserIntoWebTablesTabTest extends BaseTest {
    @Test
    public void addNewUserIntoWebTablesTest() {
        final String firstName = "Sherlock";
        final String lastName = "Holmes";
        final String email = "sherlock@testmail.com";
        final String age = "34";
        final String salary = "3500";
        final String department = "AQA";
        homePage.openHomePage();
        homePage
                .clickOnElementsCardToOpenElementsPage();
        elementsPage
                .checkIsRedirectedToTheElementsPage();
        webTablesTab
                .openWebTablesTabOfTheElementsPage()
                .checkIsRedirectedToTheWebTablesTab()
                .clickAddButton()
                .fillInTheRegistrationForm(firstName, lastName, email,
                        age, salary, department)
                .clickSubmitButton()
                //verify if the new user was saved
                .enterTheFirstNameInToTheSearchField(firstName)
                .checkTheFirstNameInTheTable(firstName)
                .checkTheLastNameInTheTable(lastName)
                .checkTheAgeInTheTable(age)
                .checkTheEmailInTheTable(email)
                .checkSalaryInTheTable(salary);

    }

}
