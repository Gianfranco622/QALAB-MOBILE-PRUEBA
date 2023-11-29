package com.nttdata.screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SearchScreen extends PageObject {

    @AndroidFindBy(id = "com.airbnb.android:id/start_button")
    private WebElement formSearch;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Search destinations\"]")
    private WebElement searchInput;

    @AndroidFindBy(xpath = "//android.widget.GridView[@content-desc=\"Explore Airbnb\"]/androidx.compose.ui.platform.ComposeView[2]")
    private WebElement itemsResult;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.airbnb.android:id/n2_bottom_sheet_title_title\"]")
    private WebElement resultSearch;

    public void clickSearchInput(){
        formSearch.click();
        System.out.println("Se hara click en el campo de busqueda");
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(searchInput));
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchInput.click();
    }

    public boolean isItemsResultDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
            wait.until(ExpectedConditions.visibilityOf(itemsResult));
            return itemsResult.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public String getSearchsText() {
        // Realizar un scroll hacia arriba
        scrollUp();

        return resultSearch.getText();
    }

    public void scrollUp() {
        // Obtener el driver subyacente de Android
        AndroidDriver androidDriver = (AndroidDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();

        // Obtener dimensiones de la pantalla
        int screenHeight = androidDriver.manage().window().getSize().getHeight();

        // Definir puntos para el scroll hacia arriba
        int startX = screenHeight / 2;
        int startY = screenHeight / 2;
        int endY = (int) (screenHeight * 0.8); // Puedes ajustar este valor según tus necesidades

        // Realizar el scroll hacia arriba
        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

}
