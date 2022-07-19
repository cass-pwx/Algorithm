package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.7.14
 */
public class Day23Test {

    @Test
    public void test1(){}
}

class Day23Solution {

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 示例 1:
     *
     * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
     * 输出: 2
     *
     * 限制：
     *
     * 1 <= 数组长度 <= 50000
     *
     * @param nums -
     * @return -
     */
    public int majorityElement(int[] nums) {
        //Boyer-Moore 投票算法
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement3(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }

    /**
     * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
     * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法(输入数组中出现 0)。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3,4,5]
     * 输出: [120,60,40,30,24]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 所有元素乘积之和不会溢出 32 位整数
     * a.length <= 100000
     *
     * @param a -
     * @return -
     */
    public int[] constructArr(int[] a) {
        int length = a.length;
        int[] answer = new int[length];
        if (length < 1) {
            return answer;
        }
        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = a[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= a[i];
        }
        return answer;
    }

    public int[] constructArr1(int[] a) {
        int length = a.length;
        int[] result = new int[length];
        if (length < 1) {
            return result;
        }
        int[] left = new int[length];
        left[0] = 1;
        int[] right = new int[length];
        right[length - 1] = 1;

        for (int i = 1; i < left.length; i++) {
            left[i] = a[i - 1] * left[i - 1];
        }

        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        for (int i = 0; i < a.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}
