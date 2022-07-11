package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.7.11
 */
public class Day20Test {

    @Test
    public void test1(){}
}


class Day20Solution {

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     *
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * 示例 1:
     *
     * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * Output: [3,9,20,null,null,15,7]
     *
     * 示例 2:
     *
     * Input: preorder = [-1], inorder = [-1]
     * Output: [-1]
     *
     * 限制：
     *
     * 0 <= 节点个数 <= 5000
     *
     * @param preorder -
     * @param inorder -
     * @return -
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

    /**
     * 实现pow(x,n)，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
     *
     * 示例 1：
     *
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     * 示例 2：
     *
     * 输入：x = 2.10000, n = 3
     * 输出：9.26100
     * 示例 3：
     *
     * 输入：x = 2.00000, n = -2
     * 输出：0.25000
     * 解释：2-2 = 1/22 = 1/4 = 0.25
     * 
     *
     * 提示：
     *
     * -100.0 <x< 100.0
     * -231 <= n <=231-1
     * -104 <= xn <= 104
     *
     * @param x -
     * @param n -
     * @return -
     */
    public double myPow(double x, int n) {
        return -1;
    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
     *
     * 参考以下这颗二叉搜索树：
     *
     *      5
     *     / \
     *    2   6
     *   / \
     *  1   3
     * 示例 1：
     *
     * 输入: [1,6,3,2,5]
     * 输出: false
     * 示例 2：
     *
     * 输入: [1,3,2,6,5]
     * 输出: true
     *
     * @param postorder -
     * @return -
     */
    public boolean verifyPostorder(int[] postorder) {
        return false;
    }
}