package com.LinkedList;

import java.util.LinkedList;
import java.util.List;

/*删除链表的倒数第N个节点
    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    示例：
    给定一个链表: 1->2->3->4->5, 和 n = 2.
    当删除了倒数第二个节点后，链表变为 1->2->3->5.
    说明：
    给定的 n 保证是有效的。
    进阶：
    你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //双指针pA、pB,pA指向链表第n节点，pB指向链表头，然后双指针同时以速度1出发，当经过len-n步之后，pA跑到了链表尾，pB跑到了len-n节点，删掉pB指向节点
        if (head == null) return null;
        ListNode pA = head, pB = head;
        int i=0;
        while (i < n) {
            pA =  pA.next;
            i++;
        }

        if(pA==null){//pA已经到达了链表尾，即n=list.len，直接删除链表头
            head = head.next;
            return head;
        }

        //pA已就位，然后pA,pB同时以速度1出发，知道pA到达链表尾（null节点前一位）
        while (pA.next != null) {
            pA = pA.next;
            pB = pB.next;
        }

        //pB跑到了指定位置前一位，删除掉pB后一位
        pB.next = pB.next.next;

        return head;
    }


}
