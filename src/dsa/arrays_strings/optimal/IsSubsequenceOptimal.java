package dsa.arrays_strings.optimal;

/*
Problem: Is Subsequence
Approach: Optimal
Two-pointer technique. Advance pointer i (over s) and j (over t)
independently in a single pass.
Time Complexity: O(n+m)
Space Complexity: O(1)
*/
public class IsSubsequenceOptimal {

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int sLen = s.length(), tLen = t.length();

        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // matched a character of s, move to next target char
            }
            j++; // always advance through t
        }

        return i == sLen; // true if we matched every character of s
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t)); // expected: true
    }
}
