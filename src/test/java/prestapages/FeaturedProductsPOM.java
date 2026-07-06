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

public class FeaturedProductsPOM {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	
	public FeaturedProductsPOM(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js= (JavascriptExecutor) driver;
		PageFactory.initElements(driver,this);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("framelive"));
	}
	
	
	@FindBy(xpath="//*[@id=\"content\"]/section[3]/div/div[2]/a") WebElement All_featured;
	@FindBy(xpath="//a[@title='Accessories']")WebElement category;
	@FindBy(xpath="//button[@data-bs-toggle='dropdown']") WebElement dropDown;
	@FindBy(xpath="//*[@id=\"js-product-list-top\"]/div/div[2]/div[2]/div/a[3]") WebElement option;
	
	
	public void allFeatures() throws InterruptedException {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
		        By.id("loadingMessage")));
		Thread.sleep(5000);

((JavascriptExecutor)driver).executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        All_featured);
Thread.sleep(2000);
wait.until(ExpectedConditions.elementToBeClickable(All_featured)).click();
//		js.executeScript("window.scrollBy(0,500);");
//		
//		wait.until(ExpectedConditions.elementToBeClickable(All_featured)).click();
	}
	
	public void selectCategory() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(category)).click();
		System.out.println("Selected Category");
		Thread.sleep(3000);
	}
	
	public void sortBy() throws InterruptedException {
		js.executeScript("window.scrollBy(0,200);");
		System.out.println("trying to select dropdown");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(dropDown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(option)).click();
//		js.executeScript("window.scrollBy(0,200);");
		js.executeScript("arguments[0].scrollIntoView(true);", dropDown);
		System.out.println("sorted by Name A to Z");
		
	}
}
