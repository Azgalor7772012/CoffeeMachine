import java.util.Scanner;

public class CoffeeMachineOnStaticVar {
    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // what to do

        String action;
        // ask  what drink you want until exit is taken
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.next();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: : ");
                    String secAction = scanner.next();
                    statisticBuy(secAction);
                    break;
                case "fill":
                    statisticFill(scanner);
                    break;
                case "take":
                    statisticTake();
                    break;
                case "remaining":
                    printAmount();
                    break;
            }
        } while (!(action.equals("exit")));
    }
    // Do actions according to the choice of coffee
    private static void statisticBuy(String secAction) {
        switch (secAction) {
            case "1":
                espresso();
                break;
            case "2":
                latte();
                break;
            case "3":
                cappuccino();
                break;
            case "back":
                break;
            default:
                System.out.println("I don't understand what you want");
                break;
        }

    }
    // ingredients adder
    private static void statisticFill(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        int addWater = scanner.nextInt();
        water += addWater;
        System.out.println("Write how many ml of milk you want to add: ");
        int addMilk = scanner.nextInt();
        milk += addMilk;
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int addCoffee = scanner.nextInt();
        coffee += addCoffee;
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int addCups = scanner.nextInt();
        cups += addCups;
    }
    // money taker
    private static void statisticTake() {
        System.out.printf("I gave you $%d\n", money);
        money = 0;
    }
    // ingredients printer
    private static void printAmount() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", water);
        System.out.printf("%d ml of milk\n", milk);
        System.out.printf("%d g of coffee beans\n", coffee);
        System.out.printf("%d disposable cups\n", cups);
        System.out.printf("$%d of money\n\n", money);
    }
    // espresso calculator
    private static void espresso ( ) {
        int necessaryWater = water / 250;
        int necessaryCoffee = coffee / 16;
        int necessaryCups = cups;
        if (necessaryCoffee > 0 && necessaryCups > 0 && necessaryWater > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 250;
            coffee -= 16;
            cups -= 1;
            money += 4;
        } else if (necessaryWater < 1) {
            System.out.println("Sorry, not enough water!");
        } else if (necessaryCoffee < 1){
            System.out.println("Sorry, not enough coffee beans!");
        } else {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }
    // latte calculator
    private static void latte () {
        int necessaryWater = water / 350;
        int necessaryMilk = milk / 75;
        int necessaryCoffee = coffee / 20;
        int necessaryCups = cups;
        if (necessaryCoffee > 0 && necessaryCups > 0 && necessaryWater > 0 && necessaryMilk > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 350;
            milk -= 75;
            coffee -= 20;
            cups -= 1;
            money += 7;
        } else if (necessaryWater < 1) {
            System.out.println("Sorry, not enough water!");
        } else if (necessaryCoffee < 1) {
            System.out.println("Sorry, not enough coffee beans!");
        }else if (necessaryMilk < 1) {
            System.out.println("Sorry, not enough milk!");
        } else {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }
    // cappucino calculator
    private static void cappuccino () {
        int necessaryWater = water/ 200;
        int necessaryMilk = milk / 100;
        int necessaryCoffee = coffee / 12;
        int necessaryCups = cups;
        if (necessaryCoffee > 0 && necessaryCups > 0 && necessaryWater > 0 && necessaryMilk > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 200;
            milk -= 100;
            coffee -= 12;
            money += 6;
            cups -= 1;
        } else if (necessaryWater < 1) {
            System.out.println("Sorry, not enough water!");
        } else if (necessaryCoffee < 1) {
            System.out.println("Sorry, not enough coffee beans!");
        }else if (necessaryMilk < 1) {
            System.out.println("Sorry, not enough milk!");
        } else {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }

}