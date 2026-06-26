package dsa.two_pointers.optimal;

/*
Problem: Reverse String
Approach: Optimal
Two pointers, one at each end of the array, swapping characters and
moving toward the centre. Done in-place with no extra array.
Time Complexity: O(n)
Space Complexity: O(1)
*/
public class ReverseStringOptimal {

    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(new String(s)); // expected: "olleh"
    }
}
