package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class SignUpScreen extends BaseScreen {

    private static final String LOGIN_TITLE = "UiSelector().text(\"Login / Sign up Form\")";
    private static final String SIGNUP_FORM = "UiSelector().className(\"android.view.ViewGroup\").instance(12)";
    private static final String SIGNUP_BTN = "button-SIGN UP";
    private static final String LOGIN_EMAIL_INPUT = "input-email";
    private static final String PASSWORD_INPUT = "input-password";
    private static final String REPEAT_PASSWORD_INPUT = "input-repeat-password";

    private static final String SUCCESS_ALERT = "UiSelector().className(\"android.widget.FrameLayout\").instance(0)";
    private static final String SUCCESS_TITLE = "UiSelector().resourceId(\"android:id/alertTitle\")";
    private static final String SUCCESS_MSG = "UiSelector().resourceId(\"android:id/message\")";

    private static final String LOGIN_LABEL_BTN = "UiSelector().text(\"Login\").instance(0)";
    private static final String OK_BUTTON = "UiSelector().resourceId(\"android:id/button1\")";

    @AndroidFindBy(uiAutomator = LOGIN_TITLE)
    private WebElement titleTxt;

    @AndroidFindBy(uiAutomator = SIGNUP_FORM)
    private WebElement signUpForm;

    @AndroidFindBy(accessibility = SIGNUP_BTN)
    private WebElement signUpBtn;

    @AndroidFindBy(accessibility = LOGIN_EMAIL_INPUT)
    private WebElement emailInput;

    @AndroidFindBy(accessibility = PASSWORD_INPUT)
    private WebElement passwordInput;

    @AndroidFindBy(accessibility = REPEAT_PASSWORD_INPUT)
    private WebElement repeatPasswordInput;

    @AndroidFindBy(uiAutomator = SUCCESS_ALERT)
    private WebElement alert;

    @AndroidFindBy(uiAutomator = SUCCESS_TITLE)
    private WebElement successTitle;

    @AndroidFindBy(uiAutomator = SUCCESS_MSG)
    private WebElement successMsg;

    @AndroidFindBy(uiAutomator = OK_BUTTON)
    private WebElement okBtn;

    @AndroidFindBy(uiAutomator = LOGIN_LABEL_BTN)
    private WebElement loginLabelBtn;

    public boolean isSignUpScreenTitleVisible() {
        return super.isElementVisible(titleTxt);
    }

    public boolean isSignUpFormVisible() {
        return super.isElementVisible(signUpForm);
    }

    public boolean isSignUpButtonVisible() {
        return super.isElementVisible(signUpBtn);
    }

    public boolean isEmailInputVisible() {
        return super.isElementVisible(emailInput);
    }

    public boolean isPasswordInputVisible() {
        return super.isElementVisible(passwordInput);
    }

    public boolean isRepeatPasswordInputVisible() {
        return super.isElementVisible(repeatPasswordInput);
    }

    public void setEmail() {
        String newEmail = generateRandomEmail();
        this.emailInput.sendKeys(newEmail);
    }

    public void setPassword(String password) {
        this.passwordInput.sendKeys(password);
    }

    public void setRepeatPassword(String password) {
        this.repeatPasswordInput.sendKeys(password);
    }

    public boolean isSuccessAlertVisible() {
        signUpBtn.click();
        return super.isElementVisible(alert);
    }

    public boolean isSuccessTitleVisible() {
        return super.isElementVisible(successTitle);
    }

    public boolean isSuccessMsgVisible() {
        return super.isElementVisible(successMsg);
    }

    public String getSignUpSuccessfulTitle(){
        return successTitle.getText();
    }

    public String getSignUpSuccessfulMsg(){
        return successMsg.getText();
    }

    public LoginScreen goBackToLoginScreen(){
        okBtn.click();
        super.isElementVisible(loginLabelBtn);
        loginLabelBtn.click();
        return new LoginScreen(driver);
    }

    private String generateRandomEmail() {
        String[] domains = {"@gmail.com", "@hotmail.com", "@outlook"};
        String domain = domains[new Random().nextInt(domains.length)];
        String email = RandomStringUtils.randomAlphanumeric(6);
        return email + domain;
    }

    public SignUpScreen(AndroidDriver driver) {
        super(driver);
    }
}
