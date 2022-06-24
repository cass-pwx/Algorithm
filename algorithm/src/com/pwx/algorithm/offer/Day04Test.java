package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.6.24
 */
public class Day04Test {

    @Test
    public void test(){

    }
}


class Solution {
    /**
     * 找出数组中重复的数字。
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * 示例 1：
     *
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     * @param nums -
     * @return -
     */
    public int findRepeatNumber(int[] nums) {
        int length = nums.length;
        if(length < 1){
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    /**
     * 方法2
     * @param nums -
     * @return -
     */
    public int findRepeatNumber2(int[] nums) {
        int[] result = new int[nums.length];
        for (int num : nums) {
            if (result[num] > 0) {
                return num;
            } else {
                result[num]++;
            }
        }
        return -1;
    }

    /**
     * 统计一个数字在排序数组中出现的次数。
     *
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     *
     * 示例2:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: 0
     * @param nums -
     * @param target -
     * @return -
     */
    public int search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.merge(num, 1, Integer::sum);
        }

        return map.get(target) != null ? map.get(target) : 0;
    }

    /**
     * 方法2
     * @param nums -
     * @return -
     */
    public int search2(int[] nums, int target) {
        if(nums.length < 1){
            return 0;
        }
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
            if (num > target) {
                break;
            }
        }

        return count;
    }

    /**
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     *
     * 示例 1:
     *
     * 输入: [0,1,3]
     * 输出: 2
     *
     * 示例 2:
     *
     * 输入: [0,1,2,3,4,5,6,7,9]
     * 输出: 8
     * @param nums -
     * @return -
     */
    public int missingNumber(int[] nums) {
        int length = nums.length;
        if(length < 1){
            return -1;
        }
        int left = 0;
        int right = length - 1;
        while(left < right){
            int mid = (left + right) >> 1;
            if(mid != nums[mid]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left == length -1 && left == nums[left] ? left + 1 : left;
    }

    /**
     * 方法2：利用和算出来
     * @param nums -
     * @return -
     */
    public int missingNumber2(int[] nums) {
        int oriSum = ((nums.length + 1) * nums.length) >> 1;
        int realSum = 0;
        for (int num : nums) {
            realSum += num;
        }
        return oriSum - realSum;
    }
}
