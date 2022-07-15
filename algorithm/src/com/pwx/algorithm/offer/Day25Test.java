package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

/**
 * @author 彭伟鑫
 * @date 2022.7.15
 */
public class Day25Test {

    @Test
    public void test1() {
    }
}

class Day25Solution {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     * <p>
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     * <p>
     * <p>
     * 限制：
     * <p>
     * 0 <= matrix.length <= 100
     * 0 <= matrix[i].length <= 100
     *
     * @param matrix -
     * @return -
     */
    public int[] spiralOrder(int[][] matrix) {
        int[] result = new int[0];
        return result;
    }

    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
     * <p>
     * 示例 1：
     * <p>
     * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * 输出：true
     * 解释：我们可以按以下顺序执行：
     * push(1), push(2), push(3), push(4), pop() -> 4,
     * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     * <p>
     * 示例 2：
     * <p>
     * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
     * 输出：false
     * 解释：1 不能在 2 之前弹出。
     * <p>
     * 提示：
     * <p>
     * 0 <= pushed.length == popped.length <= 1000
     * 0 <= pushed[i], popped[i] < 1000
     * pushed 是 popped 的排列。
     *
     * @param pushed -
     * @param popped -
     * @return -
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        return false;
    }
}
