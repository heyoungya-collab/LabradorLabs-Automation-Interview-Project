package com.labradorlabs.heyoung_ui.steps_definitions;

import com.labradorlabs.heyoung_ui.pages.LoginPage;
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
}

/*
bug: found a bug on ID email format

1. there is no specific guideline for ID format on error MSG (just shows "Not the correct email format.")
2. PW already sets to guide how to type or create but ID doesn't show the specific guideline like PW.
3. empty -> error MSG are different from regular error for Email ID
ACCEPT -> user_nodot@domain    /  user@domaincom   == accept only - dash and _ underscore instead of . dot
also accept without .
Email id format should clear direction


 */