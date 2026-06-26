package dsa.arrays_strings.optimal;

/*
Problem: Find Closest Number to Zero
Approach: Optimal
Same O(n) single pass as brute force, but the tie-break logic for
positive vs negative numbers is handled explicitly and cleanly in one pass.
(For this problem brute force and optimal converge to the same complexity;
the "optimisation" here is code clarity / explicit tie handling.)
Time Complexity: O(n)
Space Complexity: O(1)
*/
public class FindClosestNumberToZeroOptimal {

    public static int findClosestNumber(int[] nums) {
        int closest = nums[0];
        int minDist = Math.abs(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int dist = Math.abs(nums[i]);
            if (dist < minDist || (dist == minDist && nums[i] > closest)) {
                minDist = dist;
                closest = nums[i];
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, 1, 4, 8};
        System.out.println(findClosestNumber(nums)); // expected: 1
    }
}
