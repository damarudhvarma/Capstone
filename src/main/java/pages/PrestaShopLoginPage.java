package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PrestaShopLoginPage extends BasePage {

    public PrestaShopLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void submitLoginCredentials(String email, String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("field-email")));

        driver.findElement(By.id("field-email")).clear();
        driver.findElement(By.id("field-email")).sendKeys(email);

        driver.findElement(By.id("field-password")).clear();
        driver.findElement(By.id("field-password")).sendKeys(password);

        driver.findElement(By.id("submit-login")).click();
    }
    
    @FindBy(xpath = "//a[contains(text(),'Create your account')]")
    private WebElement createAccountBtn;

    public void clickCreateAccount() {

        WebElement createAccountBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//a[contains(text(),'Create your account')]")));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                createAccountBtn);

        js.executeScript(
                "arguments[0].click();",
                createAccountBtn);
    }
   /* public boolean isUserDashboardVisible() {

        try {

            WebElement welcomeText = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//h1[contains(text(),'Welcome')]"))
            );

            return welcomeText.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    } */
    
    
}