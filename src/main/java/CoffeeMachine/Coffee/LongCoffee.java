package CoffeeMachine.Coffee;
import static CoffeeMachine.Constans.CoffeeConstants.*;

public class LongCoffee extends Coffee{
    public LongCoffee() {
        super.setCoffeePortion(LONG_COFFEE_PORTION);
        super.setWaterPortion(LONG_WATER_PORTION);
    }
}
