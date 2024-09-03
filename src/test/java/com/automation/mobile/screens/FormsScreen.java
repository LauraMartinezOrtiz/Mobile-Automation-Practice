package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FormsScreen extends BaseScreen {

    private static final String FORMS_TITLE_TXT = "UiSelector().text(\"Form components\")";
    private static final String FORM = "UiSelector().className(\"android.view.ViewGroup\").instance(8)";
    private static final String INPUT_FIELD = "text-input";
    private static final String SWITCH = "switch";
    private static final String DROPDOWN = "UiSelector().resourceId(\"text_input\")";
    private static final String ACTIVE_BTN = "button-Active";
    private static final String INACTIVE_BTN = "button-Inactive";

    @AndroidFindBy(uiAutomator = FORMS_TITLE_TXT)
    private WebElement titleTxt;

    @AndroidFindBy(uiAutomator = FORM)
    private WebElement form;

    @AndroidFindBy(accessibility = INPUT_FIELD)
    private WebElement inputField;

    @AndroidFindBy(accessibility = SWITCH)
    private WebElement switchElement;

    @AndroidFindBy(uiAutomator = DROPDOWN)
    private WebElement dropdown;

    @AndroidFindBy(accessibility = ACTIVE_BTN)
    private WebElement activeBtn;

    @AndroidFindBy(accessibility = INACTIVE_BTN)
    private WebElement inactiveBtn;


    public boolean isFormScreenTitleVisible() {
        return super.isElementVisible(titleTxt);
    }

    public boolean isFormVisible() {
        return super.isElementVisible(form);
    }

    public boolean isInputVisible() {
        return super.isElementVisible(inputField);
    }

    public boolean isSwitchVisible() {
        return super.isElementVisible(switchElement);
    }

    public boolean isDropdownVisible() {
        return super.isElementVisible(dropdown);
    }

    public boolean isActiveButtonVisible() {
        return super.isElementVisible(activeBtn);
    }

    public boolean isInactiveButtonVisible() {
        return super.isElementVisible(inactiveBtn);
    }

    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }
}
