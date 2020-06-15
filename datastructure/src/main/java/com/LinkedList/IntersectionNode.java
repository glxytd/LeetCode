package com.LinkedList;

import java.util.LinkedList;
import java.util.List;

/*相交链表
      编写一个程序，找到两个单链表相交的起始节点。
      示例 1：
      输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
      输出：Reference of the node with value = 8
      输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。

      示例 2：
      输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
      输出：Reference of the node with value = 2
      输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。

      示例 3：
      输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
      输出：null
      输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
      解释：这两个链表不相交，因此返回 null。

      注意：
      如果两个链表没有交点，返回 null.
      在返回结果后，两个链表仍须保持原有的结构。
      可假定整个链表结构中没有循环。
      程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */

public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //双指针分别从A,B链表头以速度1出发，A指针走到链表A尾则指向B链表头，B指针走到链表B尾则指向A链表头
        //如果两链表不相交，则A指针走到B链表尾，B指针走到A链表尾，尾尾相等(都为null)
        //如果两链表相交，则双指针共同走过AB链表重复部分，显然双指针相遇点即双链表交点
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    
}
