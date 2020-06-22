package co.com.nombreproyecto.stepsdefinitions;

import co.com.nombreproyecto.tasks.IniciarFacebook;
import co.com.nombreproyecto.tasks.IniciarGoogle;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class FacebookSteps {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el {string} esta en la pagina de inicio de sesion de facebook")
    public void queElEstaEnLaPaginaDeInicioDeSesionDeFacebook(String usuario) {

        OnStage.theActorCalled(usuario)
                .attemptsTo(
                        IniciarFacebook.enPaginaPrincipal()
                );

    }

    @Cuando("el usuario inicia sesion con credenciales erradas")
    public void elUsuarioIniciaSesionConCredencialesErradas() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        IniciarFacebook.enPaginaPrincipal()
                );
    }

    @Entonces("se valida que se informe el inicio de sesion fallido")
    public void seValidaQueSeInformeElInicioDeSesionFallido() {
    }
}
