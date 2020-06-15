package com.LinkedList;

/*奇偶链表
    给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
    请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
    示例 1:
    输入: 1->2->3->4->5->NULL
    输出: 1->3->5->2->4->NULL
    示例 2:
    输入: 2->1->3->5->6->4->7->NULL
    输出: 2->3->6->7->1->5->4->NULL
    说明:
    应当保持奇数节点和偶数节点的相对顺序。
    链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        //构建两个链表，奇数节点链表、偶数节点链表，将节点依次添加到对应链表，然后让奇数链表尾指向偶数链表头
        //设定奇数节点链表头节点oddHead，尾节点oddTail
        //设定偶数节点链表头节点evenHead,尾节点evenTail

        if(head==null) return null;

        ListNode oddHead=head, oddTail=head, evenHead=head.next, evenTail=head.next;

        while(evenTail!=null&&evenTail.next!=null){//偶数节点链表尾节点先到达原链表尾节点
            oddTail.next = evenTail.next;  // 相当于odd.next = odd.next.next(跳过一个偶数节点)
            oddTail = oddTail.next;        // odd向前前进一位
            evenTail.next = oddTail.next;   // 奇链表的下一个节点就是偶链表的节点
            evenTail = evenTail.next;       // even向前前进一位
        }

        oddTail.next = evenHead;

        return oddHead;
    }


}
