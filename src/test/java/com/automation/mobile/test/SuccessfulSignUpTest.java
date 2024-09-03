package com.automation.mobile.test;

import com.automation.mobile.screens.HomeScreen;
import com.automation.mobile.screens.LoginScreen;
import com.automation.mobile.screens.SignUpScreen;
import com.automation.mobile.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SuccessfulSignUpTest extends BaseTest {

    private LoginScreen loginScreen;

    @Test
    public void checkLoginScreenTest() {
        HomeScreen homeScreen = returnHomeScreen();
        loginScreen = homeScreen.openLoginScreen();
        Assert.assertTrue(loginScreen.isLoginScreenTitleVisible());
        Assert.assertTrue(loginScreen.isLoginFormVisible());
        Assert.assertTrue(loginScreen.isEmailInputVisible());
        Assert.assertTrue(loginScreen.isPasswordInputVisible());
        Assert.assertTrue(loginScreen.isLoginButtonVisible());
    }

    @Test
    @Parameters({"password"})
    public void successfulSignUpTest(String password) {
        SignUpScreen signUpScreen = loginScreen.openSignUpScreen();
        Assert.assertTrue(signUpScreen.isSignUpScreenTitleVisible());
        Assert.assertTrue(signUpScreen.isSignUpFormVisible());
        Assert.assertTrue(signUpScreen.isEmailInputVisible());
        Assert.assertTrue(signUpScreen.isPasswordInputVisible());
        Assert.assertTrue(signUpScreen.isRepeatPasswordInputVisible());
        Assert.assertTrue(signUpScreen.isSignUpButtonVisible());

        signUpScreen.setEmail();
        signUpScreen.setPassword(password);
        signUpScreen.setRepeatPassword(password);
        Assert.assertTrue(signUpScreen.isSuccessAlertVisible());
        Assert.assertTrue(signUpScreen.isSuccessTitleVisible());
        Assert.assertTrue(signUpScreen.isSuccessMsgVisible());
        Assert.assertEquals(signUpScreen.getSignUpTitle(), "Signed Up!");
        Assert.assertEquals(signUpScreen.getSignUpMsg(), "You successfully signed up!");

    }
}
