package com.labradorlabs.heyoung_ui.steps_definitions;

import com.labradorlabs.heyoung_ui.pages.LoginPage;
import com.labradorlabs.heyoung_ui.utilities.BrowserUtils;
import com.labradorlabs.heyoung_ui.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class LoginPasswordValidationSteps {
    LoginPage loginPage = new LoginPage();

    @When("user enters a valid email")
    public void user_enters_a_valid_email() {
        loginPage.userEmailInput.sendKeys("user@doubleat.com");
        BrowserUtils.sleep(2);
    }

    @When("user enters a invalid {string}")
    public void user_enters_a_invalid(String passwords) {

        List<String> passwordList = Arrays.asList(passwords);

        for (String password : passwordList) {
            loginPage.passwordInput.clear();
            loginPage.passwordInput.sendKeys(password);

        }
    }

    @Then("verify an login password Error Message {string} is displayed")
    public void verify_an_login_password_error_message_is_displayed(String expectedMessage) {
        String actualMessage = loginPage.loginPasswordErrorMessage.getText();
        Assert.assertEquals("Error message does not match!", expectedMessage, actualMessage);
    }


}


