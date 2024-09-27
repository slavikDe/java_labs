package Passenger;

public final class Policeman extends Passenger {
    public Policeman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public void sayName() {
        System.out.println("Im Policeman " + getFullName() + ", age is " + getAge());
    }
}
