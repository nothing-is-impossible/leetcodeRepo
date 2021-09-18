package com.study.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 *
 * @author zh
 */
public class Offer016 {
    /**
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
     *
     * @param s 字符创
     * @return 无重复字符的最长子串
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0, right = 0;
        for (; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
                map.put(s.charAt(right), right);
            } else {
                map.put(s.charAt(right), right);
                result = Math.max((right - left) + 1, result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
