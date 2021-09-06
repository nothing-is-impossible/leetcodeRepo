package com.study.offer;

/**
 *
 * 给定一个字符串数组words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 *
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]m,
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 *
 * @author zh
 */
public class Offer005 {
    public static int maxProduct(String[] words) {
        char[] str1;
        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // 默认没有共同字符
                boolean flag = true;
                str1 = words[i].toCharArray();
                for (char tem : str1) {
                    if (words[j].contains(String.valueOf(tem))) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    answer = Math.max(answer, str1.length * words[j].length());
            }
        }
        return answer;
    }

    public int maxProduct2(String[] words) {
        //1、将words的每个单词中字母是否出现记录到二维数组中
        boolean[][] falgs = new boolean[words.length][26];
        for (int i = 0; i<words.length; i++) {
            for (char c : words[i].toCharArray()) {
                falgs[i][c - 'a'] = true;
            }
        }
        //2、判断每对单词是否有相同字符
        int result = 0;
        for(int i = 0; i < words.length; i++){
            for (int j = i + 1; j < words.length; j++) {
                int k = 0;
                for (; k < 26; k++) {
                    if (falgs[i][k] && falgs[j][k]) {
                        break;
                    }
                }
                if (k == 26) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result,prod);
                }
            }
        }
        return result;
    }
    public int maxProduct3(String[] words) {
        //1、使用二进制的26位记录每个单词中26个字母的出现情况，1为出现
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char ch: words[i].toCharArray()) {
                flags[i] |= 1 << (ch - 'a');
            }
        }
        //2、两个单词如果有相同字母，则对应的整数与运算后相同字母对应的数位为1,结果不为0；没有相同字母则结果为0
        int result = 0;
        for(int i = 0; i < words.length; i++){
            for (int j = i + 1; j < words.length; j++) {
                if((flags[i] & flags[j]) == 0) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result,prod);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[]  words = {"a","ab","abc","d","cd","bcd","abcd"};
        System.out.println(maxProduct(words));
    }
}
