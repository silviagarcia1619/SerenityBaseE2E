package co.com.nombreproyecto.tasks;

import co.com.nombreproyecto.ui.GitHubLoginPage;
import co.com.nombreproyecto.ui.PaginaPrincipalGoogle;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class IniciarGitHub implements Task {
    private GitHubLoginPage gitHubLoginPage;

    public static Performable enLogin() {
        return Instrumented.instanceOf(IniciarGitHub.class).newInstance();
    }

    @Override
    @Step("{0} abre la pagina principal")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(gitHubLoginPage));
    }
}
