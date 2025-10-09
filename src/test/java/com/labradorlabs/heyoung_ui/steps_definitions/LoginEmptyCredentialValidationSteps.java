package com.labradorlabs.heyoung_ui.steps_definitions;

import com.labradorlabs.heyoung_ui.pages.LoginPage;
import com.labradorlabs.heyoung_ui.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginEmptyCredentialValidationSteps {
    LoginPage loginPage = new LoginPage();
    // ============================@empty_email==================================================
    @When("user enters a valid password")
    public void user_enters_a_valid_password() {
        loginPage.passwordInput.sendKeys("noSpecial123");
        BrowserUtils.sleep(2);
    }

    @Then("verify an email empty Error Message {string} is displayed")
    public void verify_an_email_empty_error_message_is_displayed(String expectedMessage) {
        String actualMessage = loginPage.loginEmailEmptyErrorMessage.getText();
        Assert.assertEquals("Error message does not match!", expectedMessage, actualMessage);
    }

    // ==========================@empty_password====================================================


    @Then("verify a password empty Error Message {string} is displayed")
    public void verify_a_password_empty_error_message_is_displayed(String expectedMessage) {
        String actualMessage = loginPage.loginPasswordEmptyErrorMessage.getText();
        Assert.assertEquals("Error message does not match!", expectedMessage, actualMessage);
    }

}
