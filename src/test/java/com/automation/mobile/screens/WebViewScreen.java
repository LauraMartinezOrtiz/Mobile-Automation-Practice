package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WebViewScreen extends BaseScreen {

    private static final String NAV_BAR_LOGO = "UiSelector().description(\"WebdriverIO\")";
    private static final String WEBVIEW_LOGO = "UiSelector().text(\"WebdriverIO\")";
    private static final String WEBVIEW_TITLE = "UiSelector().text(\"Next-gen browser and mobile automation test framework for Node.js\")";
    private static final String WEBVIEW_MINI_LOGO = "UiSelector().className(\"android.view.View\").instance(12)";


    @AndroidFindBy(uiAutomator = NAV_BAR_LOGO)
    private WebElement navBarLogo;

    @AndroidFindBy(uiAutomator = WEBVIEW_LOGO)
    private WebElement logo;

    @AndroidFindBy(uiAutomator = WEBVIEW_TITLE)
    private WebElement titleTxt;

    @AndroidFindBy(uiAutomator = WEBVIEW_MINI_LOGO)
    private WebElement miniLogo;


    public WebViewScreen(AndroidDriver driver) {
        super(driver);
        super.waitSomeSeconds(7);
    }

    public boolean isNavbarLogoVisible() {
        return super.isElementVisible(navBarLogo);
    }

    public boolean isWebViewScreenLogoVisible() {
        return super.isElementVisible(logo);
    }

    public boolean isWebViewScreenTitleVisible() {
        return super.isElementVisible(titleTxt);
    }

    public boolean isPopUpLogoVisible() {
        return super.isElementVisible(miniLogo);
    }
}
