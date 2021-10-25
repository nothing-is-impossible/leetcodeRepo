package com.study.offer;

import java.util.*;

/**
 * 设计一个支持在平均时间复杂度 O(1)下，执行以下操作的数据结构：
 * <p>
 * insert(val)：当元素 val 不存在时返回 true，并向集合中插入该项，否则返回 false 。
 * remove(val)：当元素 val 存在时返回 true，并从集合中移除该项，否则返回 false。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 *
 * @author zh
 */
public class Offer030 {

    /** Initialize your data structure here. */
    /**
     * 输入: inputs = ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
     * [[], [1], [2], [2], [], [1], [2], []]
     * 输出: [null, true, false, true, 2, true, false, 2]
     * 解释:
     * RandomizedSet randomSet = new RandomizedSet();  // 初始化一个空的集合
     * randomSet.insert(1); // 向集合中插入 1 ， 返回 true 表示 1 被成功地插入
     * <p>
     * randomSet.remove(2); // 返回 false，表示集合中不存在 2
     * <p>
     * randomSet.insert(2); // 向集合中插入 2 返回 true ，集合现在包含 [1,2]
     * <p>
     * randomSet.getRandom(); // getRandom 应随机返回 1 或 2
     * <p>
     * randomSet.remove(1); // 从集合中移除 1 返回 true 。集合现在包含 [2]
     * <p>
     * randomSet.insert(2); // 2 已在集合中，所以返回 false
     * <p>
     * randomSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2
     */

    private List<Integer> valList = new ArrayList<>();
    private Map<Integer, Integer> valMap = new HashMap<>();
    private Random random = new Random();

    public Offer030() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valMap.containsKey(val)) return false;
        valList.add(val);
        valMap.put(val, valList.size() - 1);
        return true;
    }

    /**
     * tmd , 好好给我看看set和add的区别，这都能忘？再犯这种低级错误自断一腿
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!valMap.containsKey(val)) return false;
        int index = valMap.get(val);
        int lastVal = valList.get(valList.size() - 1);
        valList.set(index, lastVal);
        valMap.put(lastVal, index);
        valMap.remove(val);
        valList.remove(valList.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int randomIndex = random.nextInt(valList.size());
        return valList.get(randomIndex);
    }
}
