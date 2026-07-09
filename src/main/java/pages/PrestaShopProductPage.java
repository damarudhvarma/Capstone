package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PrestaShopProductPage extends BasePage {

    public PrestaShopProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAllFeaturedProducts() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement featuredBtn =
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//a[contains(text(),'All featured products')]")));

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                featuredBtn);

        Thread.sleep(2000);

        js.executeScript("arguments[0].click();", featuredBtn);
    }

    public void searchProduct(String productName)
            throws InterruptedException {

        WebElement searchBox =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("input[placeholder='Search products...']")));

        searchBox.clear();
        searchBox.sendKeys(productName);

        Thread.sleep(3000);
    }

    public void selectFirstProduct() throws InterruptedException {

        WebElement product =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(text(),'Hummingbird printed t-shirt')]")));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        product);

        Thread.sleep(3000);

        System.out.println("Current URL = "
                + driver.getCurrentUrl());

        System.out.println("Page Title = "
                + driver.getTitle());
    }
   

    public void addToCart() throws InterruptedException {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        Thread.sleep(3000);

        WebElement addToCartBtn =
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//button[@data-button-action='add-to-cart']")));

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                addToCartBtn);

        Thread.sleep(2000);

        addToCartBtn =
                driver.findElement(
                        By.xpath("//button[@data-button-action='add-to-cart']"));

        js.executeScript(
                "arguments[0].click();",
                addToCartBtn);

        System.out.println("Add To Cart Clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("blockcart-modal")));

        System.out.println("Cart popup displayed");
    }
    
    public void proceedToCheckout() throws InterruptedException {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        WebElement checkoutBtn =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'Proceed to checkout')]")));

        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                checkoutBtn);

        Thread.sleep(2000);

        js.executeScript(
                "arguments[0].click();",
                checkoutBtn);

        System.out.println("Checkout clicked");
    }
    
    public boolean verifyCheckoutPageDisplayed() {

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h1[contains(text(),'Shopping Cart')]")));

            System.out.println("Shopping Cart Page Displayed");

            return true;

        } catch (Exception e) {

            System.out.println("Current URL = "
                    + driver.getCurrentUrl());

            System.out.println("Page Title = "
                    + driver.getTitle());

            return false;
        }
    }
    
    public void clickCheckoutFromCartPage() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(3000);

        WebElement checkoutBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//a[contains(text(),'Proceed to checkout')]")));

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                checkoutBtn);

        Thread.sleep(2000);

        // Re-fetch element to avoid stale reference
        checkoutBtn = driver.findElement(
                By.xpath("//a[contains(text(),'Proceed to checkout')]"));

        js.executeScript(
                "arguments[0].click();",
                checkoutBtn);

        Thread.sleep(5000);

        System.out.println("URL After Checkout = "
                + driver.getCurrentUrl());

        System.out.println("Title After Checkout = "
                + driver.getTitle());
    }
    
    public boolean verifyPersonalInformationPage() {

        try {

            System.out.println("Current URL = "
                    + driver.getCurrentUrl());

            System.out.println("Page Title = "
                    + driver.getTitle());

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'Personal Information')]")));

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}