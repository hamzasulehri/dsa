package dsa.two_pointers.optimal;

/*
Problem: Valid Palindrome
Approach: Optimal
Two pointers starting from both ends of the original string, skipping
non-alphanumeric characters and comparing lowercase letters directly,
with no extra string built.
Time Complexity: O(n)
Space Complexity: O(1)
*/
public class ValidPalindromeOptimal {

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s)); // expected: true
    }
}
