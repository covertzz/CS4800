public interface StateOfVendingMachine {
    void idle(VendingMachine vendingMachine);
    void waitingForSnackSelection(VendingMachine vendingMachine);
    void acceptingPayment(VendingMachine vendingMachine);
    void dispensingSnacks(VendingMachine vendingMachine);
}

class IdleState implements StateOfVendingMachine {
    public void idle(VendingMachine vendingMachine) {}
    public void waitingForSnackSelection(VendingMachine vendingMachine){
        vendingMachine.setState(new WaitingState());
        System.out.println("Vending Machine is waiting for a snack to be chosen");
    }
    public void acceptingPayment(VendingMachine vendingMachine){}
    public void dispensingSnacks(VendingMachine vendingMachine){}
    public String toString() {
        return "Idle";
    }
}

class WaitingState implements StateOfVendingMachine {
    public void idle(VendingMachine vendingMachine) {
        vendingMachine.setState(new IdleState());
        System.out.println("Vending Machine is idle");
    }
    public void waitingForSnackSelection(VendingMachine vendingMachine){}
    public void acceptingPayment(VendingMachine vendingMachine){
        vendingMachine.setState(new AcceptingState());
        System.out.println("Vending Machine is waiting for payment");
    }
    public void dispensingSnacks(VendingMachine vendingMachine){}
    public String toString() {
        return "Waiting for Snack Selection";
    }
}

class AcceptingState implements StateOfVendingMachine {
    public void idle(VendingMachine vendingMachine) {
        vendingMachine.setState(new IdleState());
        System.out.println("Vending Machine is idle");
    }
    public void waitingForSnackSelection(VendingMachine vendingMachine){}
    public void acceptingPayment(VendingMachine vendingMachine){}
    public void dispensingSnacks(VendingMachine vendingMachine){
        vendingMachine.setState(new DispensingState());
        System.out.println("Vending Machine is dispensing snack");
    }
    public String toString() {
        return "Accepting Payment";
    }
}

class DispensingState implements StateOfVendingMachine {
    public void idle(VendingMachine vendingMachine) {
        vendingMachine.setState(new IdleState());
        System.out.println("Vending Machine is idle");
    }
    public void waitingForSnackSelection(VendingMachine vendingMachine){}
    public void acceptingPayment(VendingMachine vendingMachine){}
    public void dispensingSnacks(VendingMachine vendingMachine){}
    public String toString() {
        return "Dispensing Snack";
    }
}
