package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/Features/signup.feature",
		glue = {"StepDef","hooks"},
		monochrome = true,
		plugin = {
                "pretty",
                "html:target/PrestoSop.html"
        }

		)

public class SignupRunner extends AbstractTestNGCucumberTests{

}
