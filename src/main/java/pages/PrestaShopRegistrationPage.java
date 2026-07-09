package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PrestaShopRegistrationPage extends BasePage {

    public PrestaShopRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void registerUser() throws InterruptedException {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("field-firstname")));

        String email =
                "user" + System.currentTimeMillis() + "@gmail.com";

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Gender
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@name='id_gender']")))
                .click();

        // User Details
        driver.findElement(By.id("field-firstname"))
                .sendKeys("John");

        driver.findElement(By.id("field-lastname"))
                .sendKeys("Doe");

        driver.findElement(By.id("field-email"))
                .sendKeys(email);

        driver.findElement(By.id("field-password"))
                .sendKeys("Prestashop@2026Strong!");

        // Scroll down after Password
        js.executeScript("window.scrollBy(0,400)");

        // GDPR Checkbox
        WebElement termsCheckbox =
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.name("psgdpr")));

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                termsCheckbox);

        js.executeScript(
                "arguments[0].click();",
                termsCheckbox);

        // Customer Privacy Checkbox
        WebElement privacyCheckbox =
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.name("customer_privacy")));

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                privacyCheckbox);

        js.executeScript(
                "arguments[0].click();",
                privacyCheckbox);

        // Scroll to Create Account Button
        WebElement createAccountBtn =
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//button[contains(text(),'Create account')]")));

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                createAccountBtn);

        Thread.sleep(1000);

        js.executeScript(
                "arguments[0].click();",
                createAccountBtn);
    }

    public boolean verifyRegistrationSuccess() {

        try {

            Thread.sleep(5000);

            System.out.println("Current URL = "
                    + driver.getCurrentUrl());

            System.out.println("Page Title = "
                    + driver.getTitle());

            String pageSource =
                    driver.getPageSource().toLowerCase();

            if (pageSource.contains("sign out")
                    || pageSource.contains("my account")
                    || pageSource.contains("john")
                    || pageSource.contains("account")) {

                return true;
            }

            return false;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}