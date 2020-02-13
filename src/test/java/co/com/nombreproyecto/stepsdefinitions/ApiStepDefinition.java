package co.com.nombreproyecto.stepsdefinitions;

import co.com.nombreproyecto.model.PostUser;
import co.com.nombreproyecto.model.User;
import co.com.nombreproyecto.paths.ServicePaths;
import co.com.nombreproyecto.steps.PlatformAdminSteps;
import co.com.nombreproyecto.steps.ValidationCommon;
import co.com.nombreproyecto.tasks.SoapTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;

import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.when;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

public class ApiStepDefinition {
    @Steps
    PlatformAdminSteps pas;
    @Steps
    ValidationCommon vc;



    @Given("{string} llama a servicio stats records")
    public void llamaAServicioStatsRecords(String actor) throws MalformedURLException {
        Actor.named(actor);
        theActor(actor);
        //        SerenityRest.useRelaxedHTTPSValidation();
        SerenityRest.given().get(ServicePaths.pathIexStatsRecords())
//        SerenityRest.given().get("https://api.iextrading.com/1.0/stats/records")
//        SerenityRest.when().get("/stats/records")
            .then().statusCode(200);
    }

    @When("Se valida data de volume con JsonPath")
    public void seValidaDataDeVolumeConJsonPath() {

        String volumeRecordValue=SerenityRest.lastResponse().jsonPath().getString("volume.recordDate");
        assertThat(volumeRecordValue).isEqualTo("2018-12-20");
    }

    @Then("Se valida data de notional y routedVolume con JsonPath")
    public void seValidaDataDeNotionalYRoutedVolumeConJsonPath() {
        Ensure.that("Se valida routed voleme",
            response->response.body("routedVolume.previousDayValue",Matchers.greaterThan(2)));
//        int routedVolume=SerenityRest.lastResponse().jsonPath().getInt("routedVolume.previousDayValue");
//        assertThat(routedVolume).isEqualTo(29329305);
    }

    @Given("get webservice")
    public void getWebservice() throws MalformedURLException {
//        SerenityRest.setDefaultBasePath("https://reqres.in");
//         String theRestApiBaseUrl;
//         EnvironmentVariables environmentVariables = EnvironmentVariables.class;
//        theRestApiBaseUrl = environmentVariables.getProperty("restapi.baseurl");

        SerenityRest.useRelaxedHTTPSValidation();
        SerenityRest.given().get(ServicePaths.pathReqResUsers2())
//        SerenityRest.given().get("https://reqres.in/api/users?page=2")
//        SerenityRest.when().get("/users?page=2")
            .then().statusCode(200);
    }

    @When("no implemented")
    public void noImplemented() {
    }

    @And("se obtiene lista de id usuarios")
    public void seObtieneListaDeIdUsuarios() {
        //        List<Integer> usersId = SerenityRest.lastResponse().jsonPath().getList("data.id");
//        usersId.forEach(
//                id -> assertThat(id).isGreaterThan(0)
//        );
    }

    @Given("get webservice validando headers y estado menor que")
    public void getWebserviceValidandoHeadersYEstadoMenorQue() throws MalformedURLException {
        SerenityRest.useRelaxedHTTPSValidation();

        SerenityRest.when().get(ServicePaths.pathReqResUsers2())
//        SerenityRest.when().get("https://reqres.in/api/users?page=2")
//        SerenityRest.when().get("/users?page=2")
            .then().statusCode(lessThan(300))
            .and().contentType(ContentType.JSON)
            .headers("Content-Type", "application/json; charset=utf-8",
                "Transfer-Encoding", "chunked");
    }

    @And("se obtiene lista de usuarios y se hacen validaciones")
    public void seObtieneListaDeUsuariosYSeHacenValidaciones() {
        List<User> users = SerenityRest.lastResponse().jsonPath().getList("data", User.class);
        
        users.stream()
            .filter(user -> user.getEmail().contains("w"))
            .collect(Collectors.toList())
            .forEach(user -> {
                assertThat(user.getId()).isGreaterThan(0);
                assertThat(user.getEmail()).contains("@");
            });
    }

    @Given("Se consume el servicio usando pathParam {string}")
    public void seConsumeElServicioUsandoPathParam(String path) throws MalformedURLException {

//        given().pathParam("var", path)
//            .when().get(ServicePaths.pathJsonTest().toString().concat("/{var}/one/{var}"))
////            .when().get("http://echo.jsontest.com/key/{var}/one/{var}")
//            .then().statusCode(200);
    }

