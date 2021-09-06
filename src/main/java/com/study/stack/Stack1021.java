package com.study.stack;

import java.util.Scanner;
import java.util.Stack;

public class Stack1021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        System.out.println(removeOuterParenthesesNo2(S));
    }
    /**
     * @title removeOuterParenthesesNo2
     * @description 借助栈的写法
     * @author admin
     * @param: S
     * @updateTime 2020/9/22 8:38
     * @return: java.lang.String
     * @throws
     */
    public static String removeOuterParenthesesNo2(String S) {
        int start = 0,end = 0;
        StringBuilder result = new StringBuilder();
//        标记栈
        Stack stack = new Stack();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push(S.charAt(i));
            }else {
                stack.pop();
            }
            if (stack.empty()) {
                if(start + 1 < end)
                    result.append(S.substring(start + 1,end));
                start = i + 1;
            }
            end++;
        }
        return result.toString();
    }
    /**
     * @title removeOuterParentheses
     * @description 不借助栈的写法
     * @author admin
     * @param: S
     * @updateTime 2020/9/22 8:37
     * @return: java.lang.String
     * @throws
     */
    public static String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        int flag = 0;
        for (char i: S.toCharArray()) {
            if (i == '(') {
                flag++;
            }
            if (flag >=2 ) {
                result.append(i);
            }
            if (i == ')') {
                flag--;
            }
        }
        return result.toString();
    }
    /**
     * @title removeOuterParentheses
     * @description 此方法只能返回输入字符串的内层括号组合，不符合题意
     * @author admin
     * @param: S
     * @updateTime 2020/9/21 22:57
     * @return: java.lang.String
     * @throws
     */
    public static String removeOuterParenthesesNo1(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
//            若栈不空或者字符串不为空
            while (!"".equals(S) || !stack.empty()) {
                char mark = S.charAt(i);
                S = S.substring(i+1);
                if ('(' == mark) {
                    stack.push(mark);
                }else {
                    stack.pop();
                    if(!stack.empty()) {
                        result.append("()");
                    }else {
                        continue;
                    }
                }
            }
        }
        return result.toString();
    }

}
