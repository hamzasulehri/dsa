package dsa.arrays_strings.brute;

/*
Problem: Is Subsequence
Approach: Brute Force
For each character of s, search t starting just after the previous match
using a fresh inner loop. Nested loops give O(n*m) in the worst case.
Time Complexity: O(n*m)
Space Complexity: O(1)
*/
public class IsSubsequenceBrute {

    public static boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int tStart = 0;

        for (int i = 0; i < sLen; i++) {
            char target = s.charAt(i);
            boolean found = false;

            // inner loop re-scans from tStart every time (brute force)
            for (int j = tStart; j < tLen; j++) {
                if (t.charAt(j) == target) {
                    found = true;
                    tStart = j + 1;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t)); // expected: true
    }
}
