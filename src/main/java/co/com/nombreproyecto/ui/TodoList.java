package co.com.nombreproyecto.ui;
import net.serenitybdd.screenplay.targets.Target;

public class TodoList {
    public static final Target NEW_TODO=Target.the("New todo field")
        .locatedBy(".new-todo");
    public static final Target ITEMS =Target.the("Todo items")
        .locatedBy(".todo-list li") ;

}
