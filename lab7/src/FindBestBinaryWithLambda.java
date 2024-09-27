import java.util.Scanner;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Function;

public class FindBestBinaryWithLambda {

    public static void main(String[] args) {
        int input =readIntFromTerminal();
        ArrayList<Integer> list_binary = getArrayOfBest(input);

        for(int num : list_binary){
            System.out.println("The best binary representation is: " + convertBinary.apply(num) + " for number " + num);
        }
    }

    public static Function<String, Integer> countZero = binary -> {
        int count = 0;
        for (char c : binary.toCharArray()) {
            if (c == '0') {
                count++;
            }
        }
        return count;
    };

    public static Predicate<Integer> isPrime = number -> {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    };

    public static Function<Integer, String> convertBinary = number -> String.format("%16s", Integer.toBinaryString(number)).replace(' ', '0');

    public static ArrayList<Integer> getArrayOfBest(int input){
        int max_zero = 0, count_zero = 0;
        ArrayList<Integer> list_binary = new ArrayList<>();

        for(int i = 1; i <= input; i++){
            if(i % 100000 == 0){
                System.out.println(i);
            }
            if(isPrime.test(i)){
                count_zero = countZero.apply(convertBinary.apply(i));
                if(max_zero == count_zero){
                    list_binary.add(i);
                }
                else if(max_zero < count_zero){
                    max_zero = count_zero;
                    list_binary.clear();
                    list_binary.add(i);
                }
            }
        }
        return list_binary;
    }

    public static int readIntFromTerminal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");

        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid integer! Please enter an integer:");
            scanner.next();
        }

        int number = scanner.nextInt();
        scanner.close();
        return number;
    }

}