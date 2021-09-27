package com.study.offer;

/**
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 本题中，将空字符串定义为有效的 回文串 。
 * @author zh
 */
public class Offer018 {
    /**
     * 输入: s = "A man, a plan, a canal: Panama"
     * 输出: true
     * 解释："amanaplanacanalpanama" 是回文串
     *
     * @param s 字符串s
     * @return 是否是回文串
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;
        while (start < end) {

            // 可以优化Character.isLetterOrDigit();
            if (!((s.charAt(start) >= 48 && s.charAt(start) <=57) || (s.charAt(start) >= 97 && s.charAt(start) <=122))) {
                start++;
                continue;
            }
            if (!((s.charAt(end) >= 48 && s.charAt(end) <=57) || (s.charAt(end) >= 97 && s.charAt(end) <=122))) {
                end--;
                continue;
            }
            // 可以优化Character.toLowerCase();
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
