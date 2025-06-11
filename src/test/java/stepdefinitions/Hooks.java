package stepdefinitions;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private TestContext testContext;
    private WebDriver driver;

    // Constructor should use the passed-in TestContext
    public Hooks(TestContext context) {
        this.testContext = context;
    }

    @Before
    public void initialize() {
        // Initialize the WebDriver (e.g., ChromeDriver or EdgeDriver)
        driver = new EdgeDriver();  // Change to EdgeDriver or another browser if necessary
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Set the driver in the TestContext, this should be used across steps
        testContext.setDriver(driver);
    }

    @After
    public void closeBrowser(Scenario scenario) {

    	    if (scenario.isFailed()) {
    	        TakesScreenshot ts = (TakesScreenshot) driver;
    	        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
    	        scenario.attach(screenshot, "image/png", scenario.getName());
    	    }
            testContext.getDriver().close();

//         Close the browser after each test
//        testContext.getDriver().quit();
    }
}
