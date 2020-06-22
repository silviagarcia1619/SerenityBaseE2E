package co.com.nombreproyecto.tasks;

import co.com.nombreproyecto.ui.PaginaPrincipalFacebook;
import co.com.nombreproyecto.ui.PaginaPrincipalGoogle;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class IniciarFacebook implements Task {

    private PaginaPrincipalFacebook paginaPrincipalFacebook;

    public static Performable enPaginaPrincipal() {
        return Instrumented.instanceOf(IniciarFacebook.class).newInstance();
    }

    @Override
    @Step("{0} abre la pagina principal de facebook")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(paginaPrincipalFacebook)
        );
    }

}
