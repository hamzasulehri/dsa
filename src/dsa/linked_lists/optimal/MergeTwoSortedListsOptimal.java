package dsa.linked_lists.optimal;

/*
Problem: Merge Two Sorted Lists
Approach: Optimal
Two-pointer merge in-place. Since both lists are already sorted, walk
both simultaneously, always attaching the smaller current node to the
result, re-linking existing nodes (no new nodes are allocated).
Time Complexity: O(n)
Space Complexity: O(1) extra (excluding the dummy head pointer)
*/
public class MergeTwoSortedListsOptimal {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // attach whichever list still has remaining nodes
        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;
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
        // list1: 1 -> 2 -> 4, list2: 1 -> 3 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode merged = mergeTwoLists(list1, list2);
        System.out.println(toStringList(merged)); // expected: 1 1 2 3 4 4
    }
}
