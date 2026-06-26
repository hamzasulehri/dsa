package dsa.binary_trees.brute;
/*
Problem: Diameter of Binary Tree
Approach: Brute Force
For every node, independently compute the height of its left and right
subtrees (each height computation is its own O(n) traversal), and track
the maximum left_height + right_height seen across all nodes.
Time Complexity: O(n^2) — height() is recomputed from scratch for every node
Space Complexity: O(h) recursion stack, h = tree height
*/
public class DiameterOfBinaryTreeBrute {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int diameterThroughRoot = leftHeight + rightHeight;

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(diameterThroughRoot, Math.max(leftDiameter, rightDiameter));
    }

    // recomputed independently for every node -> source of O(n^2) cost
    private static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        // build tree: [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root)); // expected: 3
    }
}
