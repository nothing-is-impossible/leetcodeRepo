package com.study.offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 *
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 *
 * @author zh
 */
public class Offer037 {
    /**
     *
     * 逻辑有问题
     * 2 <= asteroids.length <= 104
     * -1000 <= asteroids[i] <= 1000
     * asteroids[i] != 0
     * 输入：asteroids = [5,10,-5]
     * 输出：[5,10]
     * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty()) {
                stack.push(asteroid);
                continue;
            }
            int tmp = stack.peek();
            if (tmp * asteroid > 0) {
                stack.push(asteroid);
                continue;
            }
            if (Math.abs(tmp) > Math.abs(asteroid)) {
                continue;
            }
            stack.pop();
            while (!stack.isEmpty()) {
                int tmp1 = stack.peek();
                if (tmp1 * asteroid > 0) {
                    break;
                }
                if (Math.abs(tmp1) > Math.abs(asteroid)) {
                    break;
                }
                stack.pop();
            }
        }
        int[] ret = new int[stack.size()];
        for (int i = ret.length - 1; i >= 0; i--) {
            ret[i] = stack.pop();
        }
        return ret;

    }

    public int[] asteroidCollision2(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        int p = 0;
        while (p < asteroids.length) {
            if (s.empty() || s.peek() < 0 || asteroids[p] > 0) {
                s.push(asteroids[p]);
            } else if (s.peek() <= -asteroids[p]) {
                if (s.pop() < -asteroids[p]) {
                    continue;
                }
            }
            p++;
        }
        int[] ret = new int[s.size()];
        for (int i = ret.length - 1; i >= 0; i--) {
            ret[i] = s.pop();
        }
        return ret;
    }
}
