package dsa.two_pointers.brute;

/*
Problem: Reverse String
Approach: Brute Force
Build a new array, filling it from the back using an extra array,
then copy values back into the original array.
Time Complexity: O(n)
Space Complexity: O(n) extra array
*/
public class ReverseStringBrute {

    public static void reverseString(char[] s) {
        int n = s.length;
        char[] reversed = new char[n];

        for (int i = 0; i < n; i++) {
            reversed[i] = s[n - 1 - i];
        }

        for (int i = 0; i < n; i++) {
            s[i] = reversed[i];
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(new String(s)); // expected: "olleh"
    }
}
