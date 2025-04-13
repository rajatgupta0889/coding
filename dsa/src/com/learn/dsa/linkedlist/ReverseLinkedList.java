package com.learn.dsa.linkedlist;

public class ReverseLinkedList {
    /**
     * https://leetcode.com/problems/reverse-linked-list/
     * 206. Reverse Linked List
     * */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null){
            next = current.next;
            current.next  = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversedHead = reverseLinkedList.reverseList(head);
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
        }
    }


}
