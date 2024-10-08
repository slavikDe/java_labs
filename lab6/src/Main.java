import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Translator translator = new Translator();

        translator.addWord("apple", "яблуко");
        translator.addWord("hello", "привіт");
        translator.addWord("world", "світ");
        translator.addWord("world", "askdaskf");


        System.out.println("Ви можете додати нові слова до словника.");
        System.out.println("Для завершення додавання введіть 'q'.");
        while (true) {
            System.out.print("Введіть англійське слово: ");
            String englishWord = scanner.nextLine();
            if (englishWord.equalsIgnoreCase("q")) {
                break;
            }
            System.out.print("Введіть український переклад: ");
            String ukrainianWord = scanner.nextLine();
            translator.addWord(englishWord, ukrainianWord);
        }

        System.out.println("Введіть фразу англійською для перекладу:");
        String phrase = scanner.nextLine();

        String translatedPhrase = translator.translatePhrase(phrase);
        System.out.println("Переклад: " + translatedPhrase);

        scanner.close();

    }
}