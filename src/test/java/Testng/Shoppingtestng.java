package Testng;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import prestapages.ContactUs;
import prestapages.checkoutandshipping;
import prestapages.orderinfo;
import prestapages.prestaloginandsignup1;

public class Shoppingtestng {

    WebDriver driver;

    prestaloginandsignup1 pr;

    checkoutandshipping c;

    orderinfo or;

    @BeforeTest
    public void setup() throws Exception {
    	System.out.println(">>> Initializing WebDriver instance...");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        
      
        driver.get("https://demo.prestashop.com/#/en/front");

     

        pr = new prestaloginandsignup1(driver);

        c = new checkoutandshipping(driver);

        or = new orderinfo(driver);
    }

    @Test(priority = 1)
    public void signupAndLoginTest() throws Exception {

        pr.signup();

        pr.signup_firstname("John");

        pr.signup_lastname("Doe");

        pr.signup_email("ocb@example.com");

        pr.signup_password("12342abcdteam");

        Thread.sleep(2000);

        pr.signup_checkbox();

        pr.signup_create();

        pr.signout();

        pr.signin("ocb@example.com", "12342abcdteam");

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,1000)");

        System.out.println("Signup and Login Successful");
    }

    @Test(priority = 2)
    public void featuredProductsTest() throws Exception {

        c.selectallproducts();

        System.out.println("Featured Products Clicked");
    }

    @Test(priority = 3)
    public void searchProductTest() throws Exception {

        pr.clickSearch();

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,200)");

        System.out.println("Product Searched");
    }

    @Test(priority = 4)
    public void addToCartTest() throws Exception {

        pr.clickAddtocart();

        System.out.println("Product Added To Cart");
    }

    @Test(priority = 5)
    public void proceedToCheckoutTest() throws Exception {

        Thread.sleep(1000);

        pr.clickProceed();

        pr.clickProceed();

        System.out.println("Checkout Started");
    }

    @Test(priority = 6)
    public void shippingDetailsTest() throws Exception {

        pr.shippingNames("Damarudh", "Varma");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)");

        pr.addAddress("Hyderabad Colony");

        js.executeScript("window.scrollBy(0,500)");

        pr.addingCity("90001", "California");

        System.out.println("Shipping Details Entered");
    }

    @Test(priority = 7)
    public void continueAddressTest() throws Exception {

        pr.clickOnContinue();

        System.out.println("Continue Address Clicked");
    }

    @Test(priority = 8)
    public void paymentTest() throws Exception {

        pr.clickContinueToPayment();

        Thread.sleep(2000);

        pr.selectPaymentMode("cod");

        System.out.println("Payment Mode Selected");
    }

    @Test(priority = 9)
    public void confirmOrderTest() throws Exception {

        pr.confirmPayment();

        System.out.println("Order Confirmed");
    }

    @Test(priority = 10)
    public void orderPlacedTest() throws Exception {

        Thread.sleep(3000);

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        Files.copy(src,
                new File("target/confirm-order-"
                        + System.currentTimeMillis()
                        + ".png"));

        System.out.println("Order Placed Successfully");
    }

    @Test(priority = 11)
    public void navigateOrdersTest() throws Exception {

        or.navigateToOrders();

        System.out.println("Navigated To Orders");
    }

    @Test(priority = 12)
    public void orderDetailsTest() throws Exception {

        or.selectOrderForDetails();

        //or.getOrderDetails();

        System.out.println("Order Details Displayed");
    }

    @AfterTest
    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}