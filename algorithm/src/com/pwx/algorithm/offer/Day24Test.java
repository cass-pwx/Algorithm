package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

/**
 * @author 彭伟鑫#A04154
 * @data 2022.7.14
 */
public class Day24Test {

    @Test
    public void test1(){}
}


class Day24Solution {

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
     * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     *
     * 示例 1：
     *
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1
     *
     * 示例 2:
     *
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     *
     * 提示：
     *      2 <= n <= 58
     *
     * @param n -
     * @return -
     */
    public int cuttingRope(int n) {
        return -1;
    }

    /**
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     *
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     *
     * 示例 1：
     *
     * 输入：target = 9
     * 输出：[[2,3,4],[4,5]]
     *
     * 示例 2：
     *
     * 输入：target = 15
     * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
     *
     * 限制：
     *
     * 1 <= target <= 10^5
     *
     * @param target -
     * @return -
     */
    public int[][] findContinuousSequence(int target) {
        return new int[0][0];
    }

    /**
     * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
     *
     * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
     *
     * 示例 1：
     *
     * 输入: n = 5, m = 3
     * 输出: 3
     *
     * 示例 2：
     *
     * 输入: n = 10, m = 17
     * 输出: 2
     *
     * 限制：
     *
     * 1 <= n <= 10^5
     * 1 <= m <= 10^6
     *
     * @param n -
     * @param m -
     * @return -
     */
    public int lastRemaining(int n, int m) {
        return -1;
    }
}