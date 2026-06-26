package dsa.binary_trees.optimal;

/*
Problem: Maximum Depth of Binary Tree
Approach: Optimal
Recursive DFS: depth(node) = 1 + max(depth(left), depth(right)).
Cleaner and avoids manual queue/level bookkeeping.
Time Complexity: O(n)
Space Complexity: O(h) for recursion stack, h = tree height (O(n) worst case)
*/
public class MaximumDepthOfBinaryTreeOptimal {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        // build tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root)); // expected: 3
    }
}
