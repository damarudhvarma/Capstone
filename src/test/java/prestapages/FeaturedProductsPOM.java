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
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("framelive"));
	}
	
	
	@FindBy(xpath="//*[@id=\"content\"]/section[3]/div/div[2]/a") WebElement All_featured;
	@FindBy(xpath="//a[@title='Accessories']")WebElement category;
	@FindBy(xpath="//button[@id='sort_dropdown_button']") WebElement dropDown;
	@FindBy(xpath="//*[@id=\"js-product-list-top\"]/div/div[2]/div[2]/div/a[3]") WebElement option;
	@FindBy(xpath="//a[@class='product-miniature__title' and normalize-space()='Brown bear cushion']")WebElement cushion;
	@FindBy(xpath="//span[@id='label_2_11_10']")WebElement colorchange;
	@FindBy(xpath="//button[@id='increment_button_10']")WebElement plus;
	@FindBy(xpath="//button[@aria-label='Add to cart Brown bear cushion']")WebElement add_tocart;
	@FindBy(xpath="//button[normalize-space()='Continue shopping']")WebElement continueshopping;
	@FindBy(xpath="//a[contains(@href,'cart?action=show')]")WebElement cart;
	@FindBy(xpath="//a[normalize-space()='Proceed to checkout']")WebElement procedecheckout;
	@FindBy(xpath="//a[contains(@class,'navbar-brand')]")WebElement mystore;

	
	
	public void allFeatures() throws InterruptedException {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
		        By.id("loadingMessage")));
		Thread.sleep(5000);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(mystore));
		mystore.click();
		Thread.sleep(2000);

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
		js.executeScript("arguments[0].scrollIntoView({block:'center'});",dropDown);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", dropDown);
		//js.executeScript("arguments[0].scrollIntoView(true);", dropDown);
		System.out.println("sorted by Name A to Z");
		Thread.sleep(1000);		
	}
	public void selectprod() throws InterruptedException {
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView({block:'center'});",cushion);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", cushion);
		//js.executeScript("arguments[0].scrollIntoView(true);", cushion);
		//wait.until(ExpectedConditions.elementToBeClickable(cushion)).click();
		Thread.sleep(1000);
		//new WebDriverWait(driver, Duration.ofSeconds(15))
        //.until(webDriver -> ((JavascriptExecutor) webDriver)
        //.executeScript("return document.readyState").equals("complete"));
		WebElement colorchange = wait.until(ExpectedConditions.elementToBeClickable(By.id("label_2_11_10")));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});",colorchange);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(colorchange));
		js.executeScript("arguments[0].click();", colorchange);
		//js.executeScript("arguments[0].scrollIntoView(true);", colorchange);
		//wait.until(ExpectedConditions.elementToBeClickable(colorchange)).click();
		Thread.sleep(1000);
		
		
		
	}
	public void quantity() throws InterruptedException {
		Thread.sleep(1000);
		//js.executeScript("arguments[0].scrollIntoView({block:'center'});",plus);
		//Thread.sleep(2000);
		//js.executeScript("arguments[0].click();", plus);
		//js.executeScript("arguments[0].scrollIntoView(true);", plus);
		js.executeScript("arguments[0].scrollIntoView({block:'center'});",plus);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(plus));
		js.executeScript("arguments[0].click();", plus);
		//wait.until(ExpectedConditions.elementToBeClickable(plus)).click();
		wait.until(ExpectedConditions.elementToBeClickable(add_tocart)).click();
		Thread.sleep(1000);
		new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete"));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});",continueshopping);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(continueshopping));
		//js.executeScript("arguments[0].click();", continueshopping);
		WebElement continueBtn = wait.until(
			    ExpectedConditions.elementToBeClickable(
			        By.xpath("//button[normalize-space()='Continue shopping']")
			    )
			);

			js.executeScript("arguments[0].click();", continueBtn);
		//wait.until(ExpectedConditions.elementToBeClickable(continueshopping)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(procedecheckout)).click();
		
		
		
	}

}
