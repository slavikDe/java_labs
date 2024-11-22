package task1;

import java.io.*;
import java.util.StringTokenizer;


public class MaxWordsFinder {
    public static void main(String[] args) {
        System.out.println("Введіть шлях до файлу:");
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            String filePath = consoleReader.readLine();
            findLineWithMaxWords(filePath);
        } catch (IOException e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
        }
    }

    public static void findLineWithMaxWords(String filePath) {
        String maxLine = "";
        int maxWords = 0;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                int wordCount = new StringTokenizer(line).countTokens();
                if (wordCount > maxWords) {
                    maxWords = wordCount;
                    maxLine = line;
                }
            }
            System.out.println("Рядок з максимальною кількістю слів: " + maxLine);
            System.out.println("Кількість слів: " + maxWords);
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
