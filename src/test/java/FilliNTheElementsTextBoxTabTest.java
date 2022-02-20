import org.junit.Test;


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
                .checkIsRedirectedToTheElementsPage()
                .closeBannerOnThePage();
        textBoxTab
                .openTheTexBoxTab()
                .checkIsRedirectToTextBoxTab()
                .enterFullNameInTheField(fullName)
                .enterEmailInTheField(email)
                .enterCurrentAddress(currentAddress)
                .enterPermanentAddress(permanentAddress)
                .clickSubmitButton()
                .checkIsAllDataSavedCorrectly(fullName, email, currentAddress, permanentAddress);
    }
}
