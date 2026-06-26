package dsa.hash_tables.brute;


/*
Problem: Two Sum
Approach: Brute Force
Check every pair of indices to see if their values sum to the target.
Time Complexity: O(n^2)
Space Complexity: O(1)
*/
public class TwoSumBrute {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1}; // no solution found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + ", " + result[1]); // expected: 0, 1
    }
}
