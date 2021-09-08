package com.study.offer;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 * @author zh
 */
public class Offer009 {
    /**
     * 输入: nums = [10,5,2,6], k = 100
     * 输出: 8
     * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
     * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
     *
     * 错误方法
     * @param nums 正整数数组
     * @param k 目标值
     * @return 连续子数组个数
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int result = 0, right = 0, total = nums[0];
        for (int start = 0; start < nums.length; start++) {
            while (total < k && right < nums.length-1) {
                total *= nums[++right];
            }
            total /= nums[right];
            total /= nums[start];
            result += (right - start);
        }
        return result;
    }

    /**
     * 输入: nums = [10,5,2,6], k = 100
     * 输出: 8
     * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
     * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
     *
     * 正确方法
     * @param nums 正整数数组
     * @param k 目标值
     * @return 连续子数组个数
     */
    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int left = 0, right = 0, total = 1, result = 0;
        while (right < nums.length) {
            total *= nums[right];
            while (total >= k) {
                total /= nums[left++];
            }
            result += (right - left + 1);
            ++right;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK2(nums, k));
    }
}
