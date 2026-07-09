package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PrestaShopGuestCheckoutPage extends BasePage {

    public PrestaShopGuestCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterPersonalInformation() throws InterruptedException {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        WebElement firstName =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("field-firstname")));

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                firstName);

        Thread.sleep(2000);

        driver.findElement(By.id("field-firstname"))
                .clear();

        driver.findElement(By.id("field-firstname"))
                .sendKeys("John");

        driver.findElement(By.id("field-lastname"))
                .clear();

        driver.findElement(By.id("field-lastname"))
                .sendKeys("Doe");

        driver.findElement(By.id("field-email"))
                .clear();

        driver.findElement(By.id("field-email"))
                .sendKeys(
                        "john"
                        + System.currentTimeMillis()
                        + "@gmail.com");

        js.executeScript("window.scrollBy(0,600)");

        Thread.sleep(2000);

        try {

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.name("psgdpr"))).click();

        } catch (Exception e) {
        }

        try {

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.name("customer_privacy"))).click();

        } catch (Exception e) {
        }

        Thread.sleep(2000);
    }

    
    public void clickContinuePersonalInformation() throws InterruptedException {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        WebElement continueBtn =
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.name("continue")));

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                continueBtn);

        Thread.sleep(2000);

        js.executeScript(
                "arguments[0].click();",
                continueBtn);
    }

    public void enterAddressDetails() throws InterruptedException {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("field-address1")));

        driver.findElement(By.id("field-address1"))
                .clear();

        driver.findElement(By.id("field-address1"))
                .sendKeys("123 Main Street");

        driver.findElement(By.id("field-city"))
                .clear();

        driver.findElement(By.id("field-city"))
                .sendKeys("Paris");

        driver.findElement(By.id("field-postcode"))
                .clear();

        driver.findElement(By.id("field-postcode"))
                .sendKeys("75001");

        WebElement confirmBtn =
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.name("confirm-addresses")));

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                confirmBtn);

        Thread.sleep(2000);

        js.executeScript(
                "arguments[0].click();",
                confirmBtn);

        try {

            WebElement noThanksBtn =
                    wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'No thanks')]")));

            noThanksBtn.click();

        } catch (Exception e) {

            System.out.println("Popup not displayed");
        }
    }

    public void selectShippingMethod() throws InterruptedException {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,600)");

        Thread.sleep(3000);

        WebElement continueBtn =
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.name("confirmDeliveryOption")));

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                continueBtn);

        Thread.sleep(2000);

        js.executeScript(
                "arguments[0].click();",
                continueBtn);

        System.out.println("Shipping Method Selected");
    }

    public void selectPaymentMethod() throws InterruptedException {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,700)");

        Thread.sleep(3000);

        WebElement termsCheckbox =
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.id("conditions_to_approve[terms-and-conditions]")));

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                termsCheckbox);

        Thread.sleep(2000);

        js.executeScript(
                "arguments[0].click();",
                termsCheckbox);

        System.out.println("Terms Accepted");

        WebElement paymentOption =
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.id("payment-option-1")));

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                paymentOption);

        Thread.sleep(2000);

        js.executeScript(
                "arguments[0].click();",
                paymentOption);

        System.out.println("Payment Method Selected");
    }

    public boolean verifyOrderPlacementPage() {

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'Payment')]")));

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}