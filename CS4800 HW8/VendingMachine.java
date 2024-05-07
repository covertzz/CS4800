import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {
    private StateOfVendingMachine stateOfVendingMachine = new IdleState();
    private SnackDispenserHandler snackDispenserHandler = new CokeHandler(new PepsiHandler(new CheetosHandler(new DoritosHandler(new KitKatHandler(new SnickersHandler(null))))));;
    private ArrayList<Snack> snackInventory= new ArrayList<Snack>();
    private Snack selectedSnack;
    Scanner scanner = new Scanner(System.in);

    public void addSnack(Snack snack) {
        snackInventory.add(snack);
    }
    public void tap() {
        getState().waitingForSnackSelection(this);
    }
    public void selectSnack() {
        System.out.print("Please select a snack: ");
        selectedSnack = stringToSnack(scanner.nextLine());
        if(selectedSnack == null) {
            getState().idle(this);
        }
        else {
            getState().acceptingPayment(this);
        }
    }
    public void pay() {
        double price = selectedSnack.getPrice();
        System.out.print("Please pay $" + price + ": ");
        double amount = scanner.nextDouble();
        if(amount == price) {
            getState().dispensingSnacks(this);
            dispenseSnack(selectedSnack);
        }
        else if(amount > price) {
            getState().dispensingSnacks(this);
            dispenseSnack(selectedSnack);
            returnChange(amount-price);
        }
        else if(amount < price) {
            System.out.println("Insufficient Money. Returning back to idle");
            getState().idle(this);
        }
    }
    public void pay(double amount) {
        double price = selectedSnack.getPrice();
        if(amount == price) {
            getState().dispensingSnacks(this);
            dispenseSnack(selectedSnack);
        }
        else if(amount > price) {
            getState().dispensingSnacks(this);
            dispenseSnack(selectedSnack);
            returnChange(amount-price);
        }
        else if(amount < price) {
            System.out.println("Insufficient Money. Returning back to idle");
            getState().idle(this);
        }
    }
    
    public StateOfVendingMachine getState() {
        return stateOfVendingMachine;
    }
    public void setState(StateOfVendingMachine state) {
        stateOfVendingMachine = state;
    }
    public void printInventory() {
        for(Snack snack : snackInventory) {
            System.out.println(snack.getName() + ": " + snack.getQuantity());
        }
    }
    public ArrayList<Snack> getInventory() {
        return snackInventory;
    }
    public Snack stringToSnack(String snackName) {
        for(Snack snack : snackInventory) {
            if(snack.getName().equals(snackName)) {
                return snack;
            }
        }
        return null;
    }
    private void returnChange(double amount) {
        System.out.println("Vending machine has returned $" + amount);
    }
    private void dispenseSnack(Snack snack) {
        snackInventory.get(snackInventory.indexOf(snack)).dispenseSnack();
        snackDispenserHandler.handleRequest(snack);
    }
    
}