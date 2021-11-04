package com.study.offer;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求该后缀表达式的计算结果。
 * <p>
 * 有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * @author zh
 */
public class Offer036 {

    /**
     * 输入：tokens = ["2","1","+","3","*"]
     * 输出：9
     * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            switch (str) {
                case "+": {
                    Integer op1 = stack.pop();
                    Integer op2 = stack.pop();
                    stack.push(op1 + op2);
                    break;
                }
                case "-": {
                    Integer op1 = stack.pop();
                    Integer op2 = stack.pop();
                    stack.push(op2 - op1);
                    break;
                }

                case "*": {
                    Integer op1 = stack.pop();
                    Integer op2 = stack.pop();
                    stack.push(op1 * op2);
                    break;
                }

                case "/": {
                    Integer op1 = stack.pop();
                    Integer op2 = stack.pop();
                    stack.push(op2 / op1);
                    break;
                } default: {
                    stack.push(Integer.parseInt(str));
                    break;
                }
            }
        }
        return stack.peek();
    }
}
