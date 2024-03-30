import java.util.ArrayList;

class CustomerOrder {
    private ArrayList<MenuItem> cart = new ArrayList<>();
    private LoyaltyStatus loyaltyStatus = new LoyaltyStatus();

    public void add(MenuItem menuItem) {
        cart.add(menuItem);
    }

    public double getTotalPrice() {
        double totalPrice = 0.00;
        for (MenuItem menuItem : cart) {
            totalPrice += menuItem.getPrice();
        }
        totalPrice = totalPrice * (1-loyaltyStatus.getDiscount());

        return totalPrice; 
    }

    public void setLoyaltyStatus(String loyaltyStatus) {
        this.loyaltyStatus.setLoyaltyStatus(loyaltyStatus);
    }

    public void getItemsInCart() {
        for (MenuItem menuItem : cart) {
            System.out.println("\t"+ menuItem.toString());
        }
    }    
}

class LoyaltyStatus {
    String status = "New Customer";
    double discount = 0.00;

    public void setLoyaltyStatus(String loyalty) {
        switch (loyalty)  {
            case "Super Fan":
                status = "Super Fan";
                discount = 0.25;
                break;
            case "Fan":
                status = "Fan";
                discount = 0.1;
                break;
            case "Regular":
                status = "Regular";
                discount = 0.05;
                break;
        }
    }

    public double getDiscount() {
        return discount;
    }
}

interface MenuItem {
    public double getPrice();
    public String toString();
}

class Burger implements MenuItem {
    private double price;

    public Burger() {
        price = 7.50;
    }
    public double getPrice() {
        return price;
    }
    public String toString() {
        return "burger";
    }
}

class Fries implements MenuItem {
    private double price;

    public Fries() {
        price = 2.50;
    }
    public double getPrice() {
        return price;
    }
    public String toString() {
        return "fries";
    }
}

class HotDog implements MenuItem {
    private double price;

    public HotDog() {
        price = 5.00;
    }
    public double getPrice() {
        return price;
    }
    public String toString() {
        return "hot dog";
    }
}

class MenuItemWithKetchup implements MenuItem {
    private double price = 0.25;
    private MenuItem menuItem;
    public MenuItemWithKetchup(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
    public double getPrice() {
        return (menuItem.getPrice() + price);
    }
    public String toString() {
        return (menuItem.toString() + " with ketchup");
    }
}
class MenuItemWithCheese implements MenuItem {
    private double price = 1.00;
    private MenuItem menuItem;
    public MenuItemWithCheese(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
    public double getPrice() {
        return (menuItem.getPrice() + price);
    }
    public String toString() {
        return (menuItem.toString() + " with cheese");
    }
}
class MenuItemWithBacon implements MenuItem {
    private double price = 2.00;
    private MenuItem menuItem;
    public MenuItemWithBacon(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
    public double getPrice() {
        return (menuItem.getPrice() + price);
    }
    public String toString() {
        return (menuItem.toString() + " with bacon");
    }
}
