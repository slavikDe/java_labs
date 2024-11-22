import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;


public class Translator {
    private final Map<String,String> dictionary;

    public Translator() {
        dictionary = new HashMap<>(16, 1.5f);
    }

    public void addWord(String en, String uk){
        if(dictionary.containsKey(en)){
            String existingTranslation = dictionary.get(en);

            if(existingTranslation.contains(uk)){
                dictionary.replace(en, existingTranslation + ", " + uk);
            }
        }
        else {
            dictionary.put(en, uk);
        }
    }

    public void loadWordsFromJson(String filePath) {
        Gson gson = new Gson();
        System.out.println("Loading words from: " + filePath);
        try (FileReader reader = new FileReader(filePath)) {
            Type type = new TypeToken<Map<String, String>>() {}.getType();
            Map<String, String> wordsFromJson = gson.fromJson(reader, type);
            wordsFromJson.forEach(this::addWord);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String translateWord(String word){
        if(word.trim().isEmpty()) return "Input word is empty";
        word = word.toLowerCase();

        if(dictionary.containsKey(word)){
             return dictionary.get(word);
        }
        return "No word translate found for word: " + word + " ";
    }

    public boolean containsWord(String word){
        return dictionary.containsKey(word);
    }

    public String translatePhrase(String phrase) {
        if (phrase.trim().isEmpty()) return "Input phrase is empty";

        StringBuilder translatedPhrase = new StringBuilder();
        String[] words = phrase.split("\\s+"); // Split by whitespace

        for (String word : words) {
            String translation = translateWord(word); // Translate each word
            translatedPhrase.append(translation).append(" "); // Append translation with space
        }

        return translatedPhrase.toString().trim(); // Return the translated phrase without trailing space
    }

}
