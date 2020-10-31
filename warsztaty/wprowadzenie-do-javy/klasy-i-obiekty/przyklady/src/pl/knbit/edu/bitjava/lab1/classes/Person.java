package pl.knbit.edu.bitjava.lab1.classes;

// import statyczny:
import static pl.knbit.edu.bitjava.lab1.classes.Gender.MALE;

public class Person {

    // pole statyczne:
    public static final String GLOBAL_ID = "globalId";

    // pola:
    private String name = "John";
    private String surname = "Smiths";
    private Gender gender = MALE;

    // konstruktory:

    // konstruktor bezargumentowy:
    public Person() {

    }

    // konstruktor z parametrami:
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // przeciążanie konstruktora:
    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    // metody klasy:

    // gettery:
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    // settery:
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
