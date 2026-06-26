package dsa.hash_tables.brute;

/*
Problem: Contains Duplicate
Approach: Brute Force
Sort the array, then compare each element with its adjacent neighbour.
Time Complexity: O(n log n)
Space Complexity: O(1) extra (ignoring sort's internal space)
*/
import java.util.Arrays;

public class ContainsDuplicateBrute {

    public static boolean containsDuplicate(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] == sorted[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums)); // expected: true
    }
}
