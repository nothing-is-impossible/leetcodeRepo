package com.study.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * @author zh
 */
public class Offer011 {
    /**
     * [1001010101010]
     * 输入: nums = [0,1,0]
     * 输出: 2
     * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
     * @param nums 二进制数组
     * @return 子数组长度
     */
    public static int findMaxLength(int[] nums) {
        // 结果
        int result = 0;
        //前缀和
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                // 再次出现这个和，说明他们之间的0,1个数相同
                result = Math.max(result, i - map.get(sum));
            }else {
                map.put(sum, i);
            }
        }
        return result;
    }
}
