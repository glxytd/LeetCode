package com.LinkedList;

import java.util.LinkedList;
import java.util.List;

public class BaseFunction {

    public static void printList(ListNode head) {
        ListNode curNode = head;
        while(curNode != null) {
            System.out.print(curNode.val + "->");
            curNode = curNode.next;
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        // 创建如官方题解的链表节点
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        // 把链表接起来
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;

        //Solution solution = new Solution();
        //printList(solution.oddEvenList(l1));
    }


}
