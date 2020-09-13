package CoffeeMachine.Coffee;
import lombok.Getter;
import lombok.Setter;

public abstract class Coffee {
    @Getter @Setter
    private int coffeePortion = 0;
    @Getter @Setter
    private int waterPortion = 0;
}
