package pl.knbit.edu.bitjava.lab1.classes;

public class Main {

    public static void main(String[] args) {
        // inicjalizacja obiektu:
        Person person = new Person("Alice", "Johnson");
        Person defaultPerson = new Person();

        System.out.println("Name: " + person.getFullName());
        System.out.println("Name: " + defaultPerson.getFullName());

        // zmiana stanu obiektu poprzez ustawienie nowej wartości pola 'name' za pomocą settera:
        person.setName("Ann");
        System.out.println("Name: " + person.getFullName());

    }

}
