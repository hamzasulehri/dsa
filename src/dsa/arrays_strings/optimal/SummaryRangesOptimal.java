package dsa.arrays_strings.optimal;

/*
Problem: Summary Ranges
Approach: Optimal
Single pass using a start pointer. Extend the range while consecutive,
then record the range when the streak breaks.
Time Complexity: O(n)
Space Complexity: O(n) for the result list
*/
import java.util.ArrayList;
import java.util.List;

public class SummaryRangesOptimal {

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return result;

        int start = 0;
        for (int i = 0; i <= n; i++) {
            // break the range when we hit the end, or when consecutiveness breaks
            if (i == n || nums[i] - nums[i - 1] != 1) {
                if (start == i - 1) {
                    result.add(String.valueOf(nums[start]));
                } else {
                    result.add(nums[start] + "->" + nums[i - 1]);
                }
                start = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums)); // expected: [0->2, 4->5, 7]
    }
}
