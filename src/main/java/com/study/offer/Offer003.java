package com.study.offer;

/**
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 * <p>
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 * @author zh
 */
public class Offer003 {
    public static int[] countBits01(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            String temBinaryString = Integer.toBinaryString(i);
            String s = temBinaryString.replaceAll("1", "");
            result[i] = temBinaryString.length() - s.length();
        }
        return result;
    }

    /**
     * 0 0
     * 2 10
     * 4 100
     * 6 110
     * 8 1000
     * <p>
     * 1 1
     * 3 11
     * 5 101
     * 7 111
     * 9 1001
     *
     * @param n 参数
     * @return 结果
     */
    public static int[] countBits02(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            // 如果是偶数，最后一位肯定是0，所以结果可以变成算当前数/2后1的个数
            if (i % 2 == 0) {
                result[i] = result[i >> 1];
            }else {
                result[i] = result[i - 1] + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = countBits02(5);
        for (int i : ints)
            System.out.println(i);
    }
}
