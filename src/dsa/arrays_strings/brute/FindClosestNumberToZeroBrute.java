package dsa.arrays_strings.brute;

/*
Problem: Find Closest Number to Zero
Approach: Brute Force
Linear scan, track minimum absolute value seen so far.
On a tie (two numbers with same absolute value), the positive one wins.
Time Complexity: O(n)
Space Complexity: O(1)
*/
public class FindClosestNumberToZeroBrute {

    public static int findClosestNumber(int[] nums) {
        int closest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // strictly closer to zero
            if (Math.abs(num) < Math.abs(closest)) {
                closest = num;
            } else if (Math.abs(num) == Math.abs(closest) && num > closest) {
                // tie -> prefer the positive value
                closest = num;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, 1, 4, 8};
        System.out.println(findClosestNumber(nums)); // expected: 1
    }
}
