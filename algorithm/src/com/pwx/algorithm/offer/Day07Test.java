package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.6.27
 */
public class Day07Test {

    @Test
    public void test(){
        //[2,3,2,1]
        //[3,null,2,2]
        Day07Solution solution = new Day07Solution();
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node2.left = node3;

        TreeNode childRoot = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(2);
        childRoot.right = node4;
        node4.left = node5;
        System.out.println(solution.isSubStructure(root, childRoot));
    }
}


class Day07Solution {

    /**
     * 输入两棵二叉树 A和 B，判断 B 是不是 A 的子结构。(约定空树不是任意一个树的子结构)
     *
     * B 是 A 的子结构， 即 A 中有出现和 B 相同的结构和节点值。
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
     *
     * 示例 2：
     *
     * 输入：A = [3,4,5,1,2], B = [4,1]
     * 输出：true
     * @param A 父树
     * @param B 子树
     * @return -
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null){
            return false;
        }
        return false;
    }

    /**
     * 这里不能直接转成数组再进行对比，无论前中后序都不成立
     * 放在这里只是作为参照
     * @param A -
     * @param B -
     * @return -
     */
    public boolean isSubStructure1(TreeNode A, TreeNode B) {
        if(B == null){
            return false;
        }
        List<Integer> oriList = new ArrayList<>();
        List<Integer> childList = new ArrayList<>();
        //这里使用后序遍历
        posTraversal(A, oriList);
        posTraversal(B, childList);
        for (int i = 0; i < oriList.size() - childList.size(); i++) {
            List<Integer> subOriList = oriList.subList(i, i + childList.size());
            int q = 0;
            while(q < childList.size()){
                if(subOriList.get(q).equals(childList.get(q))){
                    q ++;
                }else{
                    break;
                }
            }
            if(q == childList.size()){
                return true;
            }
        }
        return false;
    }

    /**
     * 后序遍历
     * @param root -
     * @param list -
     */
    private void posTraversal(TreeNode root, List<Integer> list) {
        if(root.left != null){
            posTraversal(root.left, list);
        }

        if(root.right != null){
            posTraversal(root.right, list);
        }

        list.add(root.val);
    }

    /**
     * 先序遍历
     * @param root -
     * @param list -
     */
    private void preTraversal(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if(root.left != null){
            posTraversal(root.left, list);
        }

        if(root.right != null){
            posTraversal(root.right, list);
        }
    }

    /**
     * 中序遍历
     * @param root -
     * @param list -
     */
    private void midTraversal(TreeNode root, List<Integer> list) {

        if(root.left != null){
            posTraversal(root.left, list);
        }

        list.add(root.val);
        if(root.right != null){
            posTraversal(root.right, list);
        }
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