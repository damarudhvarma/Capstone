package hooks;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	public static WebDriver driver;

	 @Before
	    public void setup() {
	        String browser = "chrome"; // chrome, edge, firefox
	        if (browser.equalsIgnoreCase("chrome")) {
	            System.out.println("Launching Chrome Browser");
	            driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("edge")) {
	            System.out.println("Launching Edge Browser");
	            driver = new EdgeDriver();
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            System.out.println("Launching Firefox Browser");
	            driver = new FirefoxDriver();
	        } else {
	            throw new RuntimeException("Invalid Browser Name");
	        }
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://demo.prestashop.com/#/en/front");
	    }
	 @After
	    public void tearDown(Scenario scenaro) throws InterruptedException, IOException
	    {
	    	//capture the screen shot upon failure--> develop
	    	if(scenaro.isFailed()) {
	    		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				Files.copy(src, new File("./screenshot/"+"screenshot-"+System.currentTimeMillis()+".png"));		
	    		     	}
	    	System.out.println("Closing the browser..");
	    	Thread.sleep(4000);
	    	driver.quit();
	    }
	 public static void screenshot() throws IOException
		{
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(src, new File("./screenshot/"+"screenshot-"+System.currentTimeMillis()+".png"));		
		}

}
