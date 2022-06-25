package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.6.25
 */
public class Day05Test {

    @Test
    public void test1(){
        Day05Solution solution = new Day05Solution();
        System.out.println(solution.firstUniqChar2("adaccbeff"));
    }

}

class Day05Solution {

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * 示例:
     *
     * 现有矩阵 matrix 如下：
     *
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target=5，返回true。
     *
     * 给定target=20，返回false。
     *
     * 限制：
     * 0 <= n <= 1000
     * 0 <= m <= 1000
     * @param matrix 矩阵
     * @param target -
     * @return -
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length < 1){
            return false;
        }
        int m = matrix[0].length;
        int n = matrix.length;
        int p = m - 1;
        int q = 0;
        while(p >= 0 && q < n){
            if(matrix[q][p] < target){
                q ++;
            }else if(matrix[q][p] > target){
                p --;
            }else{
                return true;
            }
        }
        return false;
    }


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     *
     * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
     * 请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
     *
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     *
     * 示例 1：
     *
     * 输入：numbers = [3,4,5,1,2]
     * 输出：1
     *
     * 示例 2：
     *
     * 输入：numbers = [2,2,2,0,1]
     * 输出：0
     * @param numbers -
     * @return -
     */
    public int minArray(int[] numbers) {
        int length = numbers.length;
        if(length < 1){
            return -1;
        }
        if(length == 1){
            return numbers[0];
        }
        for (int i = 0; i < length - 1; i++) {
            if(numbers[i] > numbers[i+1]){
                return numbers[i+1];
            }
        }
        return numbers[0];
    }

    /**
     * 方法2：使用2分法（有序）
     * @param numbers -
     * @return -
     */
    public int minArray2(int[] numbers) {
        if(numbers.length < 1){
            return -1;
        }
        return binarySearch(numbers);
    }

    private int binarySearch(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int mid = (left + right) >> 1;
            //如果中间值小于最右边的值，这证明右边是有序的,那这时候最小值一定在左边
            if(numbers[mid] < numbers[right]){
                right = mid ;
            }else if(numbers[mid] > numbers[right]){
                //如果中间的值大于最右边的值，那么说明中间有一个最小值
                left = mid + 1;
            }else {
                //这里有一种情况 [3,3,1,3] [2,3,0,1,1,1,1]
                //这时候要去重
                right --;
            }
        }
        return numbers[left];
    }


    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * 示例 1:
     *
     * 输入：s = "abaccdeff"
     * 输出：'b'
     * 示例 2:
     *
     * 输入：s = ""
     * 输出：' '
     *
     * 限制：
     *
     * 0 <= s 的长度 <= 50000
     * @param s -
     * @return -
     */
    public char firstUniqChar(String s) {
        int length = s.length();
        if (length < 1){
            return ' ';
        }
        //用于记录出现的先后
        int orderIndex = 0;
        char[] order = new char[26];
        //总共有128个字符
        int[] arr = new int[26];
        for(char a : s.toCharArray()){
            int index = a - 'a';
            if(arr[index] == 0){
                order[orderIndex++] = a;
            }
            arr[index] ++;
        }

        for(char p : order){
            if(p == '\u0000'){
                break;
            }
            int index = p - 'a';
            if(arr[index] == 1){
                return p;
            }
        }
        return ' ';
    }


    public char firstUniqChar2(String s) {
        int length = s.length();
        if (length < 1){
            return ' ';
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(char a : s.toCharArray()){
            if(map.get(a) != null){
                map.merge(a, 1, Integer::sum);
            }else{
                map.put(a, 1);
            }
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if(characterIntegerEntry.getValue() == 1){
                return characterIntegerEntry.getKey();
            }
        }
        return ' ';
    }
}