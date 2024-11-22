import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator();
        translator.loadWordsFromJson("src/words.json");
        Scanner scanner = new Scanner(System.in);
        String translatedWord = null;

        do {
            String word = Main.requestWord(scanner);
            if (translator.containsWord(word.toLowerCase())) {
                translatedWord = translator.translateWord(word.toLowerCase());
            }
            else {
                System.out.println("This word not found. Want add to dictionary? y/n");
                String addWordResponse = scanner.next();
                scanner.nextLine();
                if(addWordResponse.equalsIgnoreCase("y")) {
                    System.out.println("Enter translated word for " + word + " : ");
                    translatedWord = scanner.next();
                    translator.addWord(word, translatedWord);
                }
            }


            System.out.println(translatedWord != null ? translatedWord : "Word not found.");
        } while (Main.oneMore(scanner));

        scanner.close();

        System.out.println(translator.translatePhrase("hello it is my apple"));

    }

    public static String requestWord(Scanner scanner) {
        System.out.println("Enter word for translate:");
        return scanner.nextLine();
    }
    public static boolean oneMore(Scanner scanner) {
        System.out.println("Type 'q' if u want exit!");
        String word = scanner.nextLine();
        return !word.equalsIgnoreCase("q") ;
    }
}