package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.7.12
 */
public class Day22Test {

    @Test
    public void test1(){}
}

class Day22Solution {

    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
     * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
     *
     * 示例 1：
     *
     * 输入：nums = [4,1,4,6]
     * 输出：[1,6] 或 [6,1]
     *
     * 示例 2：
     *
     * 输入：nums = [1,2,10,4,1,4,3,3]
     * 输出：[2,10] 或 [10,2]
     *  
     *
     * 限制：
     *
     * 2 <= nums.length <= 10000
     *
     * @param nums -
     * @return -
     */
    public int[] singleNumbers(int[] nums) {
        return new int[0];
    }

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。
     * 请找出那个只出现一次的数字。
     *
     * 示例 1：
     *
     * 输入：nums = [3,4,3,3]
     * 输出：4
     *
     * 示例 2：
     *
     * 输入：nums = [9,1,7,9,7,9,7]
     * 输出：1
     *
     * 限制：
     *
     * 1 <= nums.length <= 10000
     * 1 <= nums[i] < 2^31
     *
     * @param nums -
     * @return -
     */
    public int singleNumber(int[] nums) {
        return -1;
    }
}
