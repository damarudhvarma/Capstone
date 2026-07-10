package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/Features/SortProducts.feature",
		glue = {"StepDef"},
		monochrome = true,
		name= {"user sorts the products by name A to Z",
				"user sorts the products by Price, high to low",
				"user sorts the products by Price, low to high",
				"user sorts the products by Sales, highest to lowest"},
		plugin = {
                "pretty",
                "html:target/ContactUS.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }

		)

public class SortProductsRunner extends AbstractTestNGCucumberTests {

}
