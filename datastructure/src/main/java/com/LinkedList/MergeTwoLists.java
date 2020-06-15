package com.LinkedList;

/*合并两个有序链表
    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    示例：
    输入：1->2->4, 1->3->4
    输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //双指针分别从两个链表头节点出发以速度1前进，依此比较两个指针所在节点的值，较小的值被串联起来，对应指针前进一步。直到前进到短链表的尾节点，直接串联长链表的剩余节点
        ListNode mergeHead = new ListNode(-1);
        ListNode merge = mergeHead;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                merge.next = l1;
                l1=l1.next;
            }else{
                merge.next = l2;
                l2=l2.next;
            }
            merge = merge.next;
        }

        merge.next = l1!=null?l1:l2;
        return mergeHead.next;

    }
}
