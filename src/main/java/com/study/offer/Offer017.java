package com.study.offer;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和t 。返回 s 中包含t的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
 *
 * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
 *
 *
 *
 * 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * @author zh
 */
public class Offer017 {
    /**
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C'
     *
     * @param s 字符串
     * @param t 字符串
     * @return 最短字符串
     */
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // t中不同字符的个数
        int count = map.size();
        int start = 0, end = 0;

        int minStart = 0, minEnd = 0;
        int minLength = Integer.MAX_VALUE;
        while (end < s.length() || (count == 0 && end == s.length())) {
            // 大于0操作尾部
            if (count > 0) {
                char endChar = s.charAt(end);
                if (map.containsKey(endChar)) {
                    map.put(endChar, map.get(endChar) - 1);
                    if (map.get(endChar) == 0) {
                        count--;
                    }
                }
                end++;
            }
            // 否则操作头部缩小范围
            else {
                if (end - start < minLength) {
                    minLength = end - start;
                    minStart = start;
                    minEnd = end;
                }
                char startChar = s.charAt(start);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) == 1) {
                        count++;
                    }
                }
                start ++;
            }
        }
        return minLength < Integer.MAX_VALUE ? s.substring(minStart, minEnd) : "";
    }
}
