package com.study.offer;

/**
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 * @author zh
 */
public class Offer024 {
    /**
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode tmp = head, prior = null;
        while (tmp != null) {
            ListNode next = tmp.next;
            tmp.next = prior;
            prior = tmp;
            tmp = next;
        }
        return prior;
    }
}
