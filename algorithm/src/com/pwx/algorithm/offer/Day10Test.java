package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.6.30
 */
public class Day10Test {

    @Test
    public void test1(){

    }
}


class Day10Solution {

    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     *
     * 示例 1:
     *
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     *
     * 提示：
     *      0 <= num < 2的31
     *
     * @param num -
     * @return -
     */
    public int translateNum(int num) {
        //这里和斐波那契差不多，不过要加一个判断，如果两位的时候，超出25，那就不算了。
        if(num == 0){
            return 1;
        }
        List<Integer> reNumList = new ArrayList<>();
        while(num > 0){
            reNumList.add(num % 10);
            num = num % 10;
        }
        int[] nums = new int[reNumList.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = reNumList.get(nums.length - 1 - i);
        }

        return -1;
    }

    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     *
     *
     * 示例1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
     *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
     *
     * @param s -
     * @return -
     */
    public int lengthOfLongestSubstring(String s) {
        return -1;
    }
}