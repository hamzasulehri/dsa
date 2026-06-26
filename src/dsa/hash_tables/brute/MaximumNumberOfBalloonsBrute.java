package dsa.hash_tables.brute;

/*
Problem: Maximum Number of Balloons
Approach: Brute Force
For each candidate count k (starting from 1 upward), manually count
whether "text" has enough of each required letter to spell "balloon"
k times. Increment k until it's no longer possible.
Time Complexity: O(n * maxCount) where n = length of text
Space Complexity: O(1)
*/
public class MaximumNumberOfBalloonsBrute {

    public static int maxNumberOfBalloons(String text) {
        int k = 0;
        while (canMake(text, k + 1)) {
            k++;
        }
        return k;
    }

    // manually counts characters every time (brute / repeated work)
    private static boolean canMake(String text, int k) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b': b++; break;
                case 'a': a++; break;
                case 'l': l++; break;
                case 'o': o++; break;
                case 'n': n++; break;
                default: break;
            }
        }
        return b >= k && a >= k && (l / 2) >= k && (o / 2) >= k && n >= k;
    }

    public static void main(String[] args) {
        String text = "nlaebolko";
        System.out.println(maxNumberOfBalloons(text)); // expected: 1
    }
}
