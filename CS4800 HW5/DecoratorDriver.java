public class DecoratorDriver {

    public static void main(String[] args) {
        //unit tests
        DecoratorTester.testAll();

        CustomerOrder customerOrder1 = new CustomerOrder();
        CustomerOrder customerOrder2 = new CustomerOrder();
        CustomerOrder customerOrder3 = new CustomerOrder();

        customerOrder1.add(new Burger());
        customerOrder1.add(new Fries());
        customerOrder1.add(new HotDog());
        customerOrder1.setLoyaltyStatus("Super Fan");
        System.out.println("Loyalty Status: Super Fan");
        System.out.println("Items ordered: ");
        customerOrder1.getItemsInCart();
        System.out.println("Total price of order 1 = " + customerOrder1.getTotalPrice() + "\n");

        MenuItem burger = new Burger();
        burger = new MenuItemWithBacon(burger);
        burger = new MenuItemWithCheese(burger);
        burger = new MenuItemWithKetchup(burger);
        customerOrder2.add(burger);
        customerOrder2.setLoyaltyStatus("Fan");
        System.out.println("Loyalty Status: Fan");
        System.out.println("Items ordered: ");
        customerOrder2.getItemsInCart();
        System.out.println("Total price of order 2 = " + customerOrder2.getTotalPrice() + "\n");

        customerOrder3.add(new MenuItemWithKetchup(new Burger()));
        customerOrder3.add(new MenuItemWithBacon(new Fries()));
        customerOrder3.add(new MenuItemWithCheese(new HotDog()));
        System.out.println("Items ordered: ");
        customerOrder3.getItemsInCart();
        System.out.println("Total price of order 3 = " + customerOrder3.getTotalPrice() + "\n");

        
        
    }
}
