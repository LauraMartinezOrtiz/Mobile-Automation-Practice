package com.automation.mobile.test;

import com.automation.mobile.screens.*;
import com.automation.mobile.utils.tests.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigateOnBottomMenuTest extends BaseTest {

    private HomeScreen homeScreen;
    Logger log = LoggerFactory.getLogger(NavigateOnBottomMenuTest.class);

    @BeforeTest
    public void checkHomeScreenTest() {
        homeScreen = returnHomeScreen();
        Assert.assertTrue(homeScreen.isHomeScreenLogoVisible());
        Assert.assertTrue(homeScreen.isHomeScreenTitleVisible());
        Assert.assertEquals(homeScreen.getHomeScreenDescription(), "Demo app for the appium-boilerplate");
    }

    @Test
    public void navigateToWebViewScreen() {
        WebViewScreen webviewScreen = homeScreen.openWebViewScreen();
        Assert.assertTrue(webviewScreen.isNavbarLogoVisible());
        Assert.assertTrue(webviewScreen.isWebViewScreenLogoVisible());
        Assert.assertTrue(webviewScreen.isWebViewScreenTitleVisible());
        Assert.assertTrue(webviewScreen.isPopUpLogoVisible());
    }

    @Test
    public void navigateToLoginAndSignUpScreen() {
        LoginScreen loginScreen = homeScreen.openLoginScreen();
        Assert.assertTrue(loginScreen.isLoginScreenTitleVisible());
        Assert.assertTrue(loginScreen.isLoginFormVisible());
        Assert.assertTrue(loginScreen.isEmailInputVisible());
        Assert.assertTrue(loginScreen.isPasswordInputVisible());
        Assert.assertTrue(loginScreen.isLoginButtonVisible());

        SignUpScreen signUpScreen = loginScreen.openSignUpScreen();
        Assert.assertTrue(signUpScreen.isSignUpScreenTitleVisible());
        Assert.assertTrue(signUpScreen.isSignUpFormVisible());
        Assert.assertTrue(signUpScreen.isEmailInputVisible());
        Assert.assertTrue(signUpScreen.isPasswordInputVisible());
        Assert.assertTrue(signUpScreen.isRepeatPasswordInputVisible());
        Assert.assertTrue(signUpScreen.isSignUpButtonVisible());

    }

    @Test
    public void navigateToFormScreen() {
        FormsScreen formsScreen = homeScreen.openFormsScreen();
        Assert.assertTrue(formsScreen.isFormScreenTitleVisible());
        Assert.assertTrue(formsScreen.isFormVisible());
        Assert.assertTrue(formsScreen.isInputVisible());
        Assert.assertTrue(formsScreen.isSwitchVisible());
        Assert.assertTrue(formsScreen.isDropdownVisible());
        Assert.assertTrue(formsScreen.isActiveButtonVisible());
        Assert.assertTrue(formsScreen.isInactiveButtonVisible());

    }

    @Test
    public void navigateToSwipeScreen() {
        SwipeScreen swipeScreen = homeScreen.openSwipeScreen();
        Assert.assertTrue(swipeScreen.isSwipeScreenTitleVisible());
        Assert.assertTrue(swipeScreen.isSwipeScreenDescriptionVisible());
        Assert.assertTrue(swipeScreen.isGithubCardVisible());
    }

    @Test
    public void navigateToDragDropScreen() {
        DragDropScreen dragDropScreen = homeScreen.openDragDropScreen();
        Assert.assertTrue(dragDropScreen.isDragDropScreenTitleVisible());
        Assert.assertTrue(dragDropScreen.isReloadButtonVisible());
        Assert.assertTrue(dragDropScreen.isImageVisible());
    }

}
