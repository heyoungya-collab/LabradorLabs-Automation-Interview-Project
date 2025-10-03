package com.labradorlabs.heyoung_ui.pages;

import com.labradorlabs.heyoung_ui.utilities.ConfigurationReader;
import com.labradorlabs.heyoung_ui.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[.='Accept All']")
    public WebElement acceptedCookies;

    @FindBy(xpath = "//input[@name='url']")
    public WebElement urlInput;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement userEmailInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInBtn;

    @FindBy (xpath = "//div[@class='error-msg']")
    public WebElement errorMsg;


    public void acceptedCookies() {
        acceptedCookies.click();
    }

    public void navigateToLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    public void clickLoginButton() {
        this.signInBtn.click();
    }


}
