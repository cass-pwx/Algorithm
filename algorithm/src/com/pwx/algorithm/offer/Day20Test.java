package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.7.11
 */
public class Day20Test {

    @Test
    public void test1(){
        Day20Solution solution = new Day20Solution();
    }
}


class Day20Solution {

    private Map<Integer, Integer> indexMap;
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
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft,
                                int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        // 在中序遍历中定位根节点
        int inorderRoot = indexMap.get(preorder[preorderLeft]);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        // 得到左子树中的节点数目
        int sizeLeftSubtree = inorderRoot - inorderLeft;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorderLeft + 1, preorderLeft + sizeLeftSubtree, inorderLeft, inorderRoot - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorderLeft + sizeLeftSubtree + 1, preorderRight, inorderRoot + 1, inorderRight);
        return root;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
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
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = Math.abs(n);
        }
        return f(x, n);
    }

    private double f(double x, int n) {
        if(n == 0){
            return 1;
        }
        double temp = f(x, n / 2);
        return (n % 2 == 0 ? 1 : x) * temp * temp;
    }


    public double f1(double x, int n) {
        double r = 1;
        double base = x;
        while(n != 0){
            if(n % 2 != 0){
                r *= base;
            }
            base *= base;
            n /= 2;
        }
        return r;
    }

    public double myPow1(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = Math.abs(n);
        }
        double count = x;
        for (int i = 2; i <= n; i++) {
            count *= x;
        }
        return count;
    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
     * 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
     *
     * 参考以下这颗二叉搜索树：
     *
     *      5
     *     / \
     *    2   6
     *   / \
     *  1   3
     *
     * 示例 1：
     *
     * 输入: [1,6,3,2,5]
     * 输出: false
     *
     * 示例 2：
     *
     * 输入: [1,3,2,6,5]
     * 输出: true
     *
     * @param postorder -
     * @return -
     */
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }


    public boolean verifyPostorder1(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    /**
     * 划分左右子树： 遍历后序遍历的 [i, j][i,j] 区间元素，寻找 第一个大于根节点 的节点，索引记为 m 。
     * 此时，可划分出左子树区间 [i,m-1][i,m−1] 、右子树区间 [m, j - 1][m,j−1] 、根节点索引 j
     *
     * @param postorder -
     * @param i         -
     * @param j         -
     * @return -
     */
    boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}