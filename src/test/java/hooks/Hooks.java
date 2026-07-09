package hooks;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	public static WebDriver driver;

    @Before(order = 0)
    public void launchBrowser() {

        System.out.println(">>> Initializing ThreadLocal WebDriver instance...");

        BaseClass.initializeDriver();

        BaseClass.getDriver()
                 .get("https://demo.prestashop.com/#/en/front");
    }

    @AfterStep
    public void captureScreenshotAfterEveryStep(Scenario scenario) {

        WebDriver driver = BaseClass.getDriver();

        if (driver != null) {

            try {

                TakesScreenshot ts = (TakesScreenshot) driver;

                byte[] screenshotBytes =
                        ts.getScreenshotAs(OutputType.BYTES);

                String label = scenario.isFailed()
                        ? "Failed_Step_View"
                        : "Passed_Step_View";

                scenario.attach(screenshotBytes,
                        "image/png",
                        label);

            } catch (Exception e) {

                System.out.println(
                        "Screenshot capture warning : "
                        + e.getMessage());
            }
        }
    }

    @After(order = 0)
    public void closeBrowser(Scenario scenario)
            throws IOException {

        WebDriver driver = BaseClass.getDriver();

        if (scenario.isFailed() && driver != null) {

            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Files.copy(src,
                    new File("./screenshot/screenshot-"
                            + System.currentTimeMillis()
                            + ".png"));

            System.out.println(
                    "Screenshot captured for failed scenario");
        }

        System.out.println(">>> Quitting WebDriver instance...");

        BaseClass.quitDriver();
    }

    public static void screenshot() throws IOException {

        WebDriver driver = BaseClass.getDriver();

        if (driver != null) {

            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Files.copy(src,
                    new File("./screenshot/screenshot-"
                            + System.currentTimeMillis()
                            + ".png"));
        }
    }
}