package com.study.offer;

/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * @author zh
 */
public class Offer008 {

    /**
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * @param target 正整数target
     * @param nums 数组
     * @return 返回结果
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, total = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            total += nums[right];
            while (total >= target) {
                result = Math.min(result, right - left + 1);
                total -= nums[left++];
            }
        }
        return result > nums.length ? 0: result;
    }
}
