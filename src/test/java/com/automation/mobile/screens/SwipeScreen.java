package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends BaseScreen {

    private static final String SWIPE_TITLE = "UiSelector().text(\"Swipe horizontal\")";
    private static final String SWIPE_DESCRIPTION = "UiSelector().text(\"Or swipe vertical to find what I'm hiding.\")";
    private static final String GITHUB_CARD = "UiSelector().description(\"card\").instance(0)";

    @AndroidFindBy(uiAutomator = SWIPE_TITLE)
    private WebElement titleTxt;

    @AndroidFindBy(uiAutomator = SWIPE_DESCRIPTION)
    private WebElement descriptionTxt;

    @AndroidFindBy(uiAutomator = GITHUB_CARD)
    private WebElement githubCard;


    public boolean isSwipeScreenTitleVisible() {
        return super.isElementVisible(titleTxt);
    }

    public boolean isSwipeScreenDescriptionVisible() {
        return super.isElementVisible(descriptionTxt);
    }

    public boolean isGithubCardVisible() {
        return super.isElementVisible(titleTxt);
    }

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }
}
