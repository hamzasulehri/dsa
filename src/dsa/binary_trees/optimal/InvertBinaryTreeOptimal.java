package dsa.binary_trees.optimal;

/*
Problem: Invert Binary Tree
Approach: Optimal
Recursive DFS. Swap left/right children at each node and recurse into
the (now-swapped) subtrees. Elegant and concise.
Time Complexity: O(n)
Space Complexity: O(h) for recursion stack, h = tree height (O(n) worst case)
*/
public class InvertBinaryTreeOptimal {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

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
