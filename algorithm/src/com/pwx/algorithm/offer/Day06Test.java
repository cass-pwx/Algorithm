package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author 彭伟鑫
 * @date 2022.6.26
 */
public class Day06Test {

    @Test
    public void test1(){
        Day06Solution solution = new Day06Solution();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        solution.levelOrder5(root);
    }

}

class Day06Solution {

    /**
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     *
     * 例如:
     * 给定二叉树:[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回：
     *
     * [3,9,20,15,7]
     *
     * 就是层次遍历，一般用队列
     * @param root -
     * @return -
     */
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.pop();
            list.add(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }


    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     * 例如:
     * 给定二叉树:[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * @param root -
     * @return -
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();

        queue1.add(root);
        while (!queue1.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            while(!queue1.isEmpty()){
                TreeNode node = queue1.pop();
                list.add(node.val);
                if(node.left != null){
                    queue2.add(node.left);
                }
                if(node.right != null){
                    queue2.add(node.right);
                }
                if(queue1.isEmpty()){
                    result.add(list);
                }
            }

            list = new LinkedList<>();
            while(!queue2.isEmpty()){
                TreeNode node = queue2.pop();
                list.add(node.val);
                if(node.left != null){
                    queue1.add(node.left);
                }
                if(node.right != null){
                    queue1.add(node.right);
                }
                if(queue2.isEmpty()){
                    result.add(list);
                }
            }
        }
        return result;
    }


    List<List<Integer>> node=new ArrayList<>();

    /**
     * 方法2：递归
     * @param root -
     * @return -
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        traverse(root,0);
        return node;
    }

    /**
     *
     * @param root -
     * @param level -
     */
    private void traverse(TreeNode root, int level) {
        if(root != null){
            if(node.size() <= level){node.add(new ArrayList<>());}
            node.get(level).add(root.val);
            if(root.left != null){
                traverse(root.left, level + 1);
            }
            if(root.right != null){
                traverse(root.right, level + 1);
            }
        }
    }

    /**
     * 请实现一个函数按照之字形顺序打印二叉树，
     * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     * 例如:
     * 给定二叉树:[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     *
     * @param root -
     * @return -
     */
    public List<List<Integer>> levelOrder4(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.add(root);
        while (!stack1.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            while(!stack1.isEmpty()){
                TreeNode node = stack1.pop();
                list.add(node.val);
                if(node.left != null){
                    stack2.add(node.left);
                }
                if(node.right != null){
                    stack2.add(node.right);
                }
                if(stack1.isEmpty()){
                    result.add(list);
                }
            }

            list = new LinkedList<>();
            while(!stack2.isEmpty()){
                TreeNode node = stack2.pop();
                list.add(node.val);
                if(node.right != null){
                    stack1.add(node.right);
                }
                if(node.left != null){
                    stack1.add(node.left);
                }
                if(stack2.isEmpty()){
                    result.add(list);
                }
            }
        }
        return result;
    }


    /**
     * 方法2
     * @param root -
     * @return -
     */
    public List<List<Integer>> levelOrder5(TreeNode root){
        traverse1(root,0);
        for (int i = 0; i < node.size(); i++) {
            if(i % 2 != 0){
                Collections.reverse(node.get(i));
            }
        }
        return node;
    }

    /**
     *
     * @param root -
     * @param level -
     */
    private void traverse1(TreeNode root, int level) {
        if(root != null){
            if(node.size() <= level){
                node.add(new ArrayList<>());
            }
            node.get(level).add(root.val);
            if(root.left != null){
                traverse1(root.left, level + 1);
            }

            if(root.right != null){
                traverse1(root.right, level + 1);
            }
        }
    }
}
