public class PizzaDriver {
    public static void main(String[] args) {
        Driver1 d1 = new Driver1();
        Driver2 d2 = new Driver2();

        d1.driver();
        d2.driver();
    }
    
}

class Driver1 {
    public void driver() {
        PizzaBuilder pizzaPlace = new PizzaBuilder("Pizza Place");
        pizzaPlace.newPizza().setSize("s").addBacon().addPepperoni().addOnions().eat();
        pizzaPlace.newPizza().setSize("m").addExtraCheese().addOlives().addPesto().eat();
        pizzaPlace.newPizza().setSize("l").addPepperoni().addHamAndPineapple().addSpicyPork().eat();
        pizzaPlace.newPizza().setSize("s").addSpicyPork().addPepperoni().addHamAndPineapple().addBeef().addBacon().addChicken().eat();
        pizzaPlace.newPizza().setSize("m").addMushrooms().addSpinach().addOnions().addOlives().addPesto().addTomatoAndBasil().eat();
        pizzaPlace.newPizza().setSize("l").addOlives().addMushrooms().addOnions().addSausage().addTomatoAndBasil().addSpinach().eat();
        pizzaPlace.newPizza().setSize("s").addSpicyPork().addPepperoni().addHamAndPineapple().addBeef().addBacon().addChicken().addOlives().addMushrooms().addPeppers().eat();
        pizzaPlace.newPizza().setSize("m").addMushrooms().addSpinach().addOnions().addOlives().addPesto().addTomatoAndBasil().addHamAndPineapple().addPeppers().addExtraCheese().eat();
        pizzaPlace.newPizza().setSize("l").addOlives().addMushrooms().addOnions().addSausage().addTomatoAndBasil().addSpinach().addExtraCheese().addBeef().addBacon().eat();
    }
}

class Driver2 {
    public void driver() {
        PizzaBuilder pizzaHut = new PizzaBuilder("Pizza Hut");
        PizzaBuilder littleCaesars = new PizzaBuilder("Little Caesars");
        PizzaBuilder dominos = new PizzaBuilder("Dominos");

        pizzaHut.newPizza().setSize("l").addBacon().addPepperoni().addOnions().eat();
        pizzaHut.newPizza().setSize("s").addExtraCheese().addOlives().eat();
        littleCaesars.newPizza().setSize("l").addOlives().addMushrooms().addOnions().addSausage().addTomatoAndBasil().addSpinach().eat();
        littleCaesars.newPizza().setSize("m").addMushrooms().addSpinach().addOnions().addOlives().addTomatoAndBasil().addHamAndPineapple().addPeppers().addExtraCheese().eat();
        dominos.newPizza().setSize("l").addPepperoni().addHamAndPineapple().addSpicyPork().eat();
        dominos.newPizza().setSize("s").addPepperoni().eat();
    }
}