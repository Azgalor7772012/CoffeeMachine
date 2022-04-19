import java.util.Scanner;

public class CoffeeMachineOnMassive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        Создаем массив int, где 0 индекс - кол-во воды, 1 - молока, 2 - кофе, 3 - стаканчики, 4 - деньги.
         */
        int[] ingredients = {400, 540, 120, 9, 550};
        // what to do

        String action;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.next();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: : ");
                    String secAction = scanner.next();
                    statisticBuy(secAction, ingredients);
                    break;
                case "fill":
                    statisticFill(scanner, ingredients);
                    break;
                case "take":
                    statisticTake(ingredients);
                    break;
                case "remaining":
                    printAmount(ingredients);
                    break;
            }
        } while (!(action.equals("exit")));
    }


    private static void statisticBuy(String secAction, int[] ingredients) {
        //0 индекс - кол-во воды, 1 - молока, 2 - кофе, 3 - стаканчики, 4 - деньги.
        switch (secAction) {
            case "1":
                espresso(ingredients);
                break;
            case "2":
                latte(ingredients);
                break;
            case "3":
                cappuccino(ingredients);
                break;
            case "back":
                break;
            default:
                System.out.println("I don't understand what you want");
                break;
        }

    }

    private static void statisticFill(Scanner scanner, int[] ingredients) {
        //0 индекс - кол-во воды, 1 - молока, 2 - кофе, 3 - стаканчики, 4 - деньги.
        System.out.println("Write how many ml of water you want to add:");
        int addWater = scanner.nextInt();
        ingredients[0] += addWater;
        System.out.println("Write how many ml of milk you want to add: ");
        int addMilk = scanner.nextInt();
        ingredients[1] += addMilk;
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int addCoffee = scanner.nextInt();
        ingredients[2] += addCoffee;
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int addCups = scanner.nextInt();
        ingredients[3] += addCups;
    }

    private static void statisticTake(int[] ingredients) {
        //0 индекс - кол-во воды, 1 - молока, 2 - кофе, 3 - стаканчики, 4 - деньги.
        System.out.printf("I gave you $%d\n", ingredients[4]);
        ingredients[4] = 0;
    }

    private static void printAmount(int[] ingredients) {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", ingredients[0]);
        System.out.printf("%d ml of milk\n", ingredients[1]);
        System.out.printf("%d g of coffee beans\n", ingredients[2]);
        System.out.printf("%d disposable cups\n", ingredients[3]);
        System.out.printf("$%d of money\n\n", ingredients[4]);
    }

    private static void espresso (int[] ingredients ) {
        int necessaryWater = ingredients[0] / 250;
        int necessaryCoffee = ingredients[2] / 16;
        int necessaryCups = ingredients[3];
        if (necessaryCoffee > 0 && necessaryCups > 0 && necessaryWater > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            ingredients[0] -= 250;
            ingredients[2] -= 16;
            ingredients[3] -= 1;
            ingredients[4] += 4;
        } else if (necessaryWater < 1) {
            System.out.println("Sorry, not enough water!");
        } else if (necessaryCoffee < 1){
            System.out.println("Sorry, not enough coffee beans!");
        } else {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }

    private static void latte (int[] ingredients ) {
        int necessaryWater = ingredients[0] / 350;
        int necessaryMilk = ingredients[1] / 75;
        int necessaryCoffee = ingredients[2] / 20;
        int necessaryCups = ingredients[3];
        if (necessaryCoffee > 0 && necessaryCups > 0 && necessaryWater > 0 && necessaryMilk > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            ingredients[0] -= 350;
            ingredients[1] -= 75;
            ingredients[2] -= 20;
            ingredients[3] -= 1;
            ingredients[4] += 7;
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

    private static void cappuccino (int[] ingredients ) {
        int necessaryWater = ingredients[0] / 200;
        int necessaryMilk = ingredients[1] / 100;
        int necessaryCoffee = ingredients[2] / 12;
        int necessaryCups = ingredients[3];
        if (necessaryCoffee > 0 && necessaryCups > 0 && necessaryWater > 0 && necessaryMilk > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            ingredients[0] -= 200;
            ingredients[1] -= 100;
            ingredients[2] -= 12;
            ingredients[4] += 6;
            ingredients[3] -= 1;
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

    //    private static void printSteps() {
//        System.out.println("Starting to make a coffee");
//        System.out.println("Grinding coffee beans");
//        System.out.println("Boiling water");
//        System.out.println("Mixing boiled water with crushed coffee beans");
//        System.out.println("Pouring coffee into the cup");
//        System.out.println("Pouring some milk into the cup");
//        System.out.println("Coffee is ready!");
//    }

//    private static void printIngredients(int cups) {
//        //Считаем кол-во ингредиентов
//        int water = cups * 200;
//        int milk = cups * 50;
//        int coffee = cups * 15;
//        //Печатаем
//        System.out.printf("For %d cups of coffee you will need:\n", cups);
//        System.out.printf("%d ml of water\n", water);
//        System.out.printf("%d ml of milk\n", milk);
//        System.out.printf("%d g of coffee beans\n", coffee);
//    }

}
