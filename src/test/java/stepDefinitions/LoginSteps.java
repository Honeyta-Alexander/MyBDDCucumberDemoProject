package stepDefinitions;

import Utilities.ConfigReader;
import Utilities.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage lp = new LoginPage(DriverFactory.getDriver());
    private String expectedAppUrl;

    @Given("User is on login page")
    public void user_is_on_login_page() {
        expectedAppUrl = ConfigReader.getProperty("login_url");
        DriverFactory.getDriver().get(expectedAppUrl);
    }

    @When("user enters valid Email and Password")
    public void user_enters_valid_email_and_password() {
        String email = ConfigReader.getProperty("Email");
        String password = ConfigReader.getProperty("Password");
        lp.enterEmail(email);
        lp.enterPassword(password);
    }

    @When("Click on {string} button")
    public void click_on_button(String button) {
        lp.clickLogin();
    }

    @Then("User should navigate to homepage")
    public void user_should_navigate_to_homepage() {
        String actualAppUrl = DriverFactory.getDriver().getCurrentUrl();
        // You may need to adjust expected URL for homepage if different from login
        String expectedHomeUrl = ConfigReader.getProperty("homepage_url");
        Assert.assertEquals("User is not navigated to homepage!", expectedHomeUrl, actualAppUrl);
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        Assert.assertEquals(expectedTitle, lp.getPageTitle());
    }
}
