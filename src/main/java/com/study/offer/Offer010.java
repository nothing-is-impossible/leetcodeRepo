package com.study.offer;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 * @author zh
 */
public class Offer010 {
    /**
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2
     * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
     *
     * 分析：有负数不适合滑动窗口
     * 选择前缀和的解法
     *
     * @param nums 数组
     * @param k 目标数
     * @return 连续子数组个数
     */
    public static int subarraySum(int[] nums, int k) {
        int result = 0, pre_sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        for (int i : nums) {
            pre_sum += i;
            result += hashMap.getOrDefault(pre_sum - k, 0);
            hashMap.put(pre_sum, hashMap.getOrDefault(pre_sum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        subarraySum(new int[]{1,2,3}, 3);
    }
}
