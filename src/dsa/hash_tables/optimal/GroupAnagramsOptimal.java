package dsa.hash_tables.optimal;

/*
Problem: Group Anagrams
Approach: Optimal
Sort each word's characters to form a canonical key (anagrams share the
same sorted form). Use a HashMap to group words by that key in one pass.
Time Complexity: O(n * k log k) where n = number of words, k = max word length
Space Complexity: O(n * k)
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class GroupAnagramsOptimal {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars); // canonical anagram key

            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
        // expected (order may vary): [[eat, tea, ate], [tan, nat], [bat]]
    }
}
