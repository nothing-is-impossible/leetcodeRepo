package com.study.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * @author zh
 */
public class Offer035 {

    /**
     * 输入：timePoints = ["23:59","00:00"]
     * 输出：1
     *
     * 2 <= timePoints <= 2 * 104
     * timePoints[i] 格式为 "HH:MM"
     * @param timePoints
     * @return
     */
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minuteList = new ArrayList<>();
        for (String time : timePoints) {
            String[] str = time.split(":");
            minuteList.add(Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]));
        }
        Collections.sort(minuteList);
        minuteList.add(minuteList.get(0) + 24 * 60);
        int res = 24 * 60;
        for (int i = 1; i< minuteList.size(); i++) {
            res = Math.min(res, minuteList.get(i) - minuteList.get(i - 1));
        }
        return res;
    }
}
