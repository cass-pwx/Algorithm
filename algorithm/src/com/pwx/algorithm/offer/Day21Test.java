package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.7.11
 */
public class Day21Test {

    @Test
    public void test1() {
        int a = 11;
        Day21Solution solution = new Day21Solution();
        System.out.println(solution.hammingWeight(a));
    }
}

class Day21Solution {

    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
     * 你需要把n当作一个无符号值
     *  
     *
     * 提示：
     *
     * 请注意，在某些语言（如 Java）中，没有无符号整数类型。
     * 在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
     * 在 Java 中，编译器使用 二进制补码 记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
     *  
     *
     * 示例 1：
     *
     * 输入：n = 11 (控制台输入 00000000000000000000000000001011)
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     *
     * 示例 2：
     *
     * 输入：n = 128 (控制台输入 00000000000000000000000010000000)
     * 输出：1
     * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
     *
     * 示例 3：
     *
     * 输入：n = 4294967293 (控制台输入 11111111111111111111111111111101，部分语言中 n = -3）
     * 输出：31
     * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
     *
     *
     * 提示：
     *
     * 输入必须是长度为 32 的 二进制串 。
     *
     * @param n -
     * @return -
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }


    public int hammingWeight1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
     *
     * 示例:
     *
     * 输入: a = 1, b = 1
     * 输出: 2
     *  
     *
     * 提示：
     *
     * a, b 均可能是负数或 0
     * 结果不会溢出 32 位整数
     *
     * @param a -
     * @param b -
     * @return -
     */
    public int add(int a, int b) {
        //无进位时跳出。
        while (b != 0) {
            int c = (a & b) << 1;
            //异或
            a ^= b;
            b = c;
        }
        return a;
    }
}
