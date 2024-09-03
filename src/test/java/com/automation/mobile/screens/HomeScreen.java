package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

    private static final String HOME_TITLE_TXT = "UiSelector().text(\"WEBDRIVER\")";
    private static final String HOME_DESCRIPTION_TXT = "UiSelector().text(\"Demo app for the appium-boilerplate\")";
    private static final String HOME_LOGO = "UiSelector().className(\"android.widget.ImageView\").instance(0)";

    @AndroidFindBy(uiAutomator = HOME_TITLE_TXT)
    private WebElement titleTxt;

    @AndroidFindBy(uiAutomator = HOME_DESCRIPTION_TXT)
    private WebElement descriptionTxt;

    @AndroidFindBy(uiAutomator = HOME_LOGO)
    private WebElement logo;

    public boolean isHomeScreenLogoVisible() {
        return super.isElementVisible(logo);
    }

    public boolean isHomeScreenTitleVisible() {
        return super.isElementVisible(titleTxt);
    }

    public String getHomeScreenDescription() {
        return descriptionTxt.getText();
    }

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }
}
