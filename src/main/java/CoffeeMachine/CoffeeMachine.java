package CoffeeMachine;

import CoffeeMachine.Coffee.Coffee;
import CoffeeMachine.Coffee.CoffeeType;
import CoffeeMachine.Coffee.LongCoffee;
import CoffeeMachine.Coffee.NormalCoffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static CoffeeMachine.Constans.CoffeeMachineConstants.*;

public class CoffeeMachine {

    private int waterLevel;
    private int coffeeLevel;
    private int coffeeGroundLevel;
    private int howManyCupOfCoffee;

    private CoffeeType coffeeType;

    private List<Coffee> coffees = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    public void menu() {
        while (true){
        separator();
        System.out.println("|Water Level = " + waterLevel);
        System.out.println("|Coffee Ground Level = " + coffeeGroundLevel);
        System.out.println("|Coffee Level = " + coffeeLevel);

        separator();
        System.out.println("| Turn Off The Machine[1]|");
        System.out.println("| Normal Coffe        [2]|");
        System.out.println("| Long Coffe          [3]|");
        separator();

        int menuPoint = input.nextByte();

        do {
            switch (menuPoint) {
                case 1 -> {
                    System.out.println("The Machine is going to shutdown Have a nice day!");
                    System.exit(0);
                }
                case 2 -> coffeeType = CoffeeType.NORMAL;
                case 3 -> coffeeType = CoffeeType.LONG;
                default -> {
                    menuPoint = input.nextInt();
                    System.out.println("bad input");
                }
            }
        } while (menuPoint != 1 && menuPoint != 2 && menuPoint != 3);
        howManyCoffeeWouldULikeToDrink();
        }
    }

    private void howManyCoffeeWouldULikeToDrink(){
        System.out.println("How Many cup of Coffee would u like to drink?");
        howManyCupOfCoffee = input.nextInt();
        makeCoffee(coffeeType);
    }

    private void makeCoffee(CoffeeType coffeeType) {
        Coffee coffee = switch (coffeeType) {
            case LONG -> new LongCoffee();
            case NORMAL -> new NormalCoffee();
        };

        for (int i = 0; i < howManyCupOfCoffee; i++) {
            CheckConditions(coffee);
            waterLevel -= coffee.getWaterPortion() / coffee.getCoffeePortion();
            coffeeLevel -= coffee.getCoffeePortion();
            coffeeGroundLevel += coffee.getCoffeePortion();
            System.out.println("Here You are, Enjoy your " + coffeeType.toString() + " Coffee");
            coffees.add(coffee);
        }
    }


    public void CheckConditions(Coffee coffee) {
        if (waterLevel - coffee.getWaterPortion() < coffee.getWaterPortion()) {
            fillTheTankWithWater();
        }
        if (coffeeLevel - coffee.getCoffeePortion() < coffee.getCoffeePortion()) {
            fillTheTankWithCoffee();
        }
        if (coffeeGroundLevel >= COFFEE_GROUND_TANK - coffee.getCoffeePortion()) {
            emptyTheCoffeeGround();
        }
    }

    private void fillTheTankWithWater() {
        System.out.println("There is not Enough Water to cook this type of coffee");
        System.out.println("Please pour some water to the water tank");
        System.out.println("Waiting...");

        pressAnyKeyToContinue();
        fillProgressBar();
        waterLevel = WATER_TANK_SIZE;
    }

    private void fillTheTankWithCoffee() {
        System.out.println("There is not enough coffee inside the machine please pour some coffee!");
        System.out.println("Waiting...");

        pressAnyKeyToContinue();
        fillProgressBar();
        coffeeLevel = COFFEE_TANK_SIZE;
    }

    private void emptyTheCoffeeGround() {
        System.out.println("The coffee ground are full please empty the tank");
        System.out.println("Waiting...");
        pressAnyKeyToContinue();
        fillProgressBar();
        coffeeGroundLevel = 0;
    }

    //helper methods

    private void fillProgressBar() {
        for (int i = 0; i <= 100; i += 10) {
            try {
                Thread.sleep(125);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(i + "% ");
        }
        clearScreen();
    }

    public static void clearScreen() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    private void pressAnyKeyToContinue() {
        System.out.println("Press any key to fix the problem ...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    private void separator() {
        System.out.println("__________________________");
    }
}



