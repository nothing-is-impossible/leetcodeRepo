package com.study.offer;

/**
 * 给定两个 非空链表 l1和 l2来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *
 * @author zh
 */
public class Offer025 {
    /**
     * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
     * 输出：[7,8,0,7]
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp1 = revertListNode(l1);
        ListNode tmp2 = revertListNode(l2);
        int count = 0;
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (tmp1 != null || tmp2 != null || count != 0) {
            int num = 0;
            if (tmp1 != null) {
                num += tmp1.val;
                tmp1 = tmp1.next;
            }
            if (tmp2 != null) {
                num += tmp2.val;
                tmp2 = tmp2.next;
            }
            num += count;
            count = num >= 10 ? 1 : 0;
            cur.next = new ListNode(num - count * 10);
            cur = cur.next;
        }
        return this.revertListNode(result.next);
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    private ListNode revertListNode(ListNode head) {
        ListNode prevNode = null, curNode = head;
        while (curNode != null) {
            ListNode tmpNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = tmpNode;
        }
        return prevNode;
    }
}
