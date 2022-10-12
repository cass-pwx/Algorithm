package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 彭伟鑫
 * @date 2022.7.18
 */
public class Day28Test {

    @Test
    public void test1() {
        Day28Solution solution = new Day28Solution();
        String s = "suvyls";
        System.out.println(solution.permutation1(s).length);
    }

}

class Day28Solution {

    List<String> rec;
    boolean[] vis;

    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * <p>
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     * <p>
     * 示例:
     * <p>
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     * <p>
     * 限制：
     * <p>
     * 1 <= s 的长度 <= 8
     *
     * @param s -
     * @return -
     */
    public String[] permutation(String s) {
        int n = s.length();
        rec = new ArrayList<>();
        vis = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuffer perm = new StringBuffer();
        backtrack(arr, 0, n, perm);
        int size = rec.size();
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = rec.get(i);
        }
        return recArr;
    }

    public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        if (i == n) {
            rec.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }
            vis[j] = true;
            perm.append(arr[j]);
            backtrack(arr, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            vis[j] = false;
        }
    }

    public String[] permutation1(String s) {
        List<String> ret = new ArrayList<>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        do {
            ret.add(new String(arr));
        } while (nextPermutation(arr));
        int size = ret.size();
        String[] retArr = new String[size];
        for (int i = 0; i < size; i++) {
            retArr[i] = ret.get(i);
        }
        return retArr;
    }

    public boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = arr.length - 1;
        while (j >= 0 && arr[i] >= arr[j]) {
            j--;
        }
        swap(arr, i, j);
        reverse(arr, i + 1);
        return true;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(char[] arr, int start) {
        int left = start, right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
}

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 */
class Codec {

    /**
     * Encodes a tree to a single string.
     *
     * @param root -
     * @return -
     */
    public String serialize(TreeNode root) {
        return null;
    }

    /**
     * Decodes your encoded data to tree.
     *
     * @param data -
     * @return -
     */
    public TreeNode deserialize(String data) {
        return null;
    }
}
