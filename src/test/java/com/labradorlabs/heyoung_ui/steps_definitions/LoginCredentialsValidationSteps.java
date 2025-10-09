package com.labradorlabs.heyoung_ui.steps_definitions;

import com.labradorlabs.heyoung_ui.pages.LoginPage;
import com.labradorlabs.heyoung_ui.utilities.BrowserUtils;
import com.labradorlabs.heyoung_ui.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class LoginCredentialsValidationSteps {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        loginPage.navigateToLoginPage();
        loginPage.acceptedCookies();
        BrowserUtils.sleep(2);
    }

    @When("user enters organization url")
    public void user_enters_organization_url() {
        loginPage.urlInput.sendKeys(ConfigurationReader.getProperty("env1"));
        BrowserUtils.sleep(2);
    }


    @When("user enters {string} and {string}")
    public void user_enters_and(String emails, String passwords) {
        List<String> emailList = Arrays.asList(emails);
        List<String> passwordList = Arrays.asList(passwords);

        for (int i = 0; i < emailList.size(); i++) {
            String email = emailList.get(i);
            String password = passwordList.get(i);

            loginPage.userEmailInput.clear();
            loginPage.userEmailInput.sendKeys(email);
            loginPage.passwordInput.clear();
            loginPage.passwordInput.sendKeys(password);
            loginPage.signInBtn.click();
        }


    }

    @And("user clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.signInBtn.click();
        BrowserUtils.sleep(2);
    }


    @Then("verify an error message {string}")
    public void verify_an_error_message(String expectedMessage) {
        String actualMessage = loginPage.loginErrorMessage.getText();
        Assert.assertEquals("Error message does not match!", expectedMessage, actualMessage);
    }
}

