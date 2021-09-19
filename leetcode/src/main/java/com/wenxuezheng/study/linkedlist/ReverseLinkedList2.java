package com.wenxuezheng.study.linkedlist;


/**
 * TODO
 *
 * @author hubo
 * @since 2019-02-13
 */

public class ReverseLinkedList2 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.setNext(2).setNext(3).setNext(4).setNext(5);

        ListNode result = new ReverseLinkedList2().reverseBetween(listNode, 2, 4);
        System.out.println("--------- iteratively --------");
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null;
        int i = 1;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;

    }
}