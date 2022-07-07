package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.7.6
 */
public class Day16Test {

    @Test
    public void test1(){
        Day16Solution solution = new Day16Solution();
        int[] nums = {0,0,1,2,5};
        System.out.println(solution.isStraight(nums));
    }
}

class Day16Solution {

    /**
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     *
     * 示例 1:
     *
     * 输入: [10,2]
     * 输出: "102"
     * 示例 2:
     *
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     *
     * 提示:
     *
     * 0 < nums.length <= 100
     *
     * @param nums -
     * @return -
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    /**
     * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
     * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     *
     * 示例1:
     *
     * 输入: [1,2,3,4,5]
     * 输出: True
     *
     * 示例 2:
     *
     * 输入: [0,0,1,2,5]
     * 输出: True
     *
     * 限制：
     *
     * 数组长度为 5
     *
     * 数组的数取值为 [0, 13] .
     *
     * @param nums -
     * @return -
     */
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCnt = 0;
        int diff = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 0){
                zeroCnt ++;
            }else{
                if(nums[i] == nums[i+1]) {
                    return false;
                }
                if(nums[i] + 1 != nums[i+1]){
                    diff += nums[i+1] - nums[i]-1;
                }
            }
        }
        return zeroCnt >= diff;
    }

    public boolean isStraight1(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = 0;
        int index = 0;
        for (int num : nums) {
            if(num == 0){
                zeroCount ++;
                index ++;
            }else{
                break;
            }
        }

        int start = nums[index++];
        while (index < nums.length) {
            if(start == nums[index]){
                return false;
            }
            if(start != nums[index] - 1){
                if (zeroCount > 0){
                    zeroCount --;
                    start ++;
                }else{
                    return false;
                }
            }else{
                start = nums[index];
                index ++;
            }
        }
        return true;
    }
}