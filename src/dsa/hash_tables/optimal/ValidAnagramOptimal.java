package dsa.hash_tables.optimal;

/*
Problem: Valid Anagram
Approach: Optimal
Use a fixed-size frequency array (26 lowercase letters). Increment for
characters in s, decrement for characters in t. If all counts return
to zero, the strings are anagrams.
Time Complexity: O(n)
Space Complexity: O(1) (fixed-size 26-element array)
*/
public class ValidAnagramOptimal {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t)); // expected: true
    }
}
