
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
        return surname.equals(p.surname) &&  name.equals(p.name) && age == p.age;
    }
}
