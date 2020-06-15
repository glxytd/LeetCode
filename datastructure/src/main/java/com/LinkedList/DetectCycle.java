package com.LinkedList;

import java.util.LinkedList;
import java.util.List;

/*环形链表 II
    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
    说明：不允许修改给定的链表。

    示例 1：
    输入：head = [3,2,0,-4], pos = 1
    输出：tail connects to node index 1
    解释：链表中有一个环，其尾部连接到第二个节点。

    示例 2：
    输入：head = [1,2], pos = 0
    输出：tail connects to node index 0
    解释：链表中有一个环，其尾部连接到第一个节点。

    示例 3：
    输入：head = [1], pos = -1
    输出：no cycle
    解释：链表中没有环。

    进阶：
    你是否可以不用额外空间解决此题？

 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        //双指针slow、fast分别以速度1、2从链表头出发，如果fast走到链表尾两指针都未相遇，则链表无环
        //如果两指针相遇，则链表必有环。设定l=链表头到环起点长度，r=环长度，x=环起点到相遇点长度，显然slow指针再走nr-x步到达环起点
        //推理，fast指针前进步数l+nr+x,slow指针前进步数l+x,根据速度可以判断 l+nr+x = 2(l+x),运算出l=nr-x
        //再设定一个指针entry（其实可以复用fast指针，为便于理解不复用）以速度1从链表头出发
        //slow、entry共同前进l时，entry到达了环起点，slow前进总步数为l+x+l=l+x+nr-x=l+nr,意味着slow也到达了环起点，即slow、entry相遇于环起点

        if(head==null||head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;

        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                //slow为快慢指针的相遇点，现在要推算出环的入口点
                while(slow!=entry){
                    slow = slow.next;
                    entry = entry.next;
                }
                //slow、entry相遇于环起点
                return entry;
            }
        }

        return null;
    }


}
