import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
 
public class AnagramFinder {
    public static void main(String[] args) {
        String[] arr = {"abc", "xyy", "zh", "bac", "o", "yxy", "hz", "cba", "yyx", "acb", "abc"};
        anagramFinder(arr);
    }
 
    public static void anagramFinder(String[] arr) {
        Map <String, String> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            char[] wordArr = word.toCharArray();
            Arrays.sort(wordArr);
            String sortWord = new String(wordArr);
 
            String mapValues = map.get(sortWord);
            if (mapValues == null) {
                map.put(sortWord, word);
            }
            else {
                map.put(sortWord, mapValues + " " + word);
            }
        }
        for (String key : map.values()) {
            System.out.println(key);
        }
    }
}
