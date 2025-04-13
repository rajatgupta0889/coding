package com.learn.dsa.linkedlist;

public class MergeTwoSortedList {

    /**
     * https://leetcode.com/problems/merge-two-sorted-lists/
     * 21. Merge Two Sorted Lists
     * */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list2 == null) return list1;
        if(list1 == null) return list2;

        ListNode head = new ListNode(0);
        ListNode start = head;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                head.next = list1;
                list1 = list1.next;
            }else{
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        while (list1 != null){
            head.next = list1;
            list1 = list1.next;
            head = head.next;
        }

        while (list2 != null){
            head.next = list2;
            list2 = list2.next;
            head = head.next;
        }


        return start.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode mergedList = mergeTwoSortedList.mergeTwoLists(list1, list2);
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
