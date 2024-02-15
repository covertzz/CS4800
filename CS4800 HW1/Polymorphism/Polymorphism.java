package Polymorphism;
class Ship {
    String shipName;
    String yearBuilt;

    public String getShipName() {
        return shipName;
    }
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    public String getYearBuilt() {
        return yearBuilt;
    }
    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public void print() {
        System.out.printf("The name of the ship is: %s and it was built in %s\n", shipName, yearBuilt);
    }
}

class CruiseShip extends Ship {
    int maxNumPassengers;
    
    public int getMaxNumPassengers() {
        return maxNumPassengers;
    }
    public void setMaxNumPassengers(int maxNumPassengers) {
        this.maxNumPassengers = maxNumPassengers;
    }
    @Override
    public void print() {
        System.out.printf("The name of the ship is: %s and it's maximum capacity is %d passengers\n", shipName, maxNumPassengers);
    }
}

class CargoShip extends Ship {
    int tonnage;

    public int getTonnage() {
        return tonnage;
    }
    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    public void print() {
        System.out.printf("The name of the ship is: %s and it has a maximum capacity is %s tonnes\n", shipName, tonnage);
    }
}