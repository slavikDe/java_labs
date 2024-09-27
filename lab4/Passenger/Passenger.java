package Passenger;

public class Passenger {
    private String firstName;
    private String lastName;
    private int age;

    public Passenger(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        return age;
    }

     public void sayName() {
         System.out.println("Im passenger " + firstName + " " + lastName);
     }
}
