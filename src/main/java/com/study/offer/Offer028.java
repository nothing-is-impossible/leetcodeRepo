package com.study.offer;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 给定位于列表第一级的头节点，请扁平化列表，即将这样的多级双向链表展平成普通的双向链表，使所有结点出现在单级双链表中。
 *
 * @author zh
 */
public class Offer028 {

    /**
     * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
     * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
     *
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    /**
     * 深度优先遍历
     * @param node
     * @return
     */
    public Node dfs(Node node) {

        Node last = null;
        Node cur = node;
        // 遍历
        while (cur != null) {
            // 记录下一个节点
            Node next = cur.next;
            // 如果孩子节点不空，则对孩子节点做遍历
            if (cur.child != null) {
                // 返回子节点最后一个节点
                Node childLast = dfs(cur.child);
                // 和子节点链接
                cur.next = cur.child;
                cur.child.prev = cur;
                // 如果下一个节点不为空，则和上一个节点子链最后一个节点链接
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }
                // 当前节点子节点置空
                cur.child = null;
                // 最后一个节点就为childLast
                last = childLast;
            }else {
                // 若当前节点无叶节点，那最后一个节点就为自己
                last = cur;
            }
            // 向后遍历
            cur = next;
        }
        // 返回最后一个节点
        return last;
    }

    /**
     * 广度优先遍历
     * @param node
     * @return
     */
    public Node bfs(Node node) {
        throw new NotImplementedException();
    }

}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}
