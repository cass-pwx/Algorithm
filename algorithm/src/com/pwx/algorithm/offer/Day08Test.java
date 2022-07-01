package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.6.28
 */
public class Day08Test {

    @Test
    public void test1(){
        Day08Solution solution = new Day08Solution();
        int[] num = {7,1,5,3,6,4};
        solution.maxProfit(num);
    }
}

class Day08Solution {

    private static final Integer MOD = 1000000007;
    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     *
     * F(0) = 0, F(1)= 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：1
     *
     * 示例 2：
     *
     * 输入：n = 5
     * 输出：5
     *
     * @param n -
     * @return -
     */
    public int fib(int n) {
        int p = 0;
        int q = 1;
        int r = 1;
        int i = 0;
        while(i <= n){
            p = q;
            q = r;
            r = (p + q) % MOD;
            i++;
        }
        return p;
    }


    /**
     * 方法二：时间复杂度有点高
     * @param n -
     * @return -
     */
    public int fib1(int n) {
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }


    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 示例 2：
     *
     * 输入：n = 7
     * 输出：21
     * 示例 3：
     *
     * 输入：n = 0
     * 输出：1
     * 提示：
     *
     * 0 <= n <= 100
     *
     * @param n -
     * @return -
     */
    public int numWays(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        int i = 0;
        while(i <= n){
            p = q;
            q = r;
            r = (p + q) % MOD;
            i++;
        }
        return p;
    }


    int maxValue = 0;
    /**
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @param prices -
     * @return -
     */
    public int maxProfit(int[] prices) {
        //归并算法，左边找最小的，右边找最大的
        int length = prices.length;
        if(length == 0){
            return 0;
        }

        find(prices, 0, length - 1);
        return maxValue;
    }

    /**
     * 通过归并算法获取最大值
     * [7,1,5,3,6,4]
     * @param prices -
     * @param left -
     * @param right -
     */
    private void find(int[] prices, int left, int right) {
        if(left >= right){
            return;
        }
        int mid = ((right - left) >> 1) + left;
        find(prices, left, mid);
        find(prices, mid + 1, right);
        int min = getMin(prices, left, mid);
        int max = getMax(prices, mid + 1, right);
        maxValue = Math.max(maxValue, max - min);
    }

    private int getMax(int[] prices, int left, int right) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(max, prices[i]);
        }
        return max;
    }

    private int getMin(int[] prices, int left, int right) {
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, prices[i]);
        }
        return min;
    }


    /**
     * 使用一维数组的动态规划，但是时间太长了。
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        if(prices.length == 0){
            return 0;
        }
        int[] maxValue = new int[length];
        int max = 0;
        for (int i = 0; i < length; i++) {
            int count = prices[i];
            int j = i;
            for (; j < length; j++) {
                int value = prices[j] - count;
                maxValue[j] = Math.max(value, 0);
                max = Math.max(maxValue[j], max);
            }
        }
        return max;
    }


    /**
     * 内存超出限制
     * @param prices -
     * @return -
     */
    public int maxProfit1(int[] prices) {
        int length = prices.length;
        if(prices.length == 0){
            return 0;
        }
        int[][] maxValue = new int[length][length + 1];

        for (int i = 0; i < length; i++) {
            int count = prices[i];
            int max = 0;
            int j = i;
            for (; j < length; j++) {
                int value = prices[j] - count;
                maxValue[i][j] = Math.max(value, 0);
                max = Math.max(value, max);
            }
            maxValue[i][j] = max;
        }

        int max = maxValue[0][length];
        for (int i = 1; i < length; i++) {
            max = Math.max(max, maxValue[i][length]);
        }
        return max;
    }
}
