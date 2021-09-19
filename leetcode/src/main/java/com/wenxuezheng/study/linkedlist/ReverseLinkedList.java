package com.wenxuezheng.study.linkedlist;


/**
 * TODO
 *
 * @author hubo
 * @since 2019-02-13
 */

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.setNext(2).setNext(3).setNext(4).setNext(5);
        //while (listNode != null) {
        //    System.out.println(listNode.val);
        //    listNode = listNode.next;
        //}

        ListNode result = new ReverseLinkedList().reverseList(listNode);
        System.out.println("--------- iteratively --------");
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        ListNode listNode2 = new ListNode(1);
        listNode2.setNext(2).setNext(3).setNext(4).setNext(5);
        System.out.println("--------- recursively --------");
        ListNode result2 = new ReverseLinkedList().reverseList2(listNode2);
        while (result2 != null) {
            System.out.println(result2.val);
            result2 = result2.next;
        }

        ListNode listNode3 = new ListNode(1);
        listNode3.setNext(2).setNext(3).setNext(4).setNext(5);
        System.out.println("--------- recursively2 --------");
        ListNode result3 = new ReverseLinkedList().reverseList3(listNode3,null);
        while (result3 != null) {
            System.out.println(result3.val);
            result3 = result3.next;
        }
    }

    /**
     * iteratively
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    /**
     * recursively
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode next = head.next;

        head.next = null;

        ListNode node = reverseList2(next);

        next.next = head;

        return node;
    }

    /**
     * recursively2
     *
     * @return
     */
    public ListNode reverseList3(ListNode node, ListNode prev) {
        if (node.next == null) {
            node.next = prev;
            return node;
        } else {
            ListNode re = reverseList3(node.next, node);
            node.next = prev;
            return re;
        }
    }



}


/**
 * Definition for singly-linked list.
 */
class ListNode {
    public int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode setNext(int x) {
        final ListNode next = new ListNode(x);
        this.next = next;
        return next;
    }
}