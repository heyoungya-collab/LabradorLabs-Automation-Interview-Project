package com.labradorlabs.heyoung_ui.steps_definitions;

import com.labradorlabs.heyoung_ui.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class LoginCredentialsValidationSteps {
    LoginPage loginPage = new LoginPage();

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

    @Then("verify an error message {string}")
    public void verify_an_error_message(String expectedMessage) {
        String actualMessage = loginPage.loginErrorMessage.getText();
        Assert.assertEquals("Error message does not match!", expectedMessage, actualMessage);
    }
}

