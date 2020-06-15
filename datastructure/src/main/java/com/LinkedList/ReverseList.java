package com.LinkedList;

/*
    反转一个单链表。
    示例:
    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
    进阶:
    你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList {
    //迭代方式
    public ListNode reverseList(ListNode head) {
        //在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。
        //在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    //递归方式
    public ListNode reverseList2(ListNode head) {
        //返回条件 ：如果 head 为空或者 head.next 为空，则说明没有节点或者只有一个节点了，返回本节点即可。
        //假设 head 节点的 后一个节点 node 节点已经反转好了，只需要改变 node 的下一个节点指向 head 同时 head 的下一个节点指向 null
        //head ---> node <--- ... <--- // ListNode node = reverseList(head.next);
        //head <--- node <--- ... <--- // head.next.next = head;
        //null <--- head <--- node <--- ... <--- //  head.next = null; 反转完成
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


}
