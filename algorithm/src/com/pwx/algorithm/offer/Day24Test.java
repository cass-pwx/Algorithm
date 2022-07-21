package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 彭伟鑫#A04154
 * @data 2022.7.14
 */
public class Day24Test {

    @Test
    public void test1(){
        Day24Solution solution = new Day24Solution();
        System.out.println(solution.cuttingRope(3));
        System.out.println(Arrays.deepToString(solution.findContinuousSequence1(9)));
        System.out.println(solution.lastRemaining(9, 13));
    }
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
     * 输出: 364
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     *
     * 提示：
     *      2 <= n <= 58
     *
     * @param n -
     * @return -
     */
    public int cuttingRope(int n) {
        if(n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if(b == 0) {
            return (int)Math.pow(3, a);
        }
        if(b == 1) {
            return (int)Math.pow(3, a - 1) * 4;
        }
        return (int)Math.pow(3, a) * 2;
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
     * 示例 3：
     *
     * 输入：target = 6
     * 输出：[[1,2,3]]
     *
     * 限制：
     *
     * 1 <= target <= 10^5
     *
     * @param target -
     * @return -
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<>();
        for (int l = 1, r = 2; l < r;) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    public int[][] findContinuousSequence1(int target) {
        int length = target >> 1;
        List<int[]> list = new ArrayList<>();
        int right = length + 1;
        while(right > 1){
            int left = right - 1;
            int count = 0;
            count += right;
            while(count < target && left > 0){
                count += left;
                left --;
            }
            if(count < target){
                break;
            }
            if(count == target){
                int[] arr = getArr(left + 1, right);
                list.add(arr);
            }
            right --;
        }
        int[][] result = new int[list.size()][];
        int index = list.size() - 1;
        for (int[] arr : list) {
            result[index--] = arr;
        }
        return result;
    }

    private int[] getArr(int left, int right) {
        int[] result = new int[right - left + 1];
        int index = 0;
        for (int i = left; i <= right; i++) {
            result[index++] = i;
        }
        return result;
    }

    int num = -1;
    /**
     * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
     * 求出这个圆圈里剩下的最后一个数字。
     * 约瑟夫环
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
    public int lastRemaining3(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    public int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        return f;
    }

    /**
     * 超时了
     * @param n -
     * @param m -
     * @return -
     */
    public int lastRemaining2(int n, int m) {
        if(n == 1){
            return 1;
        }
        //LinkedList在删除的时候很快，但是在remove定位到节点的时候很慢
        //ArrayList在定位很快，但是要移动元素
        //但是因为ArrayList是连续空间拷贝，所以相比于LinkedList大量非连续性地址访问，ArrayList的性能是很 OK 的！
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < n){
            list.add(i++);
        }
        int start = 0;
        while(list.size() > 1){
            int index = (start + m - 1) % list.size();
            list.remove(index);
            start = index % list.size();
        }
        return list.get(0);
    }
}