package com.study.offer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *
 *
 * 可以用双向链表加哈希表，哈希表的value存放双向链表的节点
 * @author zh
 */
public class Offer031 {


    private Map<Integer, DoublyListNode> map = new HashMap<>();
    // 头结点
    private DoublyListNode head;
    private int capacity;
    // 尾结点
    private DoublyListNode tail;
    /**
     * 输入
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * 输出
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     *
     * 解释
     * LRUCache lRUCache = new LRUCache(2);
     * lRUCache.put(1, 1); // 缓存是 {1=1}
     * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
     * lRUCache.get(1);    // 返回 1
     * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
     * lRUCache.get(2);    // 返回 -1 (未找到)
     * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
     * lRUCache.get(1);    // 返回 -1 (未找到)
     * lRUCache.get(3);    // 返回 3
     * lRUCache.get(4);    // 返回 4
     *
     * @param capacity
     */
    public Offer031(int capacity) {
        this.capacity = capacity;
        head = new DoublyListNode(-1, -1);
        tail = new DoublyListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DoublyListNode node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoublyListNode node = map.get(key);
            node.value = value;
//            DoublyListNode tmp = node.prev;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
//            tail.next = node;
//            node.prev = tail;
//            tail = node;
            return;
        }
        // 若容量已经满了，删掉头部节点
        if (map.size() == capacity) {
            DoublyListNode node = head.next;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            map.remove(node.key);
        }
        DoublyListNode node = new DoublyListNode(key, value);
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        map.put(key, node);
    }
}

/**
 * 双向链表
 */
class DoublyListNode{

    DoublyListNode (int key, int value) {
        this.key = key;
        this.value = value;
    }

    int value;
    DoublyListNode prev;
    DoublyListNode next;
    int key;


}
