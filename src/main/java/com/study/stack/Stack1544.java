package com.study.stack;

import java.util.Scanner;

/**
 * @author ZhangHao
 * @version 1.0.0
 * @ClassName Stack1544
 * @Description TODO
 * @createTime 2020年10月29日 21:56:00
 */
public class Stack1544 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(makeGood(s));
    }

    public static String makeGood(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) + 32 == s.charAt(i + 1) || s.charAt(i) - 32 == s.charAt(i + 1)) {
                s = s.substring(0, i) + s.substring(i + 2);
//                若有截取重新遍历
                i = -1;
            }
        }
        return s;
    }

    /**
     * @throws
     * @title makeGood1
     * @description ：扫描大法
     * @author admin
     * @param: s
     * @updateTime 2020/10/30 7:57
     * @return: java.lang.String
     */
    public static String makeGood1(String s) {
        int retIndex = -1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (result.length() > 0 && Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(result.charAt(retIndex)) && result.charAt(retIndex) != s.charAt(i)) {
                result.deleteCharAt(retIndex);
                retIndex--;
            } else {
                result.append(s.charAt(i));
                retIndex++;
            }
        }
        return result.toString();
    }
}
