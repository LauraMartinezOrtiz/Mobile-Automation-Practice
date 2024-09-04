package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {

    private static final String LOGIN_TITLE = "UiSelector().text(\"Login / Sign up Form\")";
    private static final String LOGIN_FORM = "UiSelector().className(\"android.view.ViewGroup\").instance(12)";
    private static final String LOGIN_BTN = "button-LOGIN";
    private static final String SIGNUP_LABEL_BTN = "UiSelector().text(\"Sign up\")";
    private static final String LOGIN_EMAIL_INPUT = "input-email";
    private static final String PASSWORD_INPUT = "input-password";

    private static final String LOGIN_SUCCESSFUL_ALERT = "UiSelector().className(\"android.widget.FrameLayout\").instance(0)";
    private static final String LOGIN_SUCCESS_TITLE = "UiSelector().resourceId(\"android:id/alertTitle\")";
    private static final String LOGIN_SUCCESS_MSG = "UiSelector().resourceId(\"android:id/message\")";

    @AndroidFindBy(uiAutomator = LOGIN_TITLE)
    private WebElement titleTxt;

    @AndroidFindBy(uiAutomator = LOGIN_FORM)
    private WebElement loginForm;

    @AndroidFindBy(accessibility = LOGIN_BTN)
    private WebElement loginBtn;

    @AndroidFindBy(uiAutomator = SIGNUP_LABEL_BTN)
    private WebElement signUpLabelBtn;

    @AndroidFindBy(accessibility = LOGIN_EMAIL_INPUT)
    private WebElement emailInput;

    @AndroidFindBy(accessibility = PASSWORD_INPUT)
    private WebElement passwordInput;

    @AndroidFindBy(uiAutomator = LOGIN_SUCCESSFUL_ALERT)
    private WebElement loginAlert;

    @AndroidFindBy(uiAutomator = LOGIN_SUCCESS_TITLE)
    private WebElement successTitle;

    @AndroidFindBy(uiAutomator = LOGIN_SUCCESS_MSG)
    private WebElement successMsg;

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

    private boolean checkEmailInputEmpty() {
        String emailText = emailInput.getText();
        return emailText.isEmpty();
    }

    private boolean checkPasswordInputEmpty() {
        String passwordText = passwordInput.getText();
        return passwordText.isEmpty();
    }

    public boolean isLoginSuccessAlertVisible() {
        boolean checkAlert = false;
        if (!(checkEmailInputEmpty() | checkPasswordInputEmpty())) {
            loginBtn.click();
            checkAlert = super.isElementVisible(loginAlert);
        }
        return checkAlert;
    }

    public boolean isSuccessTitleVisible() {
        return super.isElementVisible(successTitle);
    }

    public boolean isSuccessMsgVisible() {
        return super.isElementVisible(successMsg);
    }

    public String getLoginSuccessfulTitle() {
        return successTitle.getText();
    }

    public String getLoginSuccessfulMsg() {
        return successMsg.getText();
    }

    public SignUpScreen openSignUpScreen() {
        signUpLabelBtn.click();
        return new SignUpScreen(driver);
    }

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }
}
