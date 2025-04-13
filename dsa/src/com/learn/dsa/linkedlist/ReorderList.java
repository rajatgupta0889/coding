package com.learn.dsa.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {

    /**
     * https://leetcode.com/problems/reorder-list/
     * 143. Reorder List
     * Given the head of a singly linked list, reorder it so that the linked list becomes:
     * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
     * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
     * Do this in-place and do not use extra memory.
     */

    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();

        ListNode current = head;
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        int left = 0;
        int right = nodes.size() - 1;
        while (left < right) {
            nodes.get(left).next = nodes.get(right);
            left++;
            if (left == right) break;
            nodes.get(right).next = nodes.get(left);
            right--;
        }
        nodes.get(left).next = null; // Set the last node's next to null
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList.reorderList(head);

        // Print the reordered list
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
