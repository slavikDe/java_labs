import java.util.ArrayList;
import java.time.LocalDate;

public class LogRecord {
    private String student_surname;
    private String student_name;
    private String date_of_birth;
    private String phone_number;
    private String address;

    private static ArrayList<String> logs = new ArrayList<>();

    LogRecord(String student_surname, String student_name, String date_of_birth, String phone_number, String address){
        this.student_surname = student_surname;
        this.student_name = student_name;
        this.date_of_birth = date_of_birth;
        this.phone_number = phone_number;
        this.address = address;
        writeDataToLog();
    }

    private void writeDataToLog(){
        logs.add("Surname: " + student_surname + ", name: " + student_name + ", birthday: " + date_of_birth + ", phone: " + phone_number + ", address: " + address);
    }

    public static boolean checkSurname(String student_surname){
        if (student_surname == null || !student_surname.matches("^[a-z]+$")) {
            System.out.println("The surname must start with a capital letter, contain no special characters, and consist only of letters.");
            return false;
        }
        return true;
    }

    public static boolean checkName(String student_name){
        if (student_name == null || !student_name.matches("^[a-z]+$")) {
            System.out.println("The first name must start with a capital letter, contain no special characters, and consist only of letters.");
            return false;
        }
        return true;
    }

    public static boolean checkPhone(String phone_number){
        if (phone_number == null || !phone_number.matches("^\\d{10}$")) {
            System.out.println("The phone number must contain exactly 10 digits.");
            return false;
        }
        return true;
    }

    public static boolean checkAddress(String address){
        if (address == null || address.trim().isEmpty()) {
            System.out.println("The address must not be empty.");
            return false;
        }
        return true;
    }

    private static boolean isFutureDate(int day, int month, int year) {
        LocalDate currentDate = LocalDate.now();
        LocalDate inputDate = LocalDate.of(year, month, day);

        return inputDate.isAfter(currentDate);
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) return false;
        if (year % 100 != 0) return true;
        return year % 400 == 0;
    }

    public static boolean isValidDate(String input_date) {
        int day, month, year;

        String[] parts = input_date.split("\\.");
        if (parts.length != 3) {
            System.out.println("Enter the date in this format (dd.mm.yyyy): ");
            return false;
        }
        try {
            day = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            System.out.println("Enter the date in this format (dd.mm.yyyy): ");
            return false;
        }

        if (month < 1 || month > 12 || year < 1600) {
            System.out.println("Enter valid date: ");
            return false;
        }

        if (day < 1) {
            System.out.println("Day must be greater than or equal to 0: ");
            return false;
        }

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        return day <= daysInMonth[month - 1] && !isFutureDate(day, month, year);
    }

    public static void printAllLogs(){
        for (String log : logs){
            System.out.println(log);
        }
    }
}
