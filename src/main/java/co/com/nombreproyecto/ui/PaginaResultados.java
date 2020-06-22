package co.com.nombreproyecto.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaResultados {
    public static final Target PRIMER_RESULTADO_MUSICA=Target.the("Primer resultado de la pagina de google")
            .located(By.xpath("(//h3)[2]"));
}
