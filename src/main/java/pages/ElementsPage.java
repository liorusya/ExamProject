package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class ElementsPage extends ParentPage {

    @FindBy(className = "main-header")
    @Name("Elements Title")
    private WebElement elementsTitle;

    @FindBy(xpath = ".//*[@id='close-fixedban']")
    // .//*[@id='close-fixedban']  .//*[@title='Ad.Plus Advertising']
    private WebElement bannerOnTheBottom;

    public ElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getRelativeUrl() {
        return "/elements";
    }


    public ElementsPage checkIsRedirectedToTheElementsPage() {
        checkUrl();
        Assert.assertTrue("ElementsTitle is not displayed",
                isElementDisplayed(elementsTitle));
        return this;
    }

    public void closeBannerOnThePage() {
        clickOnElement(bannerOnTheBottom);
        Assert.assertFalse("Banner is displayed",
                isElementDisplayed(bannerOnTheBottom));

    }


}
