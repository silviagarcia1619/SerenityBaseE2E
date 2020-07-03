package co.com.nombreproyecto.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
//    plugin = {"pretty"},
//    features = "classpath:features"
    features = "src/test/resources/features/",
    glue = "co.com.nombreproyecto.stepsdefinitions",
//    tags = "not @example",
    tags = {"@google"},
    snippets = SnippetType.CAMELCASE

)
public class CucumberTestSuite {
}
