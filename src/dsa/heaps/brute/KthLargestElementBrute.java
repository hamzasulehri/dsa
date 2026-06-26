package dsa.heaps.brute;
/*
Problem: Kth Largest Element in Array
Approach: Brute Force
Sort the array in descending order and return the element at index k-1.
Time Complexity: O(n log n)
Space Complexity: O(1) extra (excluding sort's internal space)
*/
import java.util.Arrays;
import java.util.Collections;

public class KthLargestElementBrute {

    public static int findKthLargest(int[] nums, int k) {
        Integer[] boxed = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boxed[i] = nums[i];
        }
        Arrays.sort(boxed, Collections.reverseOrder());
        return boxed[k - 1];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2)); // expected: 5
    }
}
