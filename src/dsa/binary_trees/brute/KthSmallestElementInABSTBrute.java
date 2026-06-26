package dsa.binary_trees.brute;

/*
Problem: Kth Smallest Element in a BST
Approach: Brute Force
Perform a full inorder traversal collecting all values into a list
(inorder traversal of a BST yields sorted order), then index at k-1.
Time Complexity: O(n)
Space Complexity: O(n) for the list
*/
import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABSTBrute {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        return values.get(k - 1);
    }

    private static void inorder(TreeNode node, List<Integer> values) {
        if (node == null) return;
        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }

    public static void main(String[] args) {
        // build tree: [5,3,6,2,4,null,null,1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        System.out.println(kthSmallest(root, 3)); // expected: 3
    }
}
