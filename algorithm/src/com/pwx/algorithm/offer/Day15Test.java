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
        /**
         *       1
         *      /\
         *    -2 -3
         *    /\  /
         *   1 3 -2
         *  /
         * -1
         */
        TreeNode root = new TreeNode(1, new TreeNode(-2, new TreeNode(1, new TreeNode(-1), null), new TreeNode(3)), new TreeNode(-3, new TreeNode(-2), null));
        System.out.println(solution.pathSum(root, -1));
    }

    @Test
    public void test2() {
        Day15Solution.Node root = new Day15Solution.Node(4,
                new Day15Solution.Node(2,
                        new Day15Solution.Node(1), new Day15Solution.Node(3)),
                new Day15Solution.Node(5)
        );
        Day15Solution solution = new Day15Solution();
        solution.treeToDoublyList(root);
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

        if (count + root.val != target || root.left != null || root.right != null) {
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
        if (root == null) {
            return null;
        }
        Node dummyHead = new Node(-1);
        List<Node> list = new ArrayList<>();
        find(list, root);
        build(list, dummyHead);
        return dummyHead.right;
    }

    private void build(List<Node> list, Node dummyHead) {
        Node head = dummyHead;
        for (Node node : list) {
            head.right = node;
            node.left = head;
            head = head.right;
        }
        head.right = dummyHead.right;
        dummyHead.right.left = head;
    }

    private void find(List<Node> list, Node root) {
        if (root == null) {
            return;
        }
        find(list, root.left);
        list.add(root);
        find(list, root.right);
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
        if (root == null) {
            return -1;
        }
        List<TreeNode> list = new ArrayList<>();
        find(list, root);
        int size = list.size();
        return list.get(size - k).val;
    }

    private void find(List<TreeNode> list, TreeNode root) {
        if (root == null) {
            return;
        }
        find(list, root.left);
        list.add(root);
        find(list, root.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


