package ExamTests;

import BaseTest.BaseTest;
import org.junit.Test;

public class TC05VerifyIfTheAlertConfirmedTest extends BaseTest {
    @Test

    public void verifyIfTheAlertConfirmedTest (){
      homePage.openHomePage();
       homePage
               .clickOnAlertsCardToOpenTheAlertPage();
              alertsPage
                .checkIsRedirectedToTheAlertsPage()
                .openTheAlertTab();
        alertsTab
                .checkIsRedirectedToTheAlertsPage()
                .clickTheBtnToOpenConfirmBox()

        ;



    }
}
