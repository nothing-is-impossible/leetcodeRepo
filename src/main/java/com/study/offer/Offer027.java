package com.study.offer;

import java.util.List;

/**
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 *
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 * @author zh
 */
public class Offer027 {

    /**
     * 输入: head = [1,2,3,3,2,1]
     * 输出: true
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode slow = prev, fast = prev;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode after = slow.next;
        slow.next = null;
        ListNode revertList = revert(after);
        ListNode cur = prev.next;
        while (revertList != null) {
            if (cur.val != revertList.val) {
                return false;
            }
            cur = cur.next;
            revertList = revertList.next;
        }
        return true;
    }

    private ListNode revert(ListNode source) {
        ListNode cur = source, prev = null;
        while (cur != null && cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev.next;
    }
}
