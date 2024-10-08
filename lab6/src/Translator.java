import java.util.HashMap;
import java.util.Map;


public class Translator {
    private Map<String,String> dictionary;

    public Translator() {
        dictionary = new HashMap<>();
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

    public String translatePhrase(String phrase){
        if(phrase.trim().isEmpty()) return "Input phrase is empty";
        String[] words = phrase.split(" ");
        StringBuilder translatedPhrase = new StringBuilder();

        for(String word : words){
            word = word.toLowerCase();
            if(dictionary.containsKey(word)){
                translatedPhrase.append(dictionary.get(word)).append(" ");
            }
            else {
                translatedPhrase.append(word).append(" ");
            }
        }

        return translatedPhrase.toString();
    }
}
