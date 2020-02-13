package co.com.nombreproyecto.stepsdefinitions;

import co.com.nombreproyecto.questions.TheItems;
import co.com.nombreproyecto.tasks.AddATodoItem;
import co.com.nombreproyecto.tasks.Start;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.hasItem;

public class ExampleStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el {string} ingresa a la pagina principal")
    public void queElIngresaALaPaginaPrincipal(String actor) {
        OnStage.theActorCalled(actor)
            .attemptsTo(
                Start.onMainPage()
            );
    }

    @When("diligencia el formulario solo con origen y destino")
    public void diligenciaElFormularioSoloConOrigenYDestino() {
        System.out.println("gg");
    }

    @Then("el usuario no registrado deberia ver los resultados correspondientes al origen y destino establecidos")
    public void elUsuarioNoRegistradoDeberiaVerLosResultadosCorrespondientesAlOrigenYDestinoEstablecidos() {
        System.out.println("step vacio");
    }

    @Given("que el {string} ingresa a la pagina exapmles todomvc")
    public void queElIngresaALaPaginaExapmlesTodomvc(String actor) {
        OnStage.theActorCalled(actor)
            .attemptsTo(
                Start.withAnEmptyList()
            );
    }

    @When("realiza la busqueda por {string}")
    public void realizaLaBusquedaPor(String param) {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                AddATodoItem.called(param)
            );
    }

    @Then("deberia ver {string} en la lista de resultados")
    public void deberiaVerEnLaListaDeResultados(String param) {
        OnStage.theActorInTheSpotlight()
            .should(
                seeThat(
                    "the items displayed", TheItems.displayed(), hasItem(param)
                )
            );
    }

    @Then("validacion de estado")
    public void validacionDeEstado() {
        Ensure.that("last response status code is 200", response->response.statusCode(200));
//        theActorInTheSpotlight().should(seeThat("last response status code is 200", lastResponse().statusCode() == 200));
//        theActorInTheSpotlight().should(seeThat("last response status code is 200", LastResponseStatusCode.is(200)));

    }
}
