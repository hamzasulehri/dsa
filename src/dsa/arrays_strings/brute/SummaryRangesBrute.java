package dsa.arrays_strings.brute;

/*
Problem: Summary Ranges
Approach: Brute Force
For each starting index, check every following pair to find where the
consecutive run breaks. This repeated pairwise checking is O(n^2).
Time Complexity: O(n^2)
Space Complexity: O(n) for the result list
*/
import java.util.ArrayList;
import java.util.List;

public class SummaryRangesBrute {

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return result;

        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;

            int rangeEnd = i;
            // brute: repeatedly scan ahead checking consecutiveness pair by pair
            for (int j = i + 1; j < n; j++) {
                boolean consecutive = true;
                for (int k = i; k < j; k++) {
                    if (nums[k + 1] - nums[k] != 1) {
                        consecutive = false;
                        break;
                    }
                }
                if (consecutive) {
                    rangeEnd = j;
                    used[j] = true;
                } else {
                    break;
                }
            }

            if (rangeEnd == i) {
                result.add(String.valueOf(nums[i]));
            } else {
                result.add(nums[i] + "->" + nums[rangeEnd]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums)); // expected: [0->2, 4->5, 7]
    }
}
