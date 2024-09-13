import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 2.1
//        Gson gson = new Gson();
//        Person person = new Person("Pit", "Bread", 12);
//
//        String jsonObject = gson.toJson(person);
//        Person person2 = gson.fromJson(jsonObject, Person.class);
//
//        if (person.equals(person2)) {
//            System.out.println("equal");
//        }
//        else System.out.println("not equal");

        // 2.2
        Scanner scanner = new Scanner(System.in);
        String one_more_time = null;
        String surname = null, name = null, date = null, phone = null, address = null;

        do{
            do {
                System.out.println("Enter surname: ");
                surname = scanner.nextLine();
            }while(!LogRecord.checkSurname(surname));

            do {
                System.out.println("Enter name: ");
                name = scanner.nextLine();
            }while (!LogRecord.checkName(name));

            do {
                System.out.println("Enter date: ");
                date = scanner.nextLine();
            }while (!LogRecord.isValidDate(date));

            do {
                System.out.println("Enter phone number: ");
                phone = scanner.nextLine();
            }while (!LogRecord.checkPhone(phone));

            do {
                System.out.println("Enter address: ");
                address = scanner.nextLine();
            }while (!LogRecord.checkAddress(address));
            new LogRecord(surname, name, date, phone, address);

            System.out.println("Do you want to add another record? (Press Enter to continue, or type 'no' to stop):");
            one_more_time = scanner.nextLine();

        }while (one_more_time.isEmpty()) ;
        scanner.close();

        LogRecord.printAllLogs();

    }

}