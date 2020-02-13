package co.com.nombreproyecto.questions;

import co.com.nombreproyecto.ui.TodoList;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

public class TheItems {
    //    public static <T> Question<"Esto se reemplaza por los datos que se van a retornar"> displayed() {
//    public static <T> Question<? extends T> displayed() {
    public static <T> Question<List<String>> displayed() {
        return actor -> Text.of(TodoList.ITEMS).viewedBy(actor).asList();
    }
}
