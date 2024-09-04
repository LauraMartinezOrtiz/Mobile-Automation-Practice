package com.automation.mobile.test;

import com.automation.mobile.screens.HomeScreen;
import com.automation.mobile.screens.LoginScreen;
import com.automation.mobile.screens.SignUpScreen;
import com.automation.mobile.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SuccessfulLoginTest extends BaseTest {

    SignUpScreen signUpScreen;

    @BeforeTest
    @Parameters({"password"})
    public void checkSignupScreenTest(String password) {
        HomeScreen homeScreen = returnHomeScreen();
        LoginScreen loginScreen = homeScreen.openLoginScreen();
        Assert.assertTrue(loginScreen.isLoginScreenTitleVisible());
        Assert.assertTrue(loginScreen.isLoginFormVisible());
        Assert.assertTrue(loginScreen.isEmailInputVisible());
        Assert.assertTrue(loginScreen.isPasswordInputVisible());
        Assert.assertTrue(loginScreen.isLoginButtonVisible());

        signUpScreen = loginScreen.openSignUpScreen();
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
        Assert.assertEquals(signUpScreen.getSignUpSuccessfulTitle(), "Signed Up!");
        Assert.assertEquals(signUpScreen.getSignUpSuccessfulMsg(), "You successfully signed up!");
    }

    @Test
    public void successfulLoginTest(){
        LoginScreen loginScreen = signUpScreen.goBackToLoginScreen();
        Assert.assertTrue(loginScreen.isLoginSuccessAlertVisible());
        Assert.assertTrue(loginScreen.isSuccessTitleVisible());
        Assert.assertTrue(loginScreen.isSuccessMsgVisible());
        Assert.assertEquals(loginScreen.getLoginSuccessfulTitle(), "Success");
        Assert.assertEquals(loginScreen.getLoginSuccessfulMsg(), "You are logged in!");
    }

}