    @When("se valida tag {string}")
    public void seValidaTag(String arg0) {
    }

    @Given("Se consume el servicio usando query {string}")
    public void seConsumeElServicioUsandoQuery(String query) throws MalformedURLException {
        given().queryParam("symbols",query).
            when().get(ServicePaths.pathIexTest());
//            when().get("https://api.iextrading.com/1.0/tops/last");
//        when().get("/tops/last");
//        when().get("/tops/last?symbols=aapl");
        Ensure.that("The stock y appl", response->response.body("symbol[0]",equalTo("AAPL")))
            .andThat("The price is not zero",response->response.body("price[0]",greaterThan(0.0f)));


    }

    @When("Se valida data de volume")
    public void seValidaDataDeVolume() {

        Ensure.that("mensaje de validacion", response->response.body("volume.recordValue",equalTo(301897950)))
            .andThat("mensaje de validacion 2",response->response.body("volume.recordDate",equalTo("2018-12-20")));

//        SerenityRest.lastResponse()
//            .then().body("volume.recordValue", Matchers.equalTo(301897950))
//            .and().body("volume.recordDate", Matchers.equalTo("2018-12-20"));
    }

    @Then("Se valida data de notional y routedVolume")
    public void seValidaDataDeNotionalYRoutedVolume() {

       vc.validateSchema("schemas/example/reqrest-example.json");
       
        Ensure.that("Se valida data de notional y routedVoliume",
            validatableResponse -> validatableResponse.body("notional.recordDate", Matchers.equalTo("2018-02-06")));
        Ensure.that("Se valida data de routedVolume",
            validatableResponse -> validatableResponse.body("routedVolume.previousDayValue", Matchers.greaterThan(2)));

    }

    @Given("post webservice")
    public void postWebservice() throws MalformedURLException {
        PostUser newUser = PostUser.builder()
            .name("morpheus")
            .job("leader")
            .build();
        pas.createNewUser(newUser);
    }

    @When("se obtiene valor de la ultima respuesta")
    public void seObtieneValorDeLaUltimaRespuesta() {
        System.out.println(lastResponse().asString());

        String name = SerenityRest.lastResponse().jsonPath().getString("name");
        System.out.println("*******" + name + "*****");
    }

    @And("se obtiene pojo desde respuesta")
    public void seObtienePojoDesdeRespuesta() {
//        PostUser postUser=SerenityRest.lastResponse().as(PostUser.class, ObjectMapperType.JACKSON_2);
//        System.out.println(postUser.toString());
    }

    @Then("se validan los datos de respuesta")
    public void seValidanLosDatosDeRespuesta() {
        Ensure.that("Nombre de usuario", response -> response.body("name", Matchers.equalTo("morpheus")));
        Ensure.that("Job", response -> response.body("job", Matchers.equalTo("leader")));
//        Ensure.that("id", response -> response.body("id", equalTo("515")));
        Ensure.that("Creado",response->response.body("createdAt",containsString("2019")))        ;

    }

    @Given("delete webservice")
    public void deleteWebservice() {
        //        SerenityRest.given().pathParam("id",2)
//                .when().delete("/users/{id}")
//                .then().statusCode(204);
        when().delete("https://reqres.in/api/users/{id}",2)
//        when().delete("/users/{id}",2)
            .then().statusCode(204);
    }

    @When("no implemented delete")
    public void noImplementedDelete() {
    }

    @Then("no implemented delte then")
    public void noImplementedDelteThen() {
    }

    @Given("put webservice")
    public void putWebservice() throws MalformedURLException {
        PostUser newUser = PostUser.builder()
            .name("morpheus")
            .job("leader")
            .build();

        SerenityRest.given().contentType("application/json")
            .and().body(newUser)
            .when().put(ServicePaths.pathReqResUsers())
//            .when().put("https://reqres.in/api/users")
//                .when().put("/users")
            .then().statusCode(200)
            .and().body("id", not(Matchers.equalTo(0)));

    }
    private static final String CESAR = "Cesar";

    @Given("soap post webservice")
    public void soapPostWebservice() {
        OnStage.setTheStage(new OnlineCast());

        theActorCalled(CESAR).whoCan(CallAnApi.at("http://www.dneonline.com"));

        theActorInTheSpotlight().attemptsTo(
             SoapTest.post()
        );
        System.out.println("+++++++"+lastResponse().asString());

    }
}
