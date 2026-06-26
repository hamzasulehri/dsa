package dsa.binary_trees.optimal;

/*
Problem: Validate Binary Search Tree
Approach: Optimal
DFS while passing down valid (min, max) bounds for each node. A node
must lie strictly within its allowed bounds; bounds tighten as we
recurse into children. Avoids building any extra list.
Time Complexity: O(n)
Space Complexity: O(h) recursion stack, h = tree height
*/
public class ValidateBinarySearchTreeOptimal {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode node, Long lower, Long upper) {
        if (node == null) return true;

        if (lower != null && node.val <= lower) return false;
        if (upper != null && node.val >= upper) return false;

        return validate(node.left, lower, (long) node.val)
            && validate(node.right, (long) node.val, upper);
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
