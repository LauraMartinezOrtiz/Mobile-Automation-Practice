package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DragDropScreen extends BaseScreen {

    private static final String DRAGDROP_TITLE = "UiSelector().text(\"Drag and Drop\")";
    private static final String RELOAD_BUTTON = "UiSelector().text(\"\uDB80\uDC6A\")";
    private static final String IMAGE_TO_DROP_INTO = "UiSelector().className(\"android.widget.ImageView\").instance(0)";

    @AndroidFindBy(uiAutomator = DRAGDROP_TITLE)
    private WebElement titleTxt;

    @AndroidFindBy(uiAutomator = RELOAD_BUTTON)
    private WebElement reloadBtn;

    @AndroidFindBy(uiAutomator = IMAGE_TO_DROP_INTO)
    private WebElement image;


    public boolean isDragDropScreenTitleVisible() {
        return super.isElementVisible(titleTxt);
    }

    public boolean isReloadButtonVisible() {
        return super.isElementVisible(reloadBtn);
    }

    public boolean isImageVisible() {
        return super.isElementVisible(image);
    }

    public DragDropScreen(AndroidDriver driver) {
        super(driver);
    }
}
