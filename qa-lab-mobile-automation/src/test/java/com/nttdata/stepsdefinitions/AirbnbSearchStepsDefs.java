package com.nttdata.stepsdefinitions;

import com.nttdata.steps.AirbnbSearchSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.io.File;

public class AirbnbSearchStepsDefs {

    @Steps
    AirbnbSearchSteps airbnbSearchSteps;

    @Given("que me encuentro en el login de Airbnb")
    public void que_me_encuentro_en_el_login_de_airbnb() {
        airbnbSearchSteps.clickClose();
    }

    @When("busco {string}")
    public void busco(String place) {
        airbnbSearchSteps.searchByText(place);
    }

    @Then("valido que exista al menos un resultado")
    public void validoQueExistaAlMenosUnResultado() {
        boolean isResultDisplayed = airbnbSearchSteps.getItemSize();
        assertTrue("Se espera que al menos un resultado esté presente", isResultDisplayed);
    }

    @And("se muestra el texto sobre la busquedas {string}")
    public void seMuestraElTextoSobreLaBusquedas(String resultSearchs) {
        Assert.assertEquals(airbnbSearchSteps.getSearchText(), resultSearchs);
    }


}
