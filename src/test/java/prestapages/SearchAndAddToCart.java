package prestapages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchAndAddToCart {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public SearchAndAddToCart(WebDriver driver){
		this.driver= driver;
	    wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    driver.get("https://demo.prestashop.com/#/en/front");
	    driver.manage().window().maximize()
	;
	    wait.until(
	        ExpectedConditions.frameToBeAvailableAndSwitchToIt("framelive"));

	    PageFactory.initElements(driver, this);
	    

	    js = (JavascriptExecutor) driver;
	}

	@FindBy(xpath="//input[@name='s']") WebElement search;
	@FindBy(xpath="/p[text()=\"The best is yet to come' Framed poster\"]") WebElement frame;
	@FindBy(xpath="//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div[2]/div[2]/button") WebElement add_to_cart;


	public void clickSearch() throws InterruptedException {
		Thread.sleep(6000);
//		wait.until(ExpectedConditions.visibilityOfAllElements(search));
//		 wait.until(ExpectedConditions.elementToBeClickable(search)).click();
//		 search.sendKeys("frame");
//		 Thread.sleep(4000);
//          wait.until(ExpectedConditions.elementToBeClickable(
//          By.xpath("//p[contains(text(),'The best is yet to come')]")
//          )).click();
//		Thread.sleep(2000);
		
 
		    wait.until(ExpectedConditions.elementToBeClickable(search)).click();
 
		    search.clear();
		    search.sendKeys("frame");
 
		    WebElement product = wait.until(
		            ExpectedConditions.visibilityOfElementLocated(
		                    By.xpath("//p[contains(text(),'The best is yet to come')]")));
 
		    wait.until(ExpectedConditions.elementToBeClickable(product));
 
		    ((JavascriptExecutor) driver)
		            .executeScript("arguments[0].click();", product);
		}
 
public void clickAddtocart() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(add_to_cart)).click();
	}
 

}
