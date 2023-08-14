package org.opencart.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.opencart.pages.LoginPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class LoginPageStepDef {

    private LoginPage loginpg;
    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions op = new ChromeOptions();
        op.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(op);
        driver.manage().window().maximize();
    }

    @After
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }

    @Given("User is on the opencart login page")
    public void user_is_on_the_opencart_login_page() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginpg = new LoginPage(driver);
    }

    @Given("User entered valid username and password")
    public void user_entered_valid_username_and_password() {
        loginpg.enter_username("cucumber@test.com");
        loginpg.enter_password("cucumber");
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginpg.click_login_button();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertTrue(loginpg.check_logout_link());
    }

    @Given("User entered invalid {string} and {string}")
    public void user_entered_invalid_and(String n, String p) {
        loginpg.enter_username(n);
        loginpg.enter_password(p);
    }

    @Then("Error message should be displayed as {string}")
    public void error_message_should_be_displayed_as(String errorMessage) {
        Assert.assertEquals(loginpg.validate_error_msg().isDisplayed(), true);
    }

}
