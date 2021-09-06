package com.study.offer;

/**
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 剑指offer002
 * 10110
 * 111000
 * @author zh
 */
public class Offer002 {
    public static String addBinary(String a, String b) {
        // 进位标志
        boolean carry = false;
        StringBuilder stringBuilder = new StringBuilder();
        char[] charA = a.length() >= b.length()? a.toCharArray():b.toCharArray();
        char[] charB = a.length() < b.length()? a.toCharArray():b.toCharArray();
        int shortLength = charB.length;
        int longLength = charA.length;
        for (int i = 1; i <= charA.length; i++) {
            if (i <= shortLength) {

                switch ((charA[longLength-i] - '0') + (charB[shortLength-i] - '0')) {
                    case 1 : {
                        if (carry) {
                            stringBuilder.append(0);
                        }else {
                            stringBuilder.append(1);
                            carry = false;
                        }
                        break;
                    }
                    case 0 : {
                        if (carry) {
                            stringBuilder.append(1);
                        }else {
                            stringBuilder.append(0);
                        }
                        carry = false;
                        break;
                    }
                    default: {
                        if (carry) {
                            stringBuilder.append(1);
                        }else {
                            stringBuilder.append(0);
                        }
                        carry = true;
                        break;
                    }
                }
            }else {
                if ((charA[longLength-i] - '0') == 1) {
                    if (carry) {
                        stringBuilder.append(0);
                    }else {
                        stringBuilder.append(1);
                        carry = false;
                    }
                }else {
                    if (carry)
                        stringBuilder.append(1);
                    else
                        stringBuilder.append(0);
                    carry = false;
                }
            }
        }
        if (carry) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1";
        String b= "111";
        System.out.println(addBinary(a, b));
    }
}
