public class UnitTests {
    static public void testAll() {
        testIdle();
        testWaiting();
        testAccepting();
        testDispensing();
        testSnack();
        testSnackDispense();
        
    }
    static public void testIdle() {
        VendingMachine vendingMachine = new VendingMachine();
        if(!vendingMachine.getState().toString().equals("Idle")) {
            System.out.println("ERROR: testIdle");
        }
    }
    static public void testWaiting() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.tap();
        if(!vendingMachine.getState().toString().equals("Waiting for Snack Selection")) {
            System.out.println("ERROR: testWaiting");
        }
    }
    static public void testAccepting() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setState(new AcceptingState());        
        if(!vendingMachine.getState().toString().equals("Accepting Payment")) {
            System.out.println("ERROR: testAcccepting");
        }
    }
    static public void testDispensing() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setState(new DispensingState());
        if(!vendingMachine.getState().toString().equals("Dispensing Snack")) {
            System.out.println("ERROR: testDispensing");
        }
    }
    static public void testSnack() {
        VendingMachine vendingMachine = new VendingMachine();
        Snack testSnack = new Snack("test", 0, 0);
        vendingMachine.addSnack(testSnack);
        if(!vendingMachine.getInventory().get(0).equals(testSnack)) {
            System.out.println("ERROR: testSnack");
        }
    }
    static public void testSnackDispense() {
        Snack testSnack = new Snack("test", 0, 1);
        testSnack.dispenseSnack();
        if(testSnack.getQuantity() != 0) {
            System.out.println("ERROR: testSnackDispense");
        }
    }     
}
