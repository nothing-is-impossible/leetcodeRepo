package com.study.offer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 *
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *
 * @author zh
 */
public class Offer034 {

    /**
     * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
     * 输出：true
     * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
     *
     * 写的什么鸡扒玩意，好好看看题，把意思给弄明白了再写！！！！沙雕！！！！！！！
     *
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSortedWrong(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++)
            map.put(order.charAt(i), i);
        // 前一个字符串的长度
        int prevWordLength = 0;
        for (String word : words) {
            if (word.length() < prevWordLength) return false;
            prevWordLength = word.length();
        }
        // 遍历每个字符串比较大小
        for (int i = 0; i< prevWordLength; i++) {
            int prevLength = -1;
            for (String word : words) {
                if (word.length()-1 < i) continue;
                if (map.get(word.charAt(i)) < prevLength) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isAlienSortedRight(String[] words, String order) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++)
            map.put(order.charAt(i), i);
        // 遍历每个字符串比较大小
        for (int i = 0; i< words.length; i++) {
            String left = words[i];
            int left_len = left.length();
            String right = words[i + 1];
            int right_len = right.length();
            for (int j = 0; j < Math.max(left_len, right_len); j++) {
                int ch_left = j >= left_len ? -1 : map.get(left.charAt(j));
                int ch_right = j >= right_len ? -1 : map.get(right.charAt(j));
                if (ch_left > ch_right) return false;
                if (ch_left < ch_right) break;
             }
        }
        return true;
    }
}
