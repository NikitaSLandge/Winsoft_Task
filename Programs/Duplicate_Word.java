import java.util.HashMap;
import java.util.Map;

public class Duplicate_Word {

    public static void main(String[] args) {
        String str = "Hello World";
        findDuplicateCharacters(str);
    }

    public static void findDuplicateCharacters(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        char[] chars = str.toCharArray();

        for (char ch : chars) {
            if (charCountMap.containsKey(ch)) {
                charCountMap.put(ch, charCountMap.get(ch) + 1);
            } else {
                charCountMap.put(ch, 1);
            }
        }

        System.out.println("Duplicate characters in the string '" + str + "' are:");
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}

