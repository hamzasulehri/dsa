package dsa.hash_tables.optimal;

/*
Problem: Contains Duplicate
Approach: Optimal
Use a HashSet for O(1) average lookup/insert. If a number is already
in the set, a duplicate exists.
Time Complexity: O(n)
Space Complexity: O(n)
*/
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateOptimal {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) { // add() returns false if already present
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
