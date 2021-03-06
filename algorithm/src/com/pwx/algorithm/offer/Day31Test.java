package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.7.21
 */
public class Day31Test {

    @Test
    public void test1(){}
}

class Day31Solution {

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
     * 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
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
     *
     * 2 <= n <= 1000
     *
     * @param n -
     * @return -
     */
    public int cuttingRope(int n) {
        return -1;
    }

    /**
     * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
     *
     * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
     *
     * 示例 1：
     *
     * 输入：n = 12
     * 输出：5
     *
     * 示例 2：
     *
     * 输入：n = 13
     * 输出：6
     *
     * 限制：
     *
     * 1 <= n < 2^31
     *
     * @param n -
     * @return -
     */
    public int countDigitOne(int n) {
        return -1;
    }

    /**
     * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
     * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
     *
     * 请写一个函数，求任意第n位对应的数字。
     *
     * 示例 1：
     *
     * 输入：n = 3
     * 输出：3
     *
     * 示例 2：
     *
     * 输入：n = 11
     * 输出：0
     *  
     *
     * 限制：
     *
     * 0 <= n < 2^31
     *
     * @param n -
     * @return -
     */
    public int findNthDigit(int n) {
        return -1;
    }
}
