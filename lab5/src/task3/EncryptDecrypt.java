package task3;

import java.io.*;

public class EncryptDecrypt {
    public static void main(String[] args) {
        String input = "Hello, World!";
        char key = 'K';

        try {
            encryptToFile(input, "lab5/src/task3/encrypted.txt", key);
            String decrypted = decryptFromFile("lab5/src/task3/encrypted.txt", key);
            System.out.println("Розшифрований текст: " + decrypted);
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static void encryptToFile(String data, String filePath, char key) throws IOException {
        try (Writer writer = new FilterWriter(new FileWriter(filePath)) {
            @Override
            public void write(int c) throws IOException {
                super.write(c + key);
            }
        }) {
            for (char c : data.toCharArray()) {
                writer.write(c);
            }
            System.out.println("Дані зашифровані та збережені у файл.");
        }
    }

    public static String decryptFromFile(String filePath, char key) throws IOException {
        StringBuilder result = new StringBuilder();
        try (Reader reader = new FilterReader(new FileReader(filePath)) {
            @Override
            public int read() throws IOException {
                int c = super.read();
                return c == -1 ? -1 : c - key;
            }
        }) {
            int c;
            while ((c = reader.read()) != -1) {
                result.append((char) c);
            }
        }
        return result.toString();
    }
}
