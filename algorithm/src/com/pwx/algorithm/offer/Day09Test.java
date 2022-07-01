package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

/**
 * @author 彭伟鑫
 * @date 2022.6.29
 */
public class Day09Test {

    @Test
    public void test1(){
        Day09Solution solution = new Day09Solution();
        int[][] nums =
                {
                        {1,3,1},
                        {1,5,1},
                        {4,2,1}
                };
        System.out.println(solution.maxValue(nums));
    }
}

class Day09Solution {

    /**
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     *
     * 要求时间复杂度为O(n)。
     *
     * 示例1:
     *
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
     *
     * @param nums -
     * @return -
     */
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0){
                index = i;
                break;
            }
        }
        //从第一个正数开始
        int count = 0;
        int max = nums[0];
        for (int i = index; i < length; i++) {
            count += nums[i];
            max = Math.max(max, count);
            if(count < 0){
                count = 0;
            }
        }
        return max;
    }

    /**
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
     * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
     * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     *
     *
     * 示例 1:
     *
     * 输入:
     * [
     *  [1,3,1],
     *  [1,5,1],
     *  [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     *
     * @param grid -
     * @return -
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        if(m == 0){
            return 0;
        }
        int n = grid[0].length;
        int[][] maxValue = new int[m][n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += grid[0][i];
            maxValue[0][i] = count;
        }

        count = 0;
        for (int i = 0; i < m; i++) {
            count += grid[i][0];
            maxValue[i][0] = count;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                maxValue[i][j] = Math.max(maxValue[i-1][j], maxValue[i][j-1]) + grid[i][j];
            }
        }
        return maxValue[m-1][n-1];
    }


    /**
     * 用一维数组
     * @param grid -
     * @return -
     */
    public int maxValue1(int[][] grid) {
        int m = grid.length;
        if(m == 0){
            return 0;
        }
        int n = grid[0].length;
        int[] maxValue = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += grid[0][i];
            maxValue[i] = count;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j == 0){
                    maxValue[j] = maxValue[j] + grid[i][j];
                }else {
                    maxValue[j] = Math.max(maxValue[j], maxValue[j - 1]) + grid[i][j];
                }
            }
        }
        return maxValue[n-1];
    }
}