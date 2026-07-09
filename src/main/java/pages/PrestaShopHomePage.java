package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PrestaShopHomePage extends BasePage {

    public PrestaShopHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToPrestaShop() {

        driver.get("https://demo.prestashop.com/#/en/front");

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.cssSelector("iframe")
        ));
    }

    public void clickSignInLink1() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@title,'Log in') or contains(.,'Sign in')]")
        )).click();
    }
    
    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    private WebElement signInLink;

    public void clickSignInLink() {

        wait.until(ExpectedConditions.elementToBeClickable(signInLink))
            .click();
    }
}