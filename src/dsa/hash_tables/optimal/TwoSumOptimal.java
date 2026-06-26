package dsa.hash_tables.optimal;

/*
Problem: Two Sum
Approach: Optimal
Single pass using a HashMap to store each number's complement
(target - num) -> index. Look up the complement before inserting.
Time Complexity: O(n)
Space Complexity: O(n)
*/
import java.util.HashMap;
import java.util.Map;

public class TwoSumOptimal {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[] {seen.get(complement), i};
            }
            seen.put(nums[i], i);
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
