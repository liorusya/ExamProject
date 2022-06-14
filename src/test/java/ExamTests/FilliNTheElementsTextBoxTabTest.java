package ExamTests;

import BaseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import suits.TestSuit1;

@RunWith(JUnitParamsRunner.class)
@Category(TestSuit1.class)

public class FilliNTheElementsTextBoxTabTest extends BaseTest {
    final String fullName = "Test User";
    final String email = "user@testmail.com";
    final String currentAddress = "Ukraine, Lviv, GalytsKa street";
    final String permanentAddress = "Ukraine, Kyiv, Grushevskogo street";

    @Test

    public void fillInTheElementsTextBoxTabCorrectly() {

        homePage.openHomePage();
        homePage
                .clickOnElementsCardToOpenElementsPage();
        elementsPage
                .checkIsRedirectedToTheElementsPage();
        // .closeBannerOnThePage();
        textBoxTab
                .openTheTexBoxTab()
                .checkIsRedirectToTextBoxTab()
                .enterFullNameInTheField(fullName)
                .enterEmailInTheField(email)
                .enterCurrentAddress(currentAddress)
                .enterPermanentAddress(permanentAddress)
                .clickSubmitButtonWithScrollDown()
                .checkIsAllDataSavedCorrectly(fullName, email, currentAddress, permanentAddress);
    }
}
