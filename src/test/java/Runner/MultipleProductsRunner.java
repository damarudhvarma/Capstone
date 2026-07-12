package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features = "src/test/java/Features/addMultipleProducts.feature",
		glue = {"StepDef","hooks"},
		monochrome = true,
		name= {
				"Add multiple products to cart"
			  },
		
		
		plugin = {
                "pretty",
                "html:target/MultipleProducts.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }

		)

public class MultipleProductsRunner extends AbstractTestNGCucumberTests {

}
