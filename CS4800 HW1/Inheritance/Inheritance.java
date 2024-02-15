package Inheritance;
class Employee {
    String firstName;
    String lastName;
    String SSN;
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getSSN() {
        return SSN;
    }
    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
    public void print(){

    }
    
}

class SalariedEmployee extends Employee {
    int weeklySalary;

    public int getWeeklySalary() {
        return weeklySalary;
    }
    public void setWeeklySalary(int weeklySalary) {
        this.weeklySalary = weeklySalary;
    }
    @Override
    public void print() {
        System.out.printf("Employee %s %s makes $%d in weekly salary\n", firstName, lastName, weeklySalary);
    }
}

class HourlyEmployee extends Employee {
    int wageHourly;
    int hoursWorked;

    public int getHourlyWage() {
        return wageHourly;
    }
    public void setWageHourly(int wageHourly) {
        this.wageHourly = wageHourly;
    }
    public int getHoursWorked() {
        return hoursWorked;
    }
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    @Override
    public void print() {
        System.out.printf("Employee %s %s makes $%d in hourly salary and has worked %d hours\n", firstName, lastName, wageHourly, hoursWorked);
    }
}

class CommisionEmployee extends Employee {
    double commisionRate;
    int grossSales;

    public double getCommisionRate() {
        return commisionRate;
    }
    public void setCommisionRate(double commisionRate) {
        this.commisionRate = commisionRate;
    }
    public int getGrossSales() {
        return grossSales;
    }
    public void setGrossSales(int grossSales) {
        this.grossSales = grossSales;
    }
    @Override
    public void print() {
        System.out.printf("Employee %s %s makes %.2f%% in commisions and has sold a gross amount of $%d\n", firstName, lastName, commisionRate, grossSales);
    }
}

class BaseEmployee extends Employee {
    int baseSalary;

    public int getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }
    @Override
    public void print() {
        System.out.printf("Employee %s %s makes $%d in base salary\n", firstName, lastName, baseSalary);
    }
}