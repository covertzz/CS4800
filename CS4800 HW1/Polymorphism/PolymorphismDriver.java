package Polymorphism;
public class PolymorphismDriver {
    public static void main(String[] args) {
        Ship ship1 = new Ship();
        ship1.setShipName("MayFlower");
        ship1.setYearBuilt("Unknown");

        CruiseShip ship2 = new CruiseShip();
        ship2.setShipName("Titanic");
        ship2.setYearBuilt("1909");
        ship2.setMaxNumPassengers(2435);
        
        CargoShip ship3 = new CargoShip();
        ship3.setShipName("Ever Given");
        ship3.setYearBuilt("2018");
        ship3.setTonnage(220940);



        Ship[] ships = new Ship[]{ship1, ship2, ship3};

        for(Ship ship : ships) {
            ship.print();
        }
    }
}
