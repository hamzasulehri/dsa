package dsa.binary_trees.optimal;

/*
Problem: Diameter of Binary Tree
Approach: Optimal
Single DFS pass. Each call returns the height of its subtree while
simultaneously updating a global maximum diameter (left height +
right height) seen so far at that node.
Time Complexity: O(n)
Space Complexity: O(h) recursion stack, h = tree height
*/
public class DiameterOfBinaryTreeOptimal {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private static int maxDiameter;

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        height(root);
        return maxDiameter;
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
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
