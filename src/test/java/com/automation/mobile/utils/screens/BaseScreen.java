package com.automation.mobile.utils.screens;

import com.automation.mobile.screens.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {

    protected AndroidDriver driver;

    private static final String WEBVIEW_SCREEN_BTN = "Webview";
    private static final String LOGIN_SCREEN_BTN = "Login";
    private static final String FORMS_SCREEN_BTN = "Forms";
    private static final String SWIPE_SCREEN_BTN = "Swipe";
    private static final String DRAG_DROP_SCREEN_BTN = "Drag";

    @AndroidFindBy(accessibility = WEBVIEW_SCREEN_BTN)
    private WebElement webViewBtn;

    @AndroidFindBy(accessibility = LOGIN_SCREEN_BTN)
    private WebElement loginBtn;

    @AndroidFindBy(accessibility = FORMS_SCREEN_BTN)
    private WebElement formsBtn;

    @AndroidFindBy(accessibility = SWIPE_SCREEN_BTN)
    private WebElement swipeBtn;

    @AndroidFindBy(accessibility = DRAG_DROP_SCREEN_BTN)
    private WebElement dragBtn;


    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebViewScreen openWebViewScreen() {
        webViewBtn.click();
        return new WebViewScreen(driver);
    }

    public LoginScreen openLoginScreen() {
        loginBtn.click();
        return new LoginScreen(driver);
    }

    public FormsScreen openFormsScreen() {
        formsBtn.click();
        return new FormsScreen(driver);
    }

    public SwipeScreen openSwipeScreen() {
        swipeBtn.click();
        return new SwipeScreen(driver);
    }

    public DragDropScreen openDragDropScreen() {
        dragBtn.click();
        return new DragDropScreen(driver);
    }

    protected boolean isElementVisible(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    protected boolean isElementHidden(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.invisibilityOf(element));
        return element.isEnabled();
    }

    protected void waitSomeSeconds(double time) {
        try {
            Thread.sleep((long) (time * 1000));
        } catch (InterruptedException ignored) {

        }
    }
}
