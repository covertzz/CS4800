import java.util.ArrayList;

class PizzaBuilder {
    private String size;
    private ArrayList<String> toppings = new ArrayList<>();
    private String pizzaChain;
   

    public PizzaBuilder(String pizzaChain) {
        this.pizzaChain = pizzaChain;
    }
    public PizzaBuilder newPizza() {
        size = "";
        toppings.clear();
        return this;
    }
    public PizzaBuilder setSize(String size) {
        if (size.equals(null)) {
            System.out.print("ERROR: must select pizza size");
            return this;
        }
        else if(size.equals("Small") || size.equals("small") || size.equals("S") || size.equals("s")) {
            this.size = "Small";
        }
        else if(size.equals("Medium") || size.equals("medium") || size.equals("M") || size.equals("m")) {
            this.size = "Medium";
        }
        else if(size.equals("Large") || size.equals("large") || size.equals("L") || size.equals("l")) {
            this.size = "Large";
        }
        else {
            System.out.print("ERROR: invalid pizza size");
        }
        return this;
    }
    public PizzaBuilder addPepperoni() {
        toppings.add("Pepperoni");
        return this;
    }
    public PizzaBuilder addSausage() {
        toppings.add("Sausage");
        return this;
    }
    public PizzaBuilder addMushrooms() {
        toppings.add("Mushrooms");
        return this;
    }
    public PizzaBuilder addBacon() {
        toppings.add("Bacon");
        return this;
    }
    public PizzaBuilder addOnions() {
        toppings.add("Onions");
        return this;
    }
    public PizzaBuilder addExtraCheese() {
        toppings.add("Extra Cheese");
        return this;
    }
    public PizzaBuilder addPeppers() {
        toppings.add("Peppers");
        return this;
    }
    public PizzaBuilder addChicken() {
        toppings.add("Chicken");
        return this;
    }
    public PizzaBuilder addOlives() {
        toppings.add("Olives");
        return this;
    }
    public PizzaBuilder addSpinach() {
        toppings.add("Spinach");
        return this;
    }
    public PizzaBuilder addTomatoAndBasil() {
        toppings.add("Tomato and Basil");
        return this;
    }
    public PizzaBuilder addBeef() {
        toppings.add("Beef");
        return this;
    }
    public PizzaBuilder addHam() {
        toppings.add("Ham");
        return this;
    }
    public PizzaBuilder addPesto() {
        toppings.add("Pesto");
        return this;
    }
    public PizzaBuilder addSpicyPork() {
        toppings.add("Spicy Pork");
        return this;
    }
    public PizzaBuilder addHamAndPineapple() {
        toppings.add("Ham and Pineapple");
        return this;
    }
    public void eat() {
        System.out.print(pizzaChain + ": ");
        System.out.print(size + " pizza with ");
        for(int i = 0; i < toppings.size()-1; i++) {
            System.out.print(toppings.get(i) + ", ");
        }
        System.out.print("and "+ toppings.get(toppings.size()-1));
        System.out.println('\n');
     }
}