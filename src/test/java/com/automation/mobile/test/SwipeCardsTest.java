package com.automation.mobile.test;

import com.automation.mobile.screens.HomeScreen;
import com.automation.mobile.screens.SwipeScreen;
import com.automation.mobile.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwipeCardsTest extends BaseTest {

    SwipeScreen swipeScreen;

    @BeforeTest
    public void checkSwipeScreen() {
        HomeScreen homeScreen = returnHomeScreen();
        swipeScreen = homeScreen.openSwipeScreen();
        Assert.assertTrue(swipeScreen.isSwipeScreenTitleVisible());
        Assert.assertTrue(swipeScreen.isSwipeScreenDescriptionVisible());
        Assert.assertTrue(swipeScreen.isFirstCardVisible());
    }

    @Test
    public void swipeCardsHorizontallyTest() {
        Assert.assertFalse(swipeScreen.isGithubCardVisible());
        Assert.assertFalse(swipeScreen.isCommunityCardVisible());
        Assert.assertFalse(swipeScreen.isJsCardVisible());
        Assert.assertFalse(swipeScreen.isSupportVideosCardVisible());
        Assert.assertFalse(swipeScreen.isExtendableCardVisible());
        Assert.assertTrue(swipeScreen.isCompatibleCardVisible());
    }

    @Test
    public void swipeVerticallyTest() {
        Assert.assertEquals(swipeScreen.getFoundMeTextMsg(), "You found me!!!");
    }
}
