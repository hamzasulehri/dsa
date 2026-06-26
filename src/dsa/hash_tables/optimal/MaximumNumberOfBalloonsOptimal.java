package dsa.hash_tables.optimal;
/*
Problem: Maximum Number of Balloons
Approach: Optimal
Count frequency of each character in "text" once using a HashMap
(or array). "balloon" needs b:1, a:1, l:2, o:2, n:1. The answer is the
minimum of (count[c] / requiredCount[c]) across all needed letters.
Time Complexity: O(n)
Space Complexity: O(1) (fixed alphabet size)
*/
import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloonsOptimal {

    public static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            freq.merge(c, 1, Integer::sum);
        }

        int b = freq.getOrDefault('b', 0);
        int a = freq.getOrDefault('a', 0);
        int l = freq.getOrDefault('l', 0) / 2; // 'l' appears twice in balloon
        int o = freq.getOrDefault('o', 0) / 2; // 'o' appears twice in balloon
        int n = freq.getOrDefault('n', 0);

        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }

    public static void main(String[] args) {
        String text = "nlaebolko";
        System.out.println(maxNumberOfBalloons(text)); // expected: 1
    }
}
