package com.learn.dsa.linkedlist;

public class LinkedListCycle {

    /**
     * https://leetcode.com/problems/linked-list-cycle/
     * 141. Linked List Cycle
     */

    public boolean hasCycle(ListNode head) {

        ListNode fastPointer = head;
        ListNode slowPointer = head;

        if(head == null || head.next == null){
            return false;
        }

        while (fastPointer != null && slowPointer != null){
            fastPointer = fastPointer.next;
            if(fastPointer != null){
                fastPointer = fastPointer.next;
            }

            slowPointer = slowPointer.next;

            if(slowPointer == fastPointer){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
        head.next.next.next.next = head.next; // Creating a cycle for testing

        System.out.println(linkedListCycle.hasCycle(head)); // Should return true

        ListNode head2 = new ListNode(1, null);
        System.out.println(linkedListCycle.hasCycle(head2));

        ListNode head3 = new ListNode(1, new ListNode(2, null));
        System.out.println(linkedListCycle.hasCycle(head3));
    }

}
