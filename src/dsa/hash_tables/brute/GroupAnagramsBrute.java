package dsa.hash_tables.brute;

/*
Problem: Group Anagrams
Approach: Brute Force
Compare every word against every other word using a character-count
based isAnagram check, grouping matches together.
Time Complexity: O(n^2 * k) where n = number of words, k = max word length
Space Complexity: O(n * k)
*/
import java.util.ArrayList;
import java.util.List;

public class GroupAnagramsBrute {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        boolean[] grouped = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (grouped[i]) continue;

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            grouped[i] = true;

            // compare against every remaining word - O(n^2) pairs
            for (int j = i + 1; j < strs.length; j++) {
                if (!grouped[j] && isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    grouped[j] = true;
                }
            }
            groups.add(group);
        }
        return groups;
    }

    private static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] counts = new int[26];
        for (int i = 0; i < a.length(); i++) {
            counts[a.charAt(i) - 'a']++;
            counts[b.charAt(i) - 'a']--;
        }
        for (int c : counts) {
            if (c != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
        // expected (order may vary): [[eat, tea, ate], [tan, nat], [bat]]
    }
}
