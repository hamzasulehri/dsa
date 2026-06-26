package dsa.binary_trees.brute;

/*
Problem: Minimum Absolute Difference in BST
Approach: Brute Force
Collect all node values via inorder traversal into a list, then check
every pair of values to find the minimum absolute difference.
Time Complexity: O(n^2)
Space Complexity: O(n) for the list
*/
import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBSTBrute {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);

        int minDiff = Integer.MAX_VALUE;
        // check every pair - O(n^2)
        for (int i = 0; i < values.size(); i++) {
            for (int j = i + 1; j < values.size(); j++) {
                int diff = Math.abs(values.get(i) - values.get(j));
                minDiff = Math.min(minDiff, diff);
            }
        }
        return minDiff;
    }

    private static void inorder(TreeNode node, List<Integer> values) {
        if (node == null) return;
        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }

    public static void main(String[] args) {
        // build tree: [4,2,6,1,3]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(getMinimumDifference(root)); // expected: 1
    }
}
