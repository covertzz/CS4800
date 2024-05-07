import java.util.Scanner;
public class Driver {
    
    public static void main(String[] args) {
        UnitTests.testAll();
        VendingMachine vendingMachine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);
        Snack Coke = new Snack("Coke", 2.0, 3);
        Snack Pepsi = new Snack("Pepsi", 1.5, 5);
        Snack Cheetos = new Snack("Cheetos", 3.0, 10);
        Snack Doritos = new Snack("Doritos", 3.5, 7);
        Snack KitKat = new Snack("KitKat", 2.5, 20);
        Snack Snickers = new Snack("Snickers", 3.0, 1);

        vendingMachine.addSnack(Coke);
        vendingMachine.addSnack(Pepsi);
        vendingMachine.addSnack(Cheetos);
        vendingMachine.addSnack(Doritos);
        vendingMachine.addSnack(KitKat);
        vendingMachine.addSnack(Snickers);

        vendingMachine.printInventory();
        System.out.println("State: " + vendingMachine.getState());
        vendingMachine.tap();
        System.out.println("State: " + vendingMachine.getState());
        vendingMachine.selectSnack();
        System.out.println("State: " + vendingMachine.getState());
        vendingMachine.pay();
        System.out.println("State: " + vendingMachine.getState());
        vendingMachine.printInventory();

        scanner.close();
    }

}
