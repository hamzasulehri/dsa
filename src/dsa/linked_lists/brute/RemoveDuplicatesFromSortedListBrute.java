package dsa.linked_lists.brute;

/*
Problem: Remove Duplicates from Sorted List
Approach: Brute Force
Convert the list into an ArrayList, deduplicate values using a HashSet
while preserving order, then rebuild a brand-new linked list from the
deduplicated values.
Time Complexity: O(n)
Space Complexity: O(n) for the intermediate list/set and rebuilt list
*/
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicatesFromSortedListBrute {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        // LinkedHashSet preserves insertion order while removing duplicates
        LinkedHashSet<Integer> deduped = new LinkedHashSet<>(values);

        // rebuild a brand new list
        ListNode newHead = null, tail = null;
        for (int val : deduped) {
            ListNode node = new ListNode(val);
            if (newHead == null) {
                newHead = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        return newHead;
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
