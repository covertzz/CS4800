public class SnackDispenserHandler {
    private SnackDispenserHandler next;
    public SnackDispenserHandler(SnackDispenserHandler next) {
        this.next = next;
    }
    public void handleRequest(Snack snack) {
        if(next != null) {
            next.handleRequest(snack);
        }
    }
}

class CokeHandler extends SnackDispenserHandler {
    public CokeHandler(SnackDispenserHandler next) {
        super(next);
    }
    public void handleRequest(Snack snack) {
        if(snack.getName().equals("Coke")) {
            System.out.println("Dispensing Coke");
        }
        else {
            System.out.println("I was passed from Coke");
            super.handleRequest(snack);
        }
    }
}

class PepsiHandler extends SnackDispenserHandler {
    public PepsiHandler(SnackDispenserHandler next) {
        super(next);
    }
    public void handleRequest(Snack snack) {
        if(snack.getName().equals("Pepsi")) {
            System.out.println("Dispensing Pepsi");
        }
        else {
            System.out.println("I was passed from Pepsi");
            super.handleRequest(snack);
        }
    }
}

class CheetosHandler extends SnackDispenserHandler {
    public CheetosHandler(SnackDispenserHandler next) {
        super(next);
    }
    public void handleRequest(Snack snack) {
        if(snack.getName().equals("Cheetos")) {
            System.out.println("Dispensing Cheetos");
        }
        else {
            System.out.println("I was passed from Cheetos");
            super.handleRequest(snack);
        }
    }
}

class DoritosHandler extends SnackDispenserHandler {
    public DoritosHandler(SnackDispenserHandler next) {
        super(next);
    }
    public void handleRequest(Snack snack) {
        if(snack.getName().equals("Doritos")) {
            System.out.println("Dispensing Doritos");
        }
        else {
            System.out.println("I was passed from Doritos");
            super.handleRequest(snack);
        }
    }
}

class KitKatHandler extends SnackDispenserHandler {
    public KitKatHandler(SnackDispenserHandler next) {
        super(next);
    }
    public void handleRequest(Snack snack) {
        if(snack.getName().equals("KitKat")) {
            System.out.println("Dispensing KitKat");
        }
        else {
            System.out.println("I was passed from KitKat");
            super.handleRequest(snack);
        }
    }
}

class SnickersHandler extends SnackDispenserHandler {
    public SnickersHandler(SnackDispenserHandler next) {
        super(next);
    }
    public void handleRequest(Snack snack) {
        if(snack.getName().equals("Snickers")) {
            System.out.println("Dispensing Snickers");
        }
        else {
            System.out.println("I was passed from Snickers");
            super.handleRequest(snack);
        }
    }
}