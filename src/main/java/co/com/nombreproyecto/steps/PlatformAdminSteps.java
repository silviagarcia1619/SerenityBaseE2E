package co.com.nombreproyecto.steps;


import co.com.nombreproyecto.model.PostUser;
import co.com.nombreproyecto.paths.ServicePaths;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.net.MalformedURLException;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.Matchers.*;

public class PlatformAdminSteps {

    private String actor;
    @Step("#actor crea un nuevo usuario {0}")
    public void createNewUser(PostUser newUser) throws MalformedURLException {
        SerenityRest.useRelaxedHTTPSValidation();
        given().contentType(ContentType.JSON)
            .and().body(newUser)
            .when().post(ServicePaths.pathReqResUsers())
//                .when().post("/users")
            .then().statusCode(lessThan(300))
            .and().body("id", not(equalTo(0)));
    }
}
