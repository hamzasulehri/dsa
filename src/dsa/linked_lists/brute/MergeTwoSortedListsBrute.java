package dsa.linked_lists.brute;

/*
Problem: Merge Two Sorted Lists
Approach: Brute Force
Collect all values from both lists into an ArrayList, sort the combined
list, then rebuild a brand-new linked list from the sorted values.
Time Complexity: O(n log n) due to sorting
Space Complexity: O(n) for the intermediate list and rebuilt list
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedListsBrute {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> values = new ArrayList<>();

        ListNode current = list1;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        current = list2;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        Collections.sort(values);

        ListNode newHead = null, tail = null;
        for (int val : values) {
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
