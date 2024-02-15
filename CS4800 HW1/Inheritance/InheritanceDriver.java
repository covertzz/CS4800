package Inheritance;
import java.util.ArrayList;

public class InheritanceDriver {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        
        SalariedEmployee Joe = new SalariedEmployee();
        Joe.setFirstName("Joe");
        Joe.setLastName("Jones");
        Joe.setSSN("111-11-1111");
        Joe.setWeeklySalary(2500);
        employees.add(Joe);


        HourlyEmployee Steph = new HourlyEmployee();
        Steph.setFirstName("Stephanie");
        Steph.setLastName("Smith");
        Steph.setSSN("222-22-2222");
        Steph.setWageHourly(25);
        Steph.setHoursWorked(32);
        employees.add(Steph);


        HourlyEmployee Mary = new HourlyEmployee();
        Mary.setFirstName("Mary");
        Mary.setLastName("Quinn");
        Mary.setSSN("333-33-3333");
        Mary.setWageHourly(19);
        Mary.setHoursWorked(47);
        employees.add(Mary);

        CommisionEmployee Nicole = new CommisionEmployee();
        Nicole.setFirstName("Nicole");
        Nicole.setLastName("Dior");
        Nicole.setSSN("444-44-4444");
        Nicole.setCommisionRate(15);
        Nicole.setGrossSales(50000);
        employees.add(Nicole);

        SalariedEmployee Renwa = new SalariedEmployee();
        Renwa.setFirstName("Renwa");
        Renwa.setLastName("Chanel");
        Renwa.setSSN("555-55-5555");
        Renwa.setWeeklySalary(1700);
        employees.add(Renwa);

        BaseEmployee Mike = new BaseEmployee();
        Mike.setFirstName("Mike");
        Mike.setLastName("Davenport");
        Mike.setSSN("666-66-6666");
        Mike.setBaseSalary(95000);
        employees.add(Mike);

        CommisionEmployee Mahnaz = new CommisionEmployee();
        Mahnaz.setFirstName("Mahnaz");
        Mahnaz.setLastName("Vaziri");
        Mahnaz.setSSN("777-77-7777");
        Mahnaz.setCommisionRate(22);
        Mahnaz.setGrossSales(40000);
        employees.add(Mahnaz);        

        for(Employee e : employees) {
            e.print();
        }

    }
}
