package dsa.hash_tables.brute;

/*
Problem: Valid Anagram
Approach: Brute Force
Sort both strings into character arrays and compare them for equality.
Time Complexity: O(n log n)
Space Complexity: O(n)
*/
import java.util.Arrays;

public class ValidAnagramBrute {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t)); // expected: true
    }
}
