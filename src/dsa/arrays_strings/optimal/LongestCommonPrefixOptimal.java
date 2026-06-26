package dsa.arrays_strings.optimal;

/*
Problem: Longest Common Prefix
Approach: Optimal
Sort the array lexicographically. After sorting, the common prefix of
the entire array equals the common prefix of just the first and last
strings, since sorting brings the most different strings to the ends.
Time Complexity: O(n log n)
Space Complexity: O(1) extra (excluding output and sort's internal space)
*/
import java.util.Arrays;

public class LongestCommonPrefixOptimal {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        int j = 0;
        int minLen = Math.min(first.length(), last.length());
        while (j < minLen && first.charAt(j) == last.charAt(j)) {
            j++;
        }
        return first.substring(0, j);
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs)); // expected: "fl"
    }
}
