package com.LinkedList;

/*旋转链表
    给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
    示例 1:
    输入: 1->2->3->4->5->NULL, k = 2
    输出: 4->5->1->2->3->NULL
    解释:
    向右旋转 1 步: 5->1->2->3->4->NULL
    向右旋转 2 步: 4->5->1->2->3->NULL

    示例 2:
    输入: 0->1->2->NULL, k = 4
    输出: 2->0->1->NULL
    解释:
    向右旋转 1 步: 2->0->1->NULL
    向右旋转 2 步: 1->2->0->NULL
    向右旋转 3 步: 0->1->2->NULL
    向右旋转 4 步: 2->0->1->NULL
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        //边界校验
        if(head==null || head.next==null || k==0) return head;

        //遍历一次将链表尾接头形成闭环，顺便获得链表长度n,k=k%n
        int n=1;
        ListNode node = head;
        while(node.next!=null){
            node = node.next;
            n++;
        }
        node.next = head;
        k=k%n;
        //System.out.println("n:"+n+",k:"+k);

        //计算新的尾和头节点，新的尾节点指向新的头节点
        ListNode newTail = head;
        //新尾节点应该对应原链表下标n-k-1的节点
        for(int i=0;i<n-k-1;i++){
            newTail = newTail.next;
            //System.out.println("i:"+i);
        }

        ListNode newHead = newTail.next;

        //新尾节点指向null,即断开新尾到新头的链接
        newTail.next = null;

        //返回新的头节点
        return newHead;
    }
}
