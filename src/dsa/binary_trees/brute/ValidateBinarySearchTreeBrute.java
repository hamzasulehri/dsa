
package dsa.binary_trees.brute;

/*
Problem: Validate Binary Search Tree
Approach: Brute Force
Perform an inorder traversal, collecting values into a list, then
check that the list is strictly sorted in ascending order.
Time Complexity: O(n)
Space Complexity: O(n) for the list
*/
import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTreeBrute {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isValidBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);

        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) <= values.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static void inorder(TreeNode node, List<Integer> values) {
        if (node == null) return;
        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }

    public static void main(String[] args) {
        // build tree: [5,1,4,null,null,3,6] -> invalid BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(isValidBST(root)); // expected: false
    }
}
