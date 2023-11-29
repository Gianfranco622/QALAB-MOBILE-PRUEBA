package com.nttdata.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebElement;

public class SearchDetailsScreen extends PageObject {

    @AndroidFindBy(id="com.airbnb.android:id/input_bar_input")
    private WebElement searchDetailInput;

    @AndroidFindBy(id="com.airbnb.android:id/input_bar_input")
    private WebElement searchDetailInputText;

    @AndroidFindBy(id = "com.airbnb.android:id/n2_simple_search_footer_link")
    private WebElement skipButton;

    @AndroidFindBy(id = "com.airbnb.android:id/n2_dls_action_footer_gradient_button")
    private WebElement searchButton;

    public void enterSearchInput(String place){
        searchDetailInput.click();
        searchDetailInputText.sendKeys(place);

        // Obtener el driver subyacente de Android utilizando una conversión en cascada
        AndroidDriver androidDriver = (AndroidDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();

        // Enviar la tecla "Enter" después de ingresar texto
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void clickSkip(){
        skipButton.click();
    }

    public void clickSearch(){
        searchButton.click();
    }
}
