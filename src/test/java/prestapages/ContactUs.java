package prestapages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUs {
WebDriver driver;
WebDriverWait wait;
JavascriptExecutor js;


public ContactUs(WebDriver driver) {

    this.driver = driver;

    wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    driver.get("https://demo.prestashop.com/#/en/front");
    driver.manage().window().maximize()
;
    wait.until(
        ExpectedConditions.frameToBeAvailableAndSwitchToIt("framelive"));

    PageFactory.initElements(driver, this);
    

    js = (JavascriptExecutor) driver;
}

	
	@FindBy(xpath="//a[@class='ps-contactinfo__email' and contains(@href,'contact-us')]") WebElement contactus;
    @FindBy(xpath="//input[@id='contact-us-email-input']") WebElement contactemail;
    @FindBy(xpath="//textarea[@id='contact-us-message-textarea']") WebElement message;
    @FindBy(xpath="//button[@name='submitMessage']") WebElement send;
    
    
    public void clickContactus() {
    	new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete"));

System.out.println("Current URL : " + driver.getCurrentUrl());
System.out.println("Title : " + driver.getTitle());

    	wait.until(ExpectedConditions.visibilityOf(contactus));

        WebElement contactus = wait.until(
        ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Contact us')]")));

         contactus.click();
    }
    public void contactEmail() throws InterruptedException {
Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(contactemail));
        contactemail.clear();
        contactemail.sendKeys("qwertyui@gmail.com");
    }
    public void contactissue() {
    	

        wait.until(ExpectedConditions.visibilityOf(message));
        message.sendKeys("delivery issue");
    }
    public void clickcontactsend() throws InterruptedException {

    	JavascriptExecutor js = (JavascriptExecutor) driver;

    	js.executeScript(
    	    "arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
    	    send);

    	Thread.sleep(2000);

    	send.click();
    }
}

