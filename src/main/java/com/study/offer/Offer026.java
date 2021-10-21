package com.study.offer;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0→ L1→ … → Ln-1→ Ln
 * 请将其重新排列后变为：
 *
 * L0→Ln→L1→Ln-1→L2→Ln-2→ …
 *
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 */
public class Offer026 {

    /**
     * 输入: head = [1,2,3,4]
     * 输出: [1,4,2,3]
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode pre = new ListNode();
        ListNode slow = pre;
        ListNode quick = pre;
        pre.next = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode afterList = slow.next;
        ListNode beforeList = head;
        slow.next = null;
        ListNode revertAfterList= revertListNode(afterList);
        ListNode cur = beforeList;
        while (revertAfterList != null) {
            ListNode tmp = cur.next;
//            ListNode tmpA = revertAfterList.next;
            cur.next = revertAfterList;
            cur = cur.next;
            revertAfterList = revertAfterList.next;
            cur.next = tmp;
            cur = cur.next;
        }
    }
//    ListNode pre = new ListNode();
//    ListNode slow = pre;
//    ListNode fast = pre;
//    pre.next = head;
//        while (fast != null && fast.next != null) {
//        slow = slow.next;
//        fast = fast.next.next;
//    }
//    ListNode half = slow.next;
//    slow.next = null;
//    ListNode rev_half = this.revertListNode(half);
//    ListNode cur = pre.next;
//        while (rev_half != null) {
//        ListNode tmp = cur.next;
//        cur.next = rev_half;
//        cur = cur.next;
//        rev_half = rev_half.next;
//        cur.next = tmp;
//        cur = cur.next;
//    }

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
