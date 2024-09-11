import java.util.Objects;

public class Person {
    String surname;
    String name;
    int age;

    Person(String surname, String name, int age) {
        this.surname = surname;
        this.name = name;
        this.age = age;
}

    public boolean equals(Person p) {
        return Objects.equals(this.surname, p.surname) && Objects.equals(this.name, p.name) && this.age == p.age;
    }
}
