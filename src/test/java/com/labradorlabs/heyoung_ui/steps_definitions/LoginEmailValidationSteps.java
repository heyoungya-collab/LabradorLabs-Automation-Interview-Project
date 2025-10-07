package com.labradorlabs.heyoung_ui.steps_definitions;

import com.labradorlabs.heyoung_ui.pages.LoginPage;
import com.labradorlabs.heyoung_ui.utilities.BrowserUtils;
import com.labradorlabs.heyoung_ui.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class LoginEmailValidationSteps {
    LoginPage loginPage = new LoginPage();

    @When("user enters invalid {string}")
    public void user_enters_invalid(String emails) {

        List<String> emailList = Arrays.asList(emails);

        for (int i = 0; i < emailList.size(); i++) {
            String email = emailList.get(i);

            loginPage.userEmailInput.clear();
            loginPage.userEmailInput.sendKeys(email);
            loginPage.passwordInput.clear();

        }


    }

    @Then("verify an login Email Error Message {string} is displayed")
    public void verify_an_login_Email_Error_Message_is_displayed(String expectedMessage) {
        String actualMessage = loginPage.loginEmailErrorMessage.getText();
        Assert.assertEquals("Error message does not match!", expectedMessage, actualMessage);
    }

//==============================================================================//


    @When("user enters a valid password")
    public void user_enters_a_valid_password() {
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(2);
    }

    @Then("verify an email empty Error Message {string} is displayed")
    public void verify_an_email_empty_error_message_is_displayed(String expectedMessage) {
        String actualMessage = loginPage.loginEmailEmptyErrorMessage.getText();
        Assert.assertEquals("Error message does not match!", expectedMessage, actualMessage);
    }
}
