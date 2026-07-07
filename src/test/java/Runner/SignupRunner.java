package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/Features/signup.feature",
		glue = {"StepDef"},
		monochrome = true,
		plugin = {
                "pretty",
                "html:target/PrestoSop.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }

		)

public class SignupRunner extends AbstractTestNGCucumberTests{

}
