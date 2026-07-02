package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/java/Features/Booking.feature",
		glue = {"StepDef"},
		monochrome = true,
		plugin = {
                "pretty",
                "html:target/shopping.html"
        }

		)

public class ShoppingRunner extends AbstractTestNGCucumberTests {

}
