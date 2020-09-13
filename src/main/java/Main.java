import CoffeeMachine.CoffeeMachine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfiguration.class);

        CoffeeMachine cm = context.getBean("getACoffeeMachine", CoffeeMachine.class);
        cm.menu();
    }
}