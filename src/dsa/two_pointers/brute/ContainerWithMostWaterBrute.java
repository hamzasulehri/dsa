package dsa.two_pointers.brute;

/*
Problem: Container With Most Water
Approach: Brute Force
Check every pair of heights (i, j) and compute the area between them,
tracking the maximum found.
Time Complexity: O(n^2)
Space Complexity: O(1)
*/
public class ContainerWithMostWaterBrute {

    public static int maxArea(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                int boundedHeight = Math.min(height[i], height[j]);
                int area = width * boundedHeight;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height)); // expected: 49
    }
}
