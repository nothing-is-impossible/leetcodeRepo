package com.study.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串s和p，找到s中所有 p 的变位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 变位词 指字母相同，但排列不同的字符串。
 *
 */
public class Offer015 {
    /**
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
     *
     * @param s 第一个字符创
     * @param p 第二个字符串
     * @return 返回结果
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < p.length(); i++) {
            arr1[s.charAt(i) - 'a']++;
            arr2[p.charAt(i) - 'a']++;
        }

        for (int i = p.length(); i < s.length(); i++) {
            if (Arrays.equals(arr1, arr2)) {
                result.add(i - p.length());
            }
            arr1[s.charAt(i) - 'a']++;
            arr1[s.charAt(i - p.length()) - 'a']--;
        }
        if (Arrays.equals(arr1, arr2)) {
            result.add(s.length() - p.length());
        }
        return result;
    }
}
