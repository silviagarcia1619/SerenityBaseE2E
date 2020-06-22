package co.com.nombreproyecto.stepsdefinitions;

import co.com.nombreproyecto.tasks.IniciarGoogle;
import co.com.nombreproyecto.ui.PaginaPrincipalGoogle;
import co.com.nombreproyecto.ui.PaginaResultados;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

public class GoogleSteps {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el {string} esta en la pagina de google")
    public void queElEstaEnLaPaginaDeGoogle(String usuario) {
        OnStage.theActorCalled(usuario)
                .attemptsTo(
                        IniciarGoogle.enPaginaPrincipal()
                );
    }

    @When("el usuario busca por la palabra {string}")
    public void elUsuarioBuscaPorLaPalabra(String palabraClave) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        Enter.theValue(palabraClave).into(PaginaPrincipalGoogle.CAMPO_TEXTO_BUSCAR),
                        Click.on(PaginaPrincipalGoogle.BOTON_BUSCAR)
                );
    }

    @Then("se valida que el primer titulo tenga la palabra musica")
    public void seValidaQueElPrimerTituloTengaLaPalabraMusica() {
            Ensure.that(PaginaResultados.PRIMER_RESULTADO_MUSICA).text().contains("cocodrilo");
    }
}
