package dsa.binary_trees.brute;

/*
Problem: Invert Binary Tree
Approach: Brute Force
Iterative BFS using a queue. Visit each node level by level and swap
its left and right children.
Time Complexity: O(n)
Space Complexity: O(n) for the queue (worst case, wide tree)
*/
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTreeBrute {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }

    private static void printPreorder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val).append(" ");
        printPreorder(node.left, sb);
        printPreorder(node.right, sb);
    }

    public static void main(String[] args) {
        // build tree: [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode result = invertTree(root);
        StringBuilder sb = new StringBuilder();
        printPreorder(result, sb);
        System.out.println(sb.toString().trim()); // expected: 4 7 9 6 2 3 1
    }
}
