package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;


public class HomePage extends ParentPage {
    @FindBy(xpath = "//*[@id='app']/div/div/div[2]/div/div[1]/div/div[1]")
    //.//h5[text()='Elements']
    @Name(" Elements card")
    private WebElement elementsCard;

    @FindBy(xpath = ".//*[@id='app']//div[2]//div[2]/div/div[1]")
    private WebElement formsCard;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getRelativeUrl() {
        return "/";
    }

    public void openHomePage() {
        try {
            webDriver.get(baseUrl);
            logger.info("HomePage was opened");

        } catch (Exception e) {
            logger.error("Can not open HomePage " + e);
            Assert.fail("Can not open HomePage " + e);
        }
    }

    public void clickOnElementsCardToOpenElementsPage() {
        clickOnElement(elementsCard);

    }

    public void clickOnFormsCardToOpenTheFormsPage() {
        clickOnElement(formsCard);
    }


}
