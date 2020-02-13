package co.com.nombreproyecto.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

public class SoapTest implements Task {


    public static Performable post() {
        return Instrumented.instanceOf(SoapTest.class).newInstance();
    }


    @Override
    @Step("{0} se consume soap post")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Post.to("/calculator.asmx?op=Add")
                .with(request -> request
                    .header("Content-Type", "text/xml; charset=utf-8")
                    .header("Accept-Encoding", "gzip,deflate")
                    .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                        "   <soapenv:Header/>\n" +
                        "   <soapenv:Body>\n" +
                        "      <tem:Add>\n" +
                        "         <tem:intA>40</tem:intA>\n" +
                        "         <tem:intB>30</tem:intB>\n" +
                        "      </tem:Add>\n" +
                        "   </soapenv:Body>\n" +
                        "</soapenv:Envelope>")
                )
        );
    }

//    public static ConsultBank withCode(int code) {
//        return instrumented(ConsultBank.class, code);
//    }
}
