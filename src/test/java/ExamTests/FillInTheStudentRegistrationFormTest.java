package ExamTests;

import BaseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import suits.TestSuit1;

@RunWith(JUnitParamsRunner.class)
@Category(TestSuit1.class)

public class FillInTheStudentRegistrationFormTest extends BaseTest {


    @Test
    public void FillInTheStudentRegistrationFormCorrectlyTest() {
        final String firstName = "Sherlock";
        final String lastName = "Holmes";
        final String email = "sherlock@testmail.com";
        final String userPhoneN = "1234567895";
        final String dateOfBirth = "04 Mar 1995";

        homePage.openHomePage();
        homePage.clickOnFormsCardToOpenTheFormsPage();
        formsPage.checkIsRedirectedToTheFormsPage()
                .openPracticeForm()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .chooseMaleGender()
                .enterUserPhoneNumber(userPhoneN)
                .enterDateOfBirth(dateOfBirth)
                //.selectHobbyType1()
                .typeCurrentAddress("UK, Galychanka street")
                .submitForm()
                // verify if submit modal was Displayed
                .checkTheSubmitModalDisplayed();
    }
}
