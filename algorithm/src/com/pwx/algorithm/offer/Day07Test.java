package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.6.27
 */
public class Day07Test {

    @Test
    public void test(){

    }
}


class Day07Solution {

    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     *
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     *
     * 例如:
     * 给定的树 A:
     *
     *     3
     *    / \
     *   4   5
     *  / \
     * 1   2
     * 给定的树 B：
     *
     *    4
     *   /
     *  1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     *
     * 示例 1：
     *
     * 输入：A = [1,2,3], B = [3,1]
     * 输出：false
     * 示例 2：
     *
     * 输入：A = [3,4,5,1,2], B = [4,1]
     * 输出：true
     * @param A 父树
     * @param B 子树
     * @return -
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return false;
    }


    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     *
     * 例如输入：
     *
     *      4
     *    /  \
     *   2   7
     *  / \  / \
     * 1  3 6  9
     * 镜像输出：
     *
     *      4
     *    /  \
     *   7   2
     *  / \  / \
     * 9  6 3 1
     *
     * 
     *
     * 示例 1：
     *
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     *
     * @param root -
     * @return -
     */
    public TreeNode mirrorTree(TreeNode root) {
        return null;
    }

    /**
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     *
     * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
     *
     *   1
     *  / \
     *  2  2
     * / \ / \
     * 3 4 4 3
     * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *   1
     *  / \
     *  2  2
     *  \  \
     *  3  3
     *
     * 
     *
     * 示例 1：
     *
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     *
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     *
     * @param root -
     * @return -
     */
    public boolean isSymmetric(TreeNode root) {
        return false;
    }
}