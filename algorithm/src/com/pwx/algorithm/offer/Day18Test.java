package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.7.8
 */
public class Day18Test {

    @Test
    public void test1(){}
}

class Day18Solution {

    int maxLevel;
    /**
     * 输入一棵二叉树的根节点，求该树的深度。
     * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
     *
     * 例如：
     *
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     *
     * @param root -
     * @return -
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int level = 1;
        maxLevel = level;
        getDepth(root, level);
        return maxLevel;
    }

    private void getDepth(TreeNode root, int level) {
        if (root == null){
            return;
        }
        maxLevel = Math.max(level, maxLevel);
        if (root.left != null){
            getDepth(root.left, level + 1);
        }

        if (root.right != null){
            getDepth(root.right, level + 1);
        }
    }

    boolean flag = true;
    /**
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
     * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     *
     * 示例 1:
     *
     * 给定二叉树 [3,9,20,null,null,15,7]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     *
     * 示例 2:
     *
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *
     *        1
     *       / \
     *      2   2
     *     / \
     *    3   3
     *   / \
     *  4   4
     * 返回 false 。
     *
     * @param root -
     * @return -
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }



    public boolean isBalanced2(TreeNode root) {
        if(root == null) {
            return true;
        }
        return Math.abs(height1(root.left) - height1(root.right)) <= 1 && isBalanced2(root.left) && isBalanced2(root.right);
    }

    private int height1(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(height1(root.left), height1(root.right)) + 1;
    }


    public boolean isBalanced1(TreeNode root) {
        if(root == null) {
            return true;
        }
        posOrder(root);
        return flag;
    }

    private void posOrder(TreeNode root) {
        if(root == null){
            return;
        }
        posOrder(root.left);
        posOrder(root.right);
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1){
            flag = false;
        }
    }
}

