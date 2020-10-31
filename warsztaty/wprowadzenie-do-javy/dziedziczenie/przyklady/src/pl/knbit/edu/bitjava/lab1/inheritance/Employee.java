package pl.knbit.edu.bitjava.lab1.inheritance;

public class Employee extends Person {

    private int salary;

    public Employee(String name, String surname, int salary) {
        super(name, surname);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

}
