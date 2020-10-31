package pl.knbit.edu.bitjava.lab1.inheritance;

public class Main {

    public static void main(String[] args) {
        Person person = new Employee("John", "Smiths", 4000);
        Employee employee = (Employee) person;
        System.out.println(employee.getSalary());
    }

}
