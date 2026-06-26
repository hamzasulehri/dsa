package dsa.arrays_strings.brute;

/*
Problem: Longest Common Prefix
Approach: Brute Force
Compare all strings pair by pair, character by character, shrinking the
prefix as mismatches are found.
Time Complexity: O(n*m) where n = number of strings, m = length of shortest string
Space Complexity: O(1) extra (excluding output)
*/
public class LongestCommonPrefixBrute {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = commonPrefix(prefix, strs[i]);
            if (prefix.isEmpty()) return "";
        }
        return prefix;
    }

    private static String commonPrefix(String a, String b) {
        int minLen = Math.min(a.length(), b.length());
        int j = 0;
        while (j < minLen && a.charAt(j) == b.charAt(j)) {
            j++;
        }
        return a.substring(0, j);
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs)); // expected: "fl"
    }
}
