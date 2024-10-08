import java.io.*;
import java.util.*;

public class FileReader {
    public static void main(String[] args) {
        String filePath = "input.txt";
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String maxLine = "";
            int maxWords = 0;

            String line;
            while ((line = br.readLine()) != null) {
                int wordCount = line.split("\\s+").length;
                if (wordCount > maxWords) {
                    maxWords = wordCount;
                    maxLine = line;
                }
            }

            System.out.println("Рядок з найбільшою кількістю слів: " + maxLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

