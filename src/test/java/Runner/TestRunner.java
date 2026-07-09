package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/java/Features/user_login.feature",                    // Directory path holding your Gherkin feature files
    glue = {"StepDef", "hooks"},
    name = {
    		"PS01 - Verify user registration using email",
    		"User Login Verification Loop with Valid Credentials",
    		"PS03 - Search Product Add To Cart And Checkout",
    		"PS04 - Complete Guest Checkout"// Package names containing your action methods & lifecycle hooks
    },
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber-html-report.html", // Standard interactive HTML dashboard report
        "json:target/cucumber-reports/cucumber.json",             // Required backend JSON metadata matrix
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"         // Allure test lifecycle monitoring adapter plugin
    },
    monochrome = true                                             // Cleans unreadable formatting tokens from your terminal console view
)
public class TestRunner extends AbstractTestNGCucumberTests {
    
    // Optional Override: Keeps scenarios running sequentially in a single thread thread-pool allocation loop
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
    	 return super.scenarios();
    }
}
