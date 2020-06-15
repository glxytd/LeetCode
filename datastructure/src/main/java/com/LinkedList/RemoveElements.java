package com.LinkedList;

import java.util.LinkedList;
import java.util.List;
/*移除链表元素
    删除链表中等于给定值 val 的所有节点。
    示例:
    输入: 1->2->6->3->4->5->6, val = 6
    输出: 1->2->3->4->5
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        //防止需要删除的节点连续堆积在前几个下标，这样删除时要多次设置head，先迭代到第一个非val的节点，将这个节点置为head
        //然后从这个新头节点的下一个节点开始迭代判断，如果val符合，则前一节点直接指向下一节点
        ListNode curr = head;
        while (curr != null) {
            if (curr.val != val) {//找到第一个有效保留节点
                break;
            }
            curr = curr.next;
        }
        head = curr;//head有可能直接为null了

        if(head == null) return null;

        ListNode prev = head;//此时prev肯定不为null
        curr = head.next;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        //防止需要删除的节点连续堆积在前几个下标，这样删除时要多次设置head，当然可以先迭代到第一个非val的节点
        //机智做法是先设置一个伪头，就不用考虑上述问题了，可以直接用前一节点指向下节点的方式来完成功能

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }


}
