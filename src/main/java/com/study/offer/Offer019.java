package com.study.offer;

/**
 *
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 * s由小写英文字母组成
 * @author zh
 */
public class Offer019 {

    /**
     *
     * 错误答案，不长脑子，瞎几把写
     * 输入: s = "abca"
     * 输出: true
     * 解释: 可以删除 "c" 字符 或者 "b" 字符
     * @param s 字符串s
     * @return 是否能得到一个回文
     */
    public static boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        boolean flag = true;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                if (!flag) {
                    return false;
                }
                if (s.charAt(start + 1) == s.charAt(end)) {
                    if (s.charAt(start + 2) == s.charAt(end-1)) {
                        start++;
                    }else if (s.charAt(start) == s.charAt(end - 1)) {
                        end--;
                    }
                    else {
                        return false;
                    }
                }
                else if (s.charAt(start) == s.charAt(end - 1)) {
                    end--;
                }
                else {
                    return false;
                }
                flag = false;
                continue;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean validPalindrome2(String s) {
        int[] idx = new int[2];
        int mid = s.length() / 2;
        idx = check(s, 0, s.length() - 1);
        if (idx[0] > mid) {
            return true;
        }
        return check(s, idx[0] + 1, idx[1])[0] > mid || check(s, idx[0], idx[1] - 1)[0] == mid;
    }

    private int[] check(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            } else {
                l++;
                r--;
            }
        }
        return new int[]{l, r};
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aguokepatgbnvfqmgml cupuu fxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxf uupucu lmgmqfvnbgtapekouga"));
    }
}
