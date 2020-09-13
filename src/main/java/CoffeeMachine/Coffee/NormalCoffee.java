package CoffeeMachine.Coffee;
import static CoffeeMachine.Constans.CoffeeConstants.*;

public class NormalCoffee extends Coffee{
    public NormalCoffee() {
        super.setCoffeePortion(NORMAL_COFFEE_PORTION);
        super.setWaterPortion(NORMAL_WATER_PORTION);
     }
}
