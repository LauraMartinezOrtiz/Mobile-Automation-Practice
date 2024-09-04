package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;


public class SwipeScreen extends BaseScreen {

    private static final String SWIPE_TITLE = "UiSelector().text(\"Swipe horizontal\")";
    private static final String SWIPE_DESCRIPTION = "UiSelector().text(\"Or swipe vertical to find what I'm hiding.\")";
    private static final String FIRST_CARD = "UiSelector().description(\"card\").instance(0)";
    private static final String GITHUB_CARD = "UiSelector().text(\"WebdriverIO is fully open source and can be found on GitHub\")";
    private static final String COMMUNITY_CARD = "UiSelector().text(\"GREAT COMMUNITY\")";
    private static final String JS_CARD = "UiSelector().text(\"JS FOUNDATION\")";
    private static final String SUPPORT_VIDEOS_CARD = "UiSelector().text(\"SUPPORT VIDEOS\")";
    private static final String EXTENDABLE_CARD = "UiSelector().text(\"EXTENDABLE\")";
    private static final String COMPATIBLE_CARD = "UiSelector().text(\"COMPATIBLE\")";

    private static final String FOUND_ME_TEXT = "UiSelector().text(\"You found me!!!\")";


    @AndroidFindBy(uiAutomator = SWIPE_TITLE)
    private WebElement titleTxt;

    @AndroidFindBy(uiAutomator = SWIPE_DESCRIPTION)
    private WebElement descriptionTxt;

    @AndroidFindBy(uiAutomator = FOUND_ME_TEXT)
    private WebElement foundMeText;

    @AndroidFindBy(uiAutomator = FIRST_CARD)
    private WebElement firstCard;

    @AndroidFindBy(uiAutomator = GITHUB_CARD)
    private WebElement githubCard;

    @AndroidFindBy(uiAutomator = COMMUNITY_CARD)
    private WebElement communityCard;

    @AndroidFindBy(uiAutomator = JS_CARD)
    private WebElement jsCard;

    @AndroidFindBy(uiAutomator = SUPPORT_VIDEOS_CARD)
    private WebElement supportVideosCard;

    @AndroidFindBy(uiAutomator = EXTENDABLE_CARD)
    private WebElement extendableCard;

    @AndroidFindBy(uiAutomator = COMPATIBLE_CARD)
    private WebElement compatibleCard;

    public boolean isSwipeScreenTitleVisible() {
        return super.isElementVisible(titleTxt);
    }

    public boolean isSwipeScreenDescriptionVisible() {
        return super.isElementVisible(descriptionTxt);
    }

    public boolean isFirstCardVisible() {
        return super.isElementVisible(firstCard);
    }

    public boolean isGithubCardVisible() {
        swipeHorizontal();
        return super.isElementHidden(githubCard);
    }

    public boolean isCommunityCardVisible() {
        swipeHorizontal();
        return super.isElementHidden(communityCard);
    }

    public boolean isJsCardVisible() {
        swipeHorizontal();
        return super.isElementHidden(jsCard);
    }

    public boolean isSupportVideosCardVisible() {
        swipeHorizontal();
        return super.isElementHidden(supportVideosCard);
    }

    public boolean isExtendableCardVisible() {
        swipeHorizontal();
        return super.isElementHidden(extendableCard);
    }

    public boolean isCompatibleCardVisible() {
        return super.isElementHidden(compatibleCard);
    }

    public String getFoundMeTextMsg() {
        swipeVertical();
        super.isElementVisible(foundMeText);
        return foundMeText.getText();
    }


    private void swipeHorizontal() {
        Dimension size = driver.manage().window().getSize();
        int cardWidth = (int) (size.width * 0.33);
        int startX = (int) (size.width * 0.7);
        int endX = startX - cardWidth;
        int startY = (int) (size.height * 0.6);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, startY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    private void swipeVertical() {
        int startX = 481;
        int startY = 286;

        int endY = 2167;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, endY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }


    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }
}
