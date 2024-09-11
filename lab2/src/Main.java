import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Person person = new Person("Pit", "Bread", 12);

        String jsonObject = gson.toJson(person);

        Person person2 = gson.fromJson(jsonObject, Person.class);

        if (person.equals(person2)) {
            System.out.println("equal");
        }
        else System.out.println("not equal");
    }
}