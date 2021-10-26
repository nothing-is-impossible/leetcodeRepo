package com.study.offer;

import java.util.*;

/**
 * 给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。
 *
 * 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。
 * @author zh
 */
public class Offer033 {

    /**
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String k = new String(chars);
            if (!map.containsKey(k)) {
                map.put(k, new ArrayList<>());
            }
            map.get(k).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
