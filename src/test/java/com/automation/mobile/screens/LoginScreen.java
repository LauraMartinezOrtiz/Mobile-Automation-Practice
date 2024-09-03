package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {

    private static final String LOGIN_TITLE = "UiSelector().text(\"Login / Sign up Form\")";
    private static final String LOGIN_FORM = "UiSelector().className(\"android.view.ViewGroup\").instance(12)";
    private static final String LOGIN_BTN = "UiSelector().className(\"android.view.ViewGroup\").instance(16)";
    private static final String SIGNUP_BTN = "UiSelector().text(\"Sign up\")";
    private static final String LOGIN_EMAIL_INPUT = "input-email";
    private static final String PASSWORD_INPUT = "input-password";

    @AndroidFindBy(uiAutomator = LOGIN_TITLE)
    private WebElement titleTxt;

    @AndroidFindBy(uiAutomator = LOGIN_FORM)
    private WebElement loginForm;

    @AndroidFindBy(uiAutomator = LOGIN_BTN)
    private WebElement loginBtn;

    @AndroidFindBy(uiAutomator = SIGNUP_BTN)
    private WebElement signUpBtn;

    @AndroidFindBy(accessibility = LOGIN_EMAIL_INPUT)
    private WebElement emailInput;

    @AndroidFindBy(accessibility = PASSWORD_INPUT)
    private WebElement passwordInput;

    public boolean isLoginScreenTitleVisible() {
        return super.isElementVisible(titleTxt);
    }

    public boolean isLoginFormVisible() {
        return super.isElementVisible(loginForm);
    }

    public boolean isEmailInputVisible() {
        return super.isElementVisible(emailInput);
    }

    public boolean isPasswordInputVisible() {
        return super.isElementVisible(passwordInput);
    }

    public boolean isLoginButtonVisible() {
        return super.isElementVisible(loginBtn);
    }

    public SignUpScreen openSignUpScreen() {
        signUpBtn.click();
        return new SignUpScreen(driver);
    }

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }
}
