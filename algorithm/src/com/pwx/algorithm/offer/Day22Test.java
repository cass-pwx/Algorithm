package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.7.12
 */
public class Day22Test {

    @Test
    public void test1(){
        Day22Solution solution = new Day22Solution();
        int[] a = {1,2,4,1,4,3,3};
        int[] b = {4,1,4,6};
        int[] c = {4,3,4,4};
        System.out.println(solution.getSingleNumber(a));
        System.out.println(Arrays.toString(solution.singleNumbers(b)));
        System.out.println(solution.singleNumber1(c));
    }
}

class Day22Solution {

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了两次。 请找出那个只出现一次的数字。
     * 这时候我们只需要执行一次全员异或就可以了
     */
    public int getSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

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
     * 先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
     *
     * 在异或结果中找到任意为 1 的位。
     *
     * 根据这一位对所有的数字进行分组。
     *
     * 在每个组内进行异或操作，得到两个数字。
     *
     * @param nums -
     * @return -
     */
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
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
     * https://www.cnblogs.com/MyStringIsNotNull/p/12585218.html
     *
     * @param nums -
     * @return -
     */
    public int singleNumber(int[] nums) {
        //由于二进制只能表示 0, 10,1 ，
        // 因此需要使用两个二进制位来表示 3 个状态。
        // 设此两位分别为 two , one
        int ones = 0;
        int twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public int singleNumber1(int[] nums) {
        if(nums==null||nums.length==0) {
            return 0;
        }
        int result = 0;
        for(int i = 0; i < 32; i++){
            //统计该位1的出现次数情况
            int count = 0;
            int index = 1<<i;
            for(int j : nums){
                //该位与操作后的结果不为0，则表示该位为1的情况出现了
                if((index & j) != 0){
                    count++;
                }
            }
            //该位上出现1的次数mod3后为1，表示出现一次的数字该位为1
            if(count%3==1){
                result |= index;
            }
        }
        return result;
    }

}
