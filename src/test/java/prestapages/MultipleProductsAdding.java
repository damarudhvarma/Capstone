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

public class MultipleProductsAdding {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	public MultipleProductsAdding(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("framelive"));
	}
	
	@FindBy(xpath="//input[@name='s']") WebElement search;
	@FindBy(xpath="/p[text()=\"The best is yet to come' Framed poster\"]") WebElement frame;
	@FindBy(xpath="//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div[2]/div[2]/button") WebElement add_to_cart;
	 @FindBy(xpath="//button[contains(text(),'Continue shopping')]") WebElement crossbutton;



	public void clickSearch() throws InterruptedException {
			Thread.sleep(6000);
//			wait.until(ExpectedConditions.visibilityOfAllElements(search));
//			 wait.until(ExpectedConditions.elementToBeClickable(search)).click();
//			 search.sendKeys("frame");
//			 Thread.sleep(4000);
//	          wait.until(ExpectedConditions.elementToBeClickable(
//	          By.xpath("//p[contains(text(),'The best is yet to come')]")
//	          )).click();
//			Thread.sleep(2000);
			

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
			
		
		public void clickSearchTshirt() throws InterruptedException {

			Thread.sleep(6000);
			WebElement closeBtn = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(
			                By.xpath("//div[@id='blockcart-modal']//button[@aria-label='Close']")));

			((JavascriptExecutor)driver)
			        .executeScript("arguments[0].click();", crossbutton);
			
			crossbutton.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(search));
			 wait.until(ExpectedConditions.elementToBeClickable(search)).click();
			 search.sendKeys("tshirt");
			 Thread.sleep(4000);
	          wait.until(ExpectedConditions.elementToBeClickable(
	          By.xpath("//p[text()='Hummingbird printed t-shirt']")
	          )).click();
			Thread.sleep(2000);
			
		}
		
		public void clickAddtocart() throws InterruptedException {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(add_to_cart)).click();
			Thread.sleep(3000);
		}
}
