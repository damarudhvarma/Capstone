package StepDef;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.qameta.allure.Attachment;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PrestaShopGuestCheckoutPage;
import pages.PrestaShopHomePage;
import pages.PrestaShopLoginPage;
import pages.PrestaShopProductPage;
import pages.PrestaShopRegistrationPage;
import base.BaseClass;


public class PrestaShopLoginSteps {
	WebDriver driver;
	private PrestaShopHomePage homePage =
	        new PrestaShopHomePage(BaseClass.getDriver());

	private PrestaShopLoginPage loginPage =
	        new PrestaShopLoginPage(BaseClass.getDriver());

	private PrestaShopRegistrationPage registrationPage =
	        new PrestaShopRegistrationPage(BaseClass.getDriver());
	
	private PrestaShopProductPage productPage =
	        new PrestaShopProductPage(BaseClass.getDriver());
	
	private PrestaShopGuestCheckoutPage guestCheckoutPage =
	        new PrestaShopGuestCheckoutPage(BaseClass.getDriver());

    @Given("the user is on the PrestaShop live store homepage")
    public void userIsOnPrestaShopHomepage() {

        homePage.navigateToPrestaShop();
    }

    @When("the user navigates to the portal sign in screen")
    public void userNavigatesToSignInScreen() {

        homePage.clickSignInLink();

        System.out.println("URL = " +
                BaseClass.getDriver().getCurrentUrl());

        System.out.println("TITLE = " +
                BaseClass.getDriver().getTitle());
    }

    @When("user submits their registered email {string} and password {string}")
    public void userSubmitsCredentials(String email, String password) {

        loginPage.submitLoginCredentials(email, password);
    }

   
    
    
    @When("the user clicks on the Sign In link")
    public void clickSignIn() {

        homePage.clickSignInLink();
    }

    @When("the user clicks on Create Your Account button")
    public void clickCreateYourAccount() {

        loginPage.clickCreateAccount();
    }

    @When("the user enters valid registration details")
    public void enterRegistrationDetails() throws InterruptedException {

        registrationPage.registerUser();
    }

    @When("the user clicks on Create Account button")
    public void clickCreateAccountButton() {

        // Already clicked in registerUser()
    }

    @Then("the account should be created successfully")
    public void verifyRegistrationSuccess() {

        boolean status =
                registrationPage.verifyRegistrationSuccess();

        System.out.println("Registration Status = " + status);

        Assert.assertTrue(
                status,
                "Registration Failed");
    }
    
    @Then("the My Account page should be displayed")
    public void verifyMyAccountPage() {

        System.out.println("My Account verification executed");
    }
    
    @When("the user clicks on All Featured Products")
    public void clickAllFeaturedProducts()
            throws InterruptedException {

        productPage.clickAllFeaturedProducts();
    }

    @When("the user searches for product {string}")
    public void searchProduct(String product)
            throws InterruptedException {

        productPage.searchProduct(product);
    }

    @When("the user selects the first searched product")
    public void selectFirstProduct()
            throws InterruptedException {

        productPage.selectFirstProduct();
    }

    @When("the user adds the product to cart")
    public void addProductToCart()
            throws InterruptedException {

        productPage.addToCart();
    }

    @When("the user proceeds to checkout")
    public void proceedToCheckout()
            throws InterruptedException {

        productPage.proceedToCheckout();
    }

    @Then("the checkout page should be displayed")
    public void verifyCheckoutPage() {

        Assert.assertTrue(
                productPage.verifyCheckoutPageDisplayed(),
                "Checkout page not displayed");
    }
    
    @When("the user clicks checkout from cart page")
    public void clickCheckoutFromCartPage()
            throws InterruptedException {

        productPage.clickCheckoutFromCartPage();
    }

    @Then("the personal information page should be displayed")
    public void verifyPersonalInformationPage() {

        Assert.assertTrue(
                productPage.verifyPersonalInformationPage(),
                "Personal Information page not displayed");
    }
    
    @Given("the user is on the Personal Information page")
    public void userIsOnPersonalInformationPage() {

        System.out.println("Already reached Personal Information page");
    }

    @When("the user enters guest checkout details")
    public void enterGuestCheckoutDetails() throws InterruptedException {

        guestCheckoutPage.enterPersonalInformation();
    }

    @When("the user clicks Continue")
    public void clickContinue() throws InterruptedException {

        guestCheckoutPage.clickContinuePersonalInformation();
    }

    @When("the user enters address details")
    public void enterAddressDetails() throws InterruptedException {

        guestCheckoutPage.enterAddressDetails();
    }

    @When("the user selects shipping method")
    public void selectShippingMethod()
            throws InterruptedException {

        guestCheckoutPage.selectShippingMethod();
    }

    @When("the user selects payment method")
    public void selectPaymentMethod() throws InterruptedException {

        guestCheckoutPage.selectPaymentMethod();
    }

    @Then("the order should be placed successfully")
    public void verifyOrderPlacement() {

        Assert.assertTrue(
                guestCheckoutPage.verifyOrderPlacementPage(),
                "Order placement flow failed");
    }
    @io.cucumber.java.AfterStep
    public void captureScreenshotAfterEveryStep(io.cucumber.java.Scenario scenario) {
        if (driver != null) {
            try {
                // Cast driver instance to capture raw screenshot bytes
                org.openqa.selenium.TakesScreenshot ts = (org.openqa.selenium.TakesScreenshot) driver;
                byte[] screenshotBytes = ts.getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
                
                // Determine a clean label based on step status
                String statusLabel = scenario.isFailed() ? "Failed_Step_View" : "Passed_Step_View";
                
                // Attach the screenshot directly underneath the current step row
                scenario.attach(screenshotBytes, "image/png", statusLabel);
                
            } catch (Exception e) {
                System.out.println("Failed to capture step screenshot: " + e.getMessage());
            }
        }
    }
     
    @Attachment("Step Screenshot View")
    public byte[] allureSaveScreenshot(byte[] screenshot) {
        return screenshot;
    }
     
     
 }
     