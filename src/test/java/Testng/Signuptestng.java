package Testng;

	import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import base.BaseClass;
import prestapages.prestaloginandsignup1;

public class Signuptestng {
	
	

	    WebDriver driver;
	    prestaloginandsignup1 pr;
	    WebDriverWait wait;
	    private static final Logger logger = LogManager.getLogger(Signuptestng.class);

	    @BeforeTest
	    public void setup() {


	    	    System.out.println(">>> Initializing WebDriver instance...");
	    	        driver = new ChromeDriver();

	    	        driver.manage().window().maximize();

	    	        driver.get("https://demo.prestashop.com/#/en/front");

	    	     

	    	        pr = new prestaloginandsignup1(driver);
	    	    }

	    @DataProvider(name = "signupData")
	    public Object[][] signupData() {

	        return new Object[][] {

	            {"Damarudh","Varma","damarudh@test.com","Test@1234$"},
	            {"abc","Def","abd@test.com","Test@12$"}

	        };
	    }
	    @Test(priority = 1, dataProvider = "signupData")
	    public void signupTest(String fname,
	                           String lname,
	                           String email,
	                           String password) throws Exception {

	        pr.signup();

	        pr.signup_firstname(fname);
	        
	        pr.signup_lastname(lname);
	       
	        pr.signup_email(email);
	        
	        pr.signup_password(password);

	        pr.signup_checkbox();

	        pr.signup_create();
	        
	        logger.info("Account created sucessfully");

	        pr.signout();
	        
	        FileInputStream fis = new FileInputStream("C:\\Users\\DA20696043\\eclipse-workspace\\Capstone-project\\src\\test\\java\\utils\\data.propertites");
	    	Properties props = new Properties();
	    	props.load(fis);
	    	String path = props.getProperty("excelPath");
	    	FileInputStream excelFile = new FileInputStream(path);
	    	XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
	    	XSSFSheet sheet = workbook.getSheet("Sheet1");
	    	int totalRows =sheet.getPhysicalNumberOfRows();
	    	System.out.println("total rows : "+totalRows);
	    	String username = sheet.getRow(0).getCell(0).getStringCellValue();
	    	logger.info("read username from excel....");
	    	String pass = sheet.getRow(0).getCell(1).getStringCellValue();
	    	logger.info("read password from exccel...");
	    	
	    	System.out.println(username);
	    	System.out.println(pass);
	    	
	    	pr.signin(username,pass);
	    	
	    	logger.info("logged in successfully");
	    	  Thread.sleep(2000);
	    }
	    

	    

	    @AfterTest
	    public void tearDown() {

	        if(driver != null) {
	            driver.quit();
	        }
	    }
	    
	    
	    
	 
	}


