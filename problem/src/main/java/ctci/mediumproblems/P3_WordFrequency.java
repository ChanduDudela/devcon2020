package ctci.mediumproblems;

import java.util.HashMap;
import java.util.Map;

public class P3_WordFrequency {

    private final Map<String, Integer> wordCount;
    String[] book;

    public P3_WordFrequency(String[] book) {
        this.book = book;
        this.wordCount = new HashMap<>();
        for (String word: book) {
            int count = wordCount.getOrDefault(word, 0);
            wordCount.put(word.trim().toLowerCase(), count+1);
        }
    }

    int findOccurances(String word) {
        if (word == null || word.trim().length() == 0) {
            return 0;
        }
        return wordCount.getOrDefault(word.trim().toLowerCase(), 0);
    }
}
