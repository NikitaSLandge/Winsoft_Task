import java.util.HashMap;
import java.util.Map;

public class Count_Words {

    public static void main(String[] args) {
        String str = "Hello World, this is a sample string to count the number of words.";
        int wordCount = countWords(str);
        System.out.println("Number of words in the string: " + wordCount);
    }

    public static int countWords(String str) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        String[] words = str.split("\\s+");
        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {

                wordCountMap.put(word, 1);
            }
        }

        return wordCountMap.size();
    }
}

