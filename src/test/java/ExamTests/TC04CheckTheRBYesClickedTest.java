package ExamTests;

import BaseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import suits.TestSuit1;

@RunWith(JUnitParamsRunner.class)
@Category(TestSuit1.class)

public class TC04CheckTheRBYesClickedTest extends BaseTest {
    @Test
    public void checkTheRadioButtonYesClickedTest() {
        homePage.openHomePage();
        homePage
                .clickOnElementsCardToOpenElementsPage();
        elementsPage
                .checkIsRedirectedToTheElementsPage();
        radioButtonTab
                .openRadioButtonTab()
                .checkIsRedirectedRadioButtonTab()
                .clickYesRadioBtn()
                .checkTheMessageYesAppeared()

        ;

    }

}
