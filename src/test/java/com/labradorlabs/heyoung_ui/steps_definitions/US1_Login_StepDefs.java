package com.labradorlabs.heyoung_ui.steps_definitions;

import com.labradorlabs.heyoung_ui.pages.LoginPage;
import com.labradorlabs.heyoung_ui.utilities.BrowserUtils;
import com.labradorlabs.heyoung_ui.utilities.ConfigurationReader;
import com.labradorlabs.heyoung_ui.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class US1_Login_StepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        loginPage.navigateToLoginPage();
        loginPage.acceptedCookies();
        BrowserUtils.sleep(2);

    }

    @When("user enters organization url")
    public void user_enters_valid_url() {
        loginPage.urlInput.sendKeys(ConfigurationReader.getProperty("env1"));
        BrowserUtils.sleep(2);
    }

    @When("user enters a valid email and a valid password")
    public void user_enters_valid_email_and_valid_password() {
        loginPage.userEmailInput.sendKeys(ConfigurationReader.getProperty("email"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(2);
    }

    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.signInBtn.click();
        BrowserUtils.sleep(2);
    }


    @Then("user should see the dashboard")
    public void verify_the_dashboard_is_displayed() {
        String expectedTitle = "Labrador";
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());


    }

}
