package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.7.4
 */
public class Day15Test {

    @Test
    public void test1(){
        Day15Solution solution = new Day15Solution();
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        System.out.println(solution.pathSum(root, 22));
    }
}

class Day15Solution {

    private List<List<Integer>> list;

    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     *
     * 叶子节点 是指没有子节点的节点。
     *
     * 示例 1：
     *
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：[[5,4,11,2],[5,8,4,5]]
     *
     * 示例 2：
     *
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：[]
     *
     * 示例 3：
     *
     * 输入：root = [1,2], targetSum = 0
     * 输出：[]
     *
     * 提示：
     *
     * 树中节点总数在范围 [0, 5000] 内
     * -1000 <= Node.val <= 1000
     * -1000 <= targetSum <= 1000
     *
     * @param root -
     * @param target -
     * @return -
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null){
            return Collections.emptyList();
        }
        list = new ArrayList<>();
        List<Integer> pathList = new LinkedList<>();
        find(pathList, target, root, 0);
        return list;
    }

    private void find(List<Integer> pathList, int target, TreeNode root, int count) {
        if(root == null){
            return;
        }

        if(count + root.val == target && root.left == null && root.right == null) {
            List<Integer> path = new ArrayList<>(pathList);
            path.add(root.val);
            list.add(path);
            return;
        }

        if(count + root.val != target) {
            List<Integer> path = new ArrayList<>(pathList);
            path.add(root.val);
            find(path, target, root.left, count + root.val);
            find(path, target, root.right, count + root.val);
        }
    }


    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     *
     * 为了让您更好地理解问题，以下面的二叉搜索树为例：
     *
     * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
     *
     * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
     *
     * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
     *
     * @param root -
     * @return -
     */
    public Node treeToDoublyList(Node root) {
        return null;
    }


    /**
     * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
     *
     * 示例 1:
     *
     * 输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *   2
     * 输出: 4
     *
     * 示例 2:
     *
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * 输出: 4
     *
     * 限制：
     *
     * 1 ≤ k ≤ 二叉搜索树元素个数
     *
     * @param root -
     * @param k -
     * @return -
     */
    public int kthLargest(TreeNode root, int k) {
        return -1;
    }
}

