package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/Features/serachAndAddtoCart.feature",
		glue = {"StepDef"},
		monochrome = true,
		name= {"Add searched product to cart"},
		plugin = {
                "pretty",
                "html:target/SearchAndAddToCart.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }

		)

public class SearchAndAddToCartRunner extends AbstractTestNGCucumberTests {

}
