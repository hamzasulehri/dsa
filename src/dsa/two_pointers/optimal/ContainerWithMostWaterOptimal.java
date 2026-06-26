package dsa.two_pointers.optimal;

/*
Problem: Container With Most Water
Approach: Optimal
Two pointers starting at both ends. Always move the pointer at the
shorter wall inward, since moving the taller wall can never increase
the area (width shrinks, height is still bounded by the shorter wall).
Time Complexity: O(n)
Space Complexity: O(1)
*/
public class ContainerWithMostWaterOptimal {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int boundedHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * boundedHeight);

            // move the shorter side inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height)); // expected: 49
    }
}
