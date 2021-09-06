package com.study.offer;

/**
 * 给定一个已按照升序排列的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0开始计数 ，所以答案数组应当满足 0<= answer[0] < answer[1] <numbers.length。
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 *
 * 输入：numbers = [1,2,4,6,10], target = 8
 * 输出：[1,3]
 * 解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
 *
 * @author zh
 */
public class Offer006 {

    /**
     * 【-9，-4，-2，0，2，4】 -7
     * 菜鸡做法，且未考虑正负
     * stupid method
     * @param numbers 数组
     * @param target 目标数
     * @return 结果数组
     */
    public int[] twoSum1(int[] numbers, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] * 2 > target) {
                break;
            }
            for (int j = i + 1; j < numbers.length; j++) {
                if (Math.abs(numbers[j]) > Math.abs(target))
                    break;
                if(numbers[i] + numbers[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }

    public int[] twoSum2(int[] numbers, int target) {
        if (numbers == numbers || numbers.length == 0)
            return new int[0];
        int left = 0;
        int right = numbers.length-1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left, right};
            }else if (sum < target) {
                left ++;
            }else {
                right ++;
            }
        }
        return new int[0];
    }
}
