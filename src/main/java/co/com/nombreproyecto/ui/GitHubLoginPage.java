package co.com.nombreproyecto.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:github.login.page")
public class GitHubLoginPage extends PageObject {

    public static final Target CAMPO_TEXTO_BUSCAR=Target.the("Campo de texto buscar de google")
            .located(By.name("q"));

    public static final Target BOTON_BUSCAR=Target.the("Boton buscar de google")
            .located(By.name("btnK"));

}