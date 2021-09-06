package com.study.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhangHao
 * @version 1.0.0
 * @ClassName Stack1002
 * @Description 查找常用字符
 * @createTime 2020年10月14日 22:00:00
 */
public class Stack1002 {
    public static void main(String[] args) {
        String[] A = {"bella","label","roller"};
        String[] B = {"cool","lock","cook"};
        System.out.println(commonChars01(A));
    }
    /**
     * @title commonChars01
     * @description 自己的方法
     * @author admin
     * @param: A
     * @updateTime 2020/10/15 8:26
     * @return: java.util.List<java.lang.String>
     * @throws
     */
    public static List<String> commonChars01(String[] A) {
        String longestString = "";
        List<String> resultList = new ArrayList<>();
        boolean flag = true;
        for (String s : A) {
            if(s.length() > longestString.length())
                longestString = s;
        }
        for (int i = 0; i < longestString.length(); i++) {
            for (String s : A) {
                if (!s.contains(longestString.substring(i,i+1))) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                for (int j = 0; j< A.length; j++) {
                    A[j] = A[j].replaceFirst(longestString.substring(i,i+1), "");
                }
                resultList.add(longestString.substring(i,i+1));
            }else {
                flag = true;
            }
        }
        return resultList;
    }
    /**
     * @title commonChars02
     * @description 官方的方法
     * @author admin
     * @param: A
     * @updateTime 2020/10/15 8:26
     * @return: java.util.List<java.lang.String>
     * @throws
     */
    public static List<String> commonChars02(String[] A) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
//        遍历A数组
        for (String array : A) {
            int[] freq = new int[26];
//            遍历每个数组
            for (int i = 0; i < array.length(); i++) {
//                统计每个字符出现的次数
                char ch = array.charAt(i);
                ++freq[ch - 'a'];
            }
//            每个字符出现的最小次数存放minFreq中
            for (int i = 0; i < 26; i++) {
//                注意这里，如果下个字符串没有出现此字符，那么minFreq中此字符个数会被更新为0
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }
        List<String> resultList = new ArrayList<>();
//            结果进行处理
        for (int i = 0; i < 26; i++) {
//                出现几次写入几次，同时未出现的则跳过
            for (int j = 0; j < minFreq[i]; j++) {
                resultList.add(String.valueOf((char)(i + 'a')));
            }
        }
        return resultList;
    }
}
