package com.wenxuezheng.study.medium;

public class Nineteenth {
    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = removeNthFromEnd(listNode0, 2);
        //System.out.println(listNode);
        ListNode listNode6 = removeNthFromEndWithTwoPointer(listNode, 2);
        System.out.println(listNode6);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] arr = new ListNode[30];
        arr[0] = head;
        ListNode curren = head;
        int i = 1;
        while (true) {
            if (curren.next == null) {
                break;
            }
            arr[i++] = curren.next;
            curren = curren.next;
        }
        int min = i - n;
        if(min < 0) {
            return null;
        }
        if(min == 0) {
            return head.next;
        }
        ListNode listNode = arr[min-1];
        listNode.next = i - n + 1 > i ? null : arr[i - n + 1];
        return head;
    }

    /**
     * java-solution
     */
    public static ListNode removeNthFromEndWithTwoPointer(ListNode head, int n) {

        if(head == null) return head;
        ListNode firstPtr = head;
        ListNode secondPtr = head;

        // second ptr will move forward n times

        for(int i=0; i<n;i++){
            secondPtr = secondPtr.next;
        }

        // Now both first and second pointer will move forward until second pointer reaches the end
        //  this way first pointer will point to nth node from the end

        // But first we have to check if we are supposed to delete the head
        if(secondPtr==null){
            if(head.next!=null){
                head.val = head.next.val;
                head.next = head.next.next;
            }
            // In case Linked List has only one node i.e. head only
            else{
                head = null;
            }
            return head;
        }

        while(secondPtr.next!=null){
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        firstPtr.next = firstPtr.next.next;

        return head;
    }
}


/**
 * *Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
