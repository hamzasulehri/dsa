package dsa.two_pointers.brute;

/*
Problem: Valid Palindrome
Approach: Brute Force
Build a cleaned string (lowercase, alphanumeric only), then build a
separate reversed copy of it, and compare the two strings for equality.
Time Complexity: O(n)
Space Complexity: O(n) extra strings
*/
public class ValidPalindromeBrute {

    public static boolean isPalindrome(String s) {
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }

        String cleanedStr = cleaned.toString();
        String reversedStr = new StringBuilder(cleanedStr).reverse().toString();

        return cleanedStr.equals(reversedStr);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s)); // expected: true
    }
}
