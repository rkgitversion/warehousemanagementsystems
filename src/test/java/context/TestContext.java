package context;

import org.openqa.selenium.WebDriver;

public class TestContext {

    private WebDriver driver;  // Make sure this is private for encapsulation
    private ScenarioContext scenarioContext;

    // Constructor to initialize ScenarioContext
    public TestContext() {
        scenarioContext = new ScenarioContext();
    }

    // Getter and Setter for WebDriver
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    // Getter for ScenarioContext
    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
