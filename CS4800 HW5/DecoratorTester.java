public class DecoratorTester {
    public static void testAll() {
        testLoyaltyStatusFan();
        testLoyaltyStatusRegular();
        testLoyaltyStatusSuperFan();
        testPriceOfBurger();
        testPriceOfBurgerWithCheeseAndKetchup();
        testPriceOfFries();
        testPriceOfFriesWithBaconAndKetchup();
        testPriceOfHotDog();
        testPriceOfHotDogWithBaconAndCheese();
        testStringOfBurger();
        testStringOfFries();
        testStringOfHotDog();
        testTotalPriceOneBurger();
        testTotalPriceTwoBurgerOneLoadedFries();
    }

    public static void testPriceOfBurger() {
        MenuItem burger = new Burger();
        double actualPrice = burger.getPrice();
        double targetPrice = 7.50;
        if (actualPrice != targetPrice) {
            System.out.println("ERROR: testPriceOfBurger! Burger price is: " + actualPrice + " instead of " + targetPrice);
        }
    }
    public static void testPriceOfFries() {
        MenuItem fries = new Fries();
        double actualPrice = fries.getPrice();
        double targetPrice = 2.50;
        if (actualPrice != targetPrice) {
            System.out.println("ERROR: testPriceOfFries! Fries price is: " + actualPrice + " instead of " + targetPrice);
        }
    }
    public static void testPriceOfHotDog() {
        MenuItem hotDog = new HotDog();
        double actualPrice = hotDog.getPrice();
        double targetPrice = 5.00;
        if (actualPrice != targetPrice) {
            System.out.println("ERROR: testPriceOfHotDog! Hot Dog price is: " + actualPrice + " instead of " + targetPrice);
        }
    }
    
    public static void testPriceOfBurgerWithCheeseAndKetchup() {
        MenuItem burger = new Burger();
        burger = new MenuItemWithKetchup(burger);
        burger = new MenuItemWithCheese(burger);
        double actualPrice = burger.getPrice();
        double targetPrice = 8.75;
        if (actualPrice != targetPrice) {
            System.out.println("ERROR: testPriceOfBurgerWithCheeseAndKetchup! Burger price is: " + actualPrice + " instead of " + targetPrice);
        }
    }
    public static void testPriceOfFriesWithBaconAndKetchup() {
        MenuItem fries = new Fries();
        fries = new MenuItemWithBacon(fries);
        fries = new MenuItemWithKetchup(fries);
        double actualPrice = fries.getPrice();
        double targetPrice = 4.75;
        if (actualPrice != targetPrice) {
            System.out.println("ERROR: testPriceOfFriesWithBaconAndKetchup! Fries price is: " + actualPrice + " instead of " + targetPrice);
        }
    }
    public static void testPriceOfHotDogWithBaconAndCheese() {
        MenuItem hotDog = new HotDog();
        hotDog = new MenuItemWithCheese(hotDog);
        hotDog = new MenuItemWithBacon(hotDog);
        double actualPrice = hotDog.getPrice();
        double targetPrice = 8.00;
        if (actualPrice != targetPrice) {
            System.out.println("ERROR: testPriceOfHotDogWithBaconAndCheese! Hot Dog price is: " + actualPrice + " instead of " + targetPrice);
        }
    }

    public static void testStringOfBurger() {
        MenuItem burger = new Burger();
        String actualString= burger.toString();
        String targetString = "burger";
        if (actualString != targetString) {
            System.out.println("ERROR: testStringOfBurger! Burger string is: " + actualString + " instead of " + targetString);
        }
    }
    public static void testStringOfFries() {
        MenuItem fries = new Fries();
        String actualString= fries.toString();
        String targetString = "fries";
        if (actualString != targetString) {
            System.out.println("ERROR: testStringOfFries! Fries string is: " + actualString + " instead of " + targetString);
        }
    }
    public static void testStringOfHotDog() {
        MenuItem hotDog = new HotDog();
        String actualString= hotDog.toString();
        String targetString = "hot dog";
        if (actualString != targetString) {
            System.out.println("ERROR: testStringOfHotDog! Hot Dog string is: " + actualString + " instead of " + targetString);
        }
    }
    
    public static void testTotalPriceOneBurger() {
        CustomerOrder co = new CustomerOrder();
        co.add(new Burger());
        double actualPrice = co.getTotalPrice();
        double targetPrice = 7.50;
        if(actualPrice != targetPrice) {
            System.out.println("ERROR: testTotalPriceOneBurger! Total price is: " + actualPrice + " instead of " + targetPrice);
        }
    }
    
    public static void testTotalPriceTwoBurgerOneLoadedFries() {
        CustomerOrder co = new CustomerOrder();
        co.add(new Burger());
        co.add(new MenuItemWithCheese(new MenuItemWithBacon(new Fries())));
        co.add(new Burger());
        double actualPrice = co.getTotalPrice();
        double targetPrice = 20.5;
        if(actualPrice != targetPrice) {
            System.out.println("ERROR: testTotalPriceTwoBurgerOneLoadedFries! Total price is: " + actualPrice + " instead of " + targetPrice);
        }
    }
    
    public static void testLoyaltyStatusSuperFan() {
        CustomerOrder co = new CustomerOrder();
        co.add(new HotDog());
        co.setLoyaltyStatus("Super Fan");
        double actualPrice = co.getTotalPrice();
        double targetPrice = 3.75;
        if(actualPrice != targetPrice) {
            System.out.println("ERROR: testLoyaltyStatusSuperFan! Total price is: " + actualPrice + " instead of " + targetPrice);
        }
    }

    public static void testLoyaltyStatusFan() {
        CustomerOrder co = new CustomerOrder();
        co.add(new HotDog());
        co.setLoyaltyStatus("Fan");
        double actualPrice = co.getTotalPrice();
        double targetPrice = 4.50;
        if(actualPrice != targetPrice) {
            System.out.println("ERROR: testLoyaltyStatusFan! Total price is: " + actualPrice + " instead of " + targetPrice);
        }
    }

    public static void testLoyaltyStatusRegular() {
        CustomerOrder co = new CustomerOrder();
        co.add(new HotDog());
        co.setLoyaltyStatus("Regular");
        double actualPrice = co.getTotalPrice();
        double targetPrice = 4.75;
        if(actualPrice != targetPrice) {
            System.out.println("ERROR: testLoyaltyStatusRegular! Total price is: " + actualPrice + " instead of " + targetPrice);
        }
    }
    
}
