package com.learn.dsa.linkedlist;

public class RemoveNthNodeFormLast {
    /**
     * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
     * 19. Remove Nth Node From End of List
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        for(int i =0; i< n; i++){
            fastPointer = fastPointer.next;
        }

        if(fastPointer == null){
            return head.next;
        }

        while (fastPointer.next != null){
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        slowPointer.next = slowPointer.next.next;

        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFormLast removeNthNodeFormLast = new RemoveNthNodeFormLast();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;

        ListNode result = removeNthNodeFormLast.removeNthFromEnd(head, n);

        // Print the modified list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}
