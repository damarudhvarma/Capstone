package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/java/Features/Booking.feature",
		glue = {"StepDef"},
		monochrome = true,
		name = {"user login search and buys a product","User order booking verification"},
		plugin = {
                "pretty",
                "html:target/shopping.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }

		)

public class ShoppingRunner extends AbstractTestNGCucumberTests {

}
