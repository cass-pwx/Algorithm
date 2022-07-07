package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.7.7
 */
public class Day17Test {

    @Test
    public void test1(){
        Day17Solution solution = new Day17Solution();
        int[] nums = {4,5,1,6,2,7,3,8};
        solution.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}


class Day17Solution {

    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。
     * 例如，输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
     *
     * 示例 1：
     *
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     *
     * 示例 2：
     *
     * 输入：arr = [0,1,2,1], k = 1
     * 输出：[0]
     *
     * 限制：
     *
     * 0 <= k <= arr.length <= 10000
     * 0 <= arr[i] <= 10000
     *
     * @param arr -
     * @param k -
     * @return -
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        int[] result = new int[k];
        if(arr.length == 0 || k == 0) {
            return result;
        }
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    /**
     * 插入排序
     * 4,5,1,6,2,7,3,8
     * @param a -
     */
    public void insertSort(int[] a) {
        int left = 0;
        int length = a.length;
        if(length == 0){
            return;
        }
        for (int i = left, j = i; i < length - 1; j = ++i) {
            int ai = a[i + 1];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if (j-- == left) {
                    break;
                }
            }
            a[j + 1] = ai;
        }
    }

    /**
     * 冒泡排序
     * 4,5,1,6,2,7,3,8
     * @param a -
     */
    public void bubbleSort(int[] a){
        int length = a.length;
        if(length == 0){
            return;
        }

        for (int i = 0; i < length; i++) {
            boolean flag = true;
            for (int j = i + 1; j < length; j++) {
                if(a[i] > a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    flag = false;
                }
            }
            if(flag){
                return;
            }
        }
    }

    /**
     * 选择排序
     * 4,5,1,6,2,7,3,8
     * @param a -
     */
    public void selectionSort(int[] a){
        int length = a.length;
        if(length == 0){
            return;
        }
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i; j < length; j++) {
                if(a[min] > a[j]){
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    /**
     * 归并排序
     * 4,5,1,6,2,7,3,8
     * @param a -
     */
    public void mergeSort(int[] a){
        int length = a.length;
        if(length == 0){
            return;
        }
        int left = 0;
        int right = length - 1;
        sort(a, left, right);
    }

    private void sort(int[] a, int left, int right) {
        if(left >= right){
            return;
        }
        int mid = ((right - left) >> 1) + left;
        sort(a, left, mid);
        sort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private void merge(int[] a, int left, int mid, int right) {
        int p = left;
        int q = mid + 1;
        int[] c = new int[right - left + 1];
        int index = 0;
        while(p <= mid && q <= right){
            if(a[p] < a[q]){
                c[index] = a[p];
                index ++;
                p ++;
            }else{
                c[index] = a[q];
                index ++;
                q ++;
            }
        }
        while (p <= mid){
            c[index++] = a[p++];
        }

        while (q <= right){
            c[index++] = a[q++];
        }

        for (int j : c) {
            a[left++] = j;
        }
    }

    /**
     * 快速排序
     * 4,5,1,6,2,7,3,8
     * @param a -
     */
    public void quickSort(int[] a){
        int length = a.length;
        if(length == 0){
            return;
        }
        quickSort(a, 0, length - 1);
    }

    private void quickSort(int[] a, int left, int right) {
        if(left >= right){
            return;
        }
        int partition = partition(a, left, right);
        quickSort(a, left, partition - 1);
        quickSort(a, partition, right);
    }

    private int partition(int[] a, int left, int right) {
        //这个值的取法有很多中，这里选择最简单的一种
        int partition = a[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if(a[j] < partition){
                int temp = a[i];
                a[i++] = a[j];
                a[j] = temp;
            }
        }
        a[right] = a[i];
        a[i] = partition;
        return i;
    }

}

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 *
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 *
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *
 *
 * 限制：
 *
 * 最多会对 addNum,findMedian 进行 50000 次调用。
 *
 *  * Your MedianFinder object will be instantiated and called as such:
 *  * MedianFinder obj = new MedianFinder();
 *  * obj.addNum(num);
 *  * double param_2 = obj.findMedian();
 */
class MedianFinder {
    /**
     * 小顶堆，保存较大的一半
     */
    Queue<Integer> A;
    /**
     * 大顶堆，保存较小的一半
     */
    Queue<Integer> B;

    public MedianFinder() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}


class MedianFinder1 {

    List<Integer> list;

    /**
     * initialize your data structure here.
     */
    public MedianFinder1() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        list.sort(Integer::compareTo);
        int size = list.size();
        if (size % 2 == 0) {
            size = (size - 1) >> 1;
            return (double) (list.get(size) + list.get(size + 1)) / 2;
        } else {
            return (double) list.get(size >> 1);
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}