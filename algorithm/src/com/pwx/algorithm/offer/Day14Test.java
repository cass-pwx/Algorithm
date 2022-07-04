package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.7.4
 */
public class Day14Test {

    @Test
    public void test1(){
        Day14Solution solution = new Day14Solution();
        char[][] board =
                {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}
                };
        System.out.println(solution.exist(board, "ABCCED"));
    }

    @Test
    public void test2(){
        Day14Solution solution = new Day14Solution();
        System.out.println(solution.movingCount(16, 8, 4));
    }
}


class Day14Solution {

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     *
     * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
     *
     * 示例 1：
     *
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * 示例 2：
     *
     * 输入：board = [["a","b"],["c","d"]], word = "abcd"
     * 输出：false
     *
     * 1 <= board.length <= 200
     * 1 <= board[i].length <= 200
     * 
     * @param board -
     * @param word -
     * @return -
     */
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        if(m * n<word.length()) {
            return false;
        }
        int index = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(index) && find(i, j, word, index, visited, board)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(int i, int j, String word ,int index, boolean[][] visited, char[][] board) {
        if(i < 0 || j < 0|| i >= board.length || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if(board[i][j] == word.charAt(index) ){
            if(index == word.length()-1){
                return true;
            }else{
                visited[i][j] = true;
                boolean res = find(i+1, j, word, index+1, visited, board)
                        || find(i-1, j, word, index+1, visited, board)
                        || find(i, j-1, word, index+1, visited, board)
                        || find(i, j+1, word, index+1, visited, board);
                visited[i][j] = false;
                return res;
            }
        }
        return false;
    }

    private int count = 0;
    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
     * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     *
     * 示例 1：
     *
     * 输入：m = 2, n = 3, k = 1
     * 输出：3
     * 示例 2：
     *
     * 输入：m = 3, n = 1, k = 0
     * 输出：1
     * 1 <= n,m <= 100
     * 0 <= k <= 20
     *
     * @param m -
     * @param n -
     * @param k -
     * @return -
     */
    public int movingCount(int m, int n, int k) {
        if(k == 0){
            return 1;
        }
        boolean[][] isVisited = new boolean[m][n];
        find(0, m, 0, n, k, isVisited);
        return count;
    }

    private void find(int p, int m, int q, int n, int k, boolean[][] isVisited) {
        if(p >= m || q >= n || p < 0 || q < 0 || isVisited[p][q]){
            return;
        }
        isVisited[p][q] = true;
        int num = get(p) + get(q);

        if (num <= k){
            count ++;
            find(p + 1, m, q, n, k, isVisited);
            find(p - 1, m, q, n, k, isVisited);
            find(p, m, q + 1, n, k, isVisited);
            find(p, m, q - 1, n, k, isVisited);
        }
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}