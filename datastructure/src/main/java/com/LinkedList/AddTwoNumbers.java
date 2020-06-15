package com.LinkedList;

/* 两数相加
    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储一位数字。
    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    示例：
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode addHead = new ListNode(-1);//虚拟头
        ListNode add = addHead;

        int k = 0;//进位值
        int v = 0;//进位后剩余值
        while(l1!=null&&l2!=null){
            v = (l1.val +l2.val+k)%10;
            k = (l1.val +l2.val+k)/10;
            add.next = new ListNode(v);
            add = add.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1!=null){
            while(l1!=null){
                v = (l1.val+k)%10;
                k = (l1.val+k)/10;
                add.next = new ListNode(v);
                add = add.next;
                l1 = l1.next;
            }
        }else{
            while(l2!=null){
                v = (l2.val+k)%10;
                k = (l2.val+k)/10;
                add.next = new ListNode(v);
                add = add.next;
                l2 = l2.next;
            }
        }

        if(k>0){
            add.next = new ListNode(k);
        }

        return addHead.next;
    }
}
