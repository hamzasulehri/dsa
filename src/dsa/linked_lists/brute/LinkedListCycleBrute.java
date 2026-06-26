package dsa.linked_lists.brute;

/*
Problem: Linked List Cycle
Approach: Brute Force
Traverse the list, storing every visited node reference in a HashSet.
If we ever encounter a node already in the set, a cycle exists.
Time Complexity: O(n)
Space Complexity: O(n) for the set of visited nodes
*/
import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleBrute {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            if (visited.contains(current)) {
                return true;
            }
            visited.add(current);
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        // build list: 3 -> 2 -> 0 -> -4 -> (back to node with val 2)
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // creates a cycle

        System.out.println(hasCycle(head)); // expected: true
    }
}
