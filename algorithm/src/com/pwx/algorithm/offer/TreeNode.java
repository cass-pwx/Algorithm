package com.pwx.algorithm.offer;

import java.util.Objects;

/**
 * 树节点
 * @author 彭伟鑫#A04154
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int x) { val = x; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if(Objects.isNull(o) || o.getClass() != TreeNode.class){
            return false;
        }
        TreeNode node = (TreeNode) o;
        return this.val == node.val;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}