package Passenger;

public final class Firefighter extends Passenger {
    public Firefighter(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public void sayName() {
        System.out.println("Im Firefighter " + getFullName() + ", age is " + getAge());
    }
}
