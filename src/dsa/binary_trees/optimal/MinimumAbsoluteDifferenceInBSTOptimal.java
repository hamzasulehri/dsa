package dsa.binary_trees.optimal;

/*
Problem: Minimum Absolute Difference in BST
Approach: Optimal
Inorder traversal of a BST visits nodes in sorted order, so the
minimum difference must occur between some pair of adjacent nodes in
that order. Track a "prev" pointer and update the running minimum as
we go — no extra list needed.
Time Complexity: O(n)
Space Complexity: O(h) recursion stack, h = tree height
*/
public class MinimumAbsoluteDifferenceInBSTOptimal {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private static Integer prev;
    private static int minDiff;

    public static int getMinimumDifference(TreeNode root) {
        prev = null;
        minDiff = Integer.MAX_VALUE;
        inorder(root);
        return minDiff;
    }

    private static void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;

        inorder(node.right);
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
