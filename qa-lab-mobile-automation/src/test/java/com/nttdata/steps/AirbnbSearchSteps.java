package com.nttdata.steps;

import com.nttdata.screens.LoginScreen;
import com.nttdata.screens.SearchDetailsScreen;
import com.nttdata.screens.SearchScreen;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AirbnbSearchSteps {

    LoginScreen loginScreen;
    SearchScreen searchScreen;
    SearchDetailsScreen searchDetailsScreen;

    @Step("Click en cerrar")
    public void clickClose(){
        loginScreen.clickClose();
    }

    @Step("Búsqueda por texto {0}")
    public void searchByText(String place){
        searchScreen.clickSearchInput();
        searchDetailsScreen.enterSearchInput(place);
        searchDetailsScreen.clickSkip();
        searchDetailsScreen.clickSearch();
    }

    @Step("Obtiene al menos un resultado")
    public boolean getItemSize() {
        return searchScreen.isItemsResultDisplayed();
    }

    @Step("Obtiene el texto de las busquedas")
    public String getSearchText() {
        return searchScreen.getSearchsText();
    }

}
