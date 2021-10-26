package com.study.offer;

import java.util.*;

/**
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
 * s and t 仅包含小写字母
 *
 * 注意：若s 和 t中每个字符出现的次数都相同且字符顺序不完全相同，则称s 和 t互为变位词（字母异位词）。
 * @author zh
 */
public class Offer032 {

    /**
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        List<Character> list  = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        boolean ifTranspose = false;
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sChar != tChar) ifTranspose = true;

//            if (map.containsKey(sChar)) {
//                map.put(sChar, map.get(sChar) + 1);
//            }else {
//                map.put(sChar, 1);
//            }
//            if (map.containsKey(tChar)) {
//                map.put(tChar, map.get(tChar) - 1);
//            }else {
//                map.put(tChar, -1);
//            }
            map.put(sChar, map.getOrDefault(sChar, 0) + 1);
            map.put(tChar, map.getOrDefault(tChar, 0) + 1);
        }
        if (!ifTranspose) return false;
        for (Integer count : map.values()) {
            if (count != 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        isAnagram("anagram", "nagaram");
    }
}
