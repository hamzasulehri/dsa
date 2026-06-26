package dsa.binary_trees.optimal;

/*
Problem: Kth Smallest Element in a BST
Approach: Optimal
Iterative inorder traversal using an explicit stack, stopping as soon
as the k-th node is popped. Avoids visiting the entire tree when k is small.
Time Complexity: O(k) in the best/typical case (bounded by O(n) worst case)
Space Complexity: O(k) for the stack (bounded by O(h) tree height in general)
*/
import java.util.Deque;
import java.util.ArrayDeque;

public class KthSmallestElementInABSTOptimal {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        int count = 0;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            count++;
            if (count == k) {
                return current.val;
            }
            current = current.right;
        }
        throw new IllegalArgumentException("k is out of bounds");
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
