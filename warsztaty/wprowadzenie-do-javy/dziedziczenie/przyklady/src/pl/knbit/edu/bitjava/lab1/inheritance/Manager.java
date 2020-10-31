package pl.knbit.edu.bitjava.lab1.inheritance;

public class Manager extends Employee {

    private int bonus = 0;

    public Manager(String name, String surname, int salary) {
        super(name, surname, salary);
    }

    @Override
    public int getSalary() {
        return super.getSalary() + this.bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

}
