import CoffeeMachine.CoffeeMachine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

@Bean
public CoffeeMachine getACoffeeMachine(){
    CoffeeMachine cm = new CoffeeMachine();
    return cm;
}
}
