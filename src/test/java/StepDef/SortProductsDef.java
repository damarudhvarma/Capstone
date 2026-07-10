package StepDef;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Attachment;
import prestapages.SortProducts;

public class SortProductsDef {
	SortProducts sp;
	WebDriver driver;
		


@Given("user navigates to featured products page")
public void user_navigates_to_featured_products_page() throws InterruptedException {
	driver = new ChromeDriver();
	driver.get("https://demo.prestashop.com");

    driver.manage().window().maximize();

    driver.manage()
            .timeouts()
            .implicitlyWait(Duration.ofSeconds(10));
   new WebDriverWait(driver, Duration.ofSeconds(15))
   .until(webDriver -> ((JavascriptExecutor) webDriver)
   .executeScript("return document.readyState").equals("complete"));
   sp= new SortProducts(driver);
   sp.allFeatures();
   
   
}

@Then("selects a Category")
public void selects_a_category() throws InterruptedException {
    sp.selectCategory();
}

@And("sorts by {string}")
public void sorts_by(String string) throws InterruptedException {
	sp.selectSortOption(string);
    
}

@Then("products are sorted")
public void products_are_sorted() throws InterruptedException {
  System.out.println("Sucessfully sorted products");
  Thread.sleep(2000);
  driver.quit();
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
