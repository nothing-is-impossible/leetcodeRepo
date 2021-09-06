package com.study.offer;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 输入：nums = [2,2,3,2]
 * 输出：3
 *
 * @author zh
 */
public class Offer004 {

    public static int singleNumber1(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        int tem = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length-1)
                return nums[i];
            if (tem == nums[i])
                tem = nums[i+=2];
            else {
                result = tem;
                break;
            }
            if (i == nums.length -1) {
                return nums[i];
            }
        }
        return result;
    }


    /**
     * 10001
     * 10001
     * 10001 17
     * 10010 18
     * 00001 1
     * @param nums int数组
     * @return 检索出的特例
     */
    public static int singleNumber2(int[] nums) {
        int answer = 0;
        // 遍历每一位
        for (int i = 0;i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += ((num >> i) & 1);
            }
            sum %= 3;
            answer += (sum << i);
        }
        return answer;

    }

    public static void main(String[] args) {
        int[] num = {0,1,0,1,0,1,99};
        System.out.println(singleNumber1(num));
    }
}
