package com.study.offer;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组nums，判断nums中是否存在三个元素a ，b ，c ，使得a + b + c = 0 ？请找出所有和为 0 且不重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * @author zh
 */
public class Offer007 {
    /**
     * 01，笨比解法：三层for循环穷举法（这里就不写了）
     * 02，优化解法：双指针
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                }else {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;

                    //去重技巧
//                    while (left < right && nums[left] == nums[++left]);
//                    while (left < right && nums[right] == nums[--right]);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static List<List<Integer>> threeSum2(int[] nums) {

        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                }else {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum2(nums));
    }
}
