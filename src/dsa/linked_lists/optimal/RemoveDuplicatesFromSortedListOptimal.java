package dsa.linked_lists.optimal;

/*
Problem: Remove Duplicates from Sorted List
Approach: Optimal
Since the list is already sorted, a single pointer can skip over
duplicate-valued nodes in-place by re-linking next pointers. No extra
data structure or new list is needed.
Time Complexity: O(n)
Space Complexity: O(1)
*/
public class RemoveDuplicatesFromSortedListOptimal {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // skip the duplicate
            } else {
                current = current.next;
            }
        }
        return head;
    }

    private static String toStringList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" ");
            head = head.next;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        // build list: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode result = deleteDuplicates(head);
        System.out.println(toStringList(result)); // expected: 1 2 3
    }
}
