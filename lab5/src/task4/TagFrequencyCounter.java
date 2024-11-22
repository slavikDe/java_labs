package task4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.*;

public class TagFrequencyCounter {
    public static void main(String[] args) {
//        String url = "https://example.com";
        String url = "https://www.w3schools.com/";
        try {
            Map<String, Integer> tagFrequency = countTags(url);
            System.out.println("Теги в лексикографічному порядку:");
            tagFrequency.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

            System.out.println("\nТеги за частотою появи:");
            tagFrequency.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        } catch (IOException e) {
            System.out.println("Помилка завантаження сторінки: " + e.getMessage());
        }
    }

    public static Map<String, Integer> countTags(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        Map<String, Integer> tagCount = new HashMap<>();
        for (Element element : document.getAllElements()) {
            String tag = element.tagName();
            tagCount.put(tag, tagCount.getOrDefault(tag, 0) + 1);
        }
        return tagCount;
    }
}
