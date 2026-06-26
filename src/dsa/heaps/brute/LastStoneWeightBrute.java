package dsa.heaps.brute;

/*
Problem: Last Stone Weight
Approach: Brute Force
Sort the array on every iteration to find the two heaviest stones,
smash them together, replace, and repeat until one (or zero) stones remain.
Time Complexity: O(n^2 log n) — sorting (O(n log n)) repeated up to n times
Space Complexity: O(n) for the working list
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LastStoneWeightBrute {

    public static int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int s : stones) list.add(s);

        while (list.size() > 1) {
            Collections.sort(list); // re-sort every iteration (brute force)
            int n = list.size();
            int y = list.remove(n - 1); // heaviest
            int x = list.remove(n - 2); // second heaviest
            int diff = y - x;
            if (diff > 0) {
                list.add(diff);
            }
        }
        return list.isEmpty() ? 0 : list.get(0);
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones)); // expected: 1
    }
}
