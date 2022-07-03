package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

/**
 * @author 彭伟鑫
 * @date 2022.7.3
 */
public class Day13Test {

    @Test
    public void test(){
        Day13Solution solution = new Day13Solution();
        int[] nums = {1, 2, 3, 4};
        solution.exchange(nums);
    }
}

class Day13Solution {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     *
     * 示例：
     *
     * 输入：nums =[1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     *
     * @param nums -
     * @return -
     */
    public int[] exchange(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return nums;
        }
        int evenStart = length - 1;
        int i = 0;
        while (i < evenStart) {
            if (nums[i] % 2 == 0) {
                numChange(nums, i, evenStart);
                evenStart--;
            } else {
                i++;
            }
        }
        return nums;
    }

    private void numChange(int[] nums, int i, int evenStart) {
        int num = nums[i];
        nums[i] = nums[evenStart];
        nums[evenStart] = num;
    }

    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[2,7] 或者 [7,2]
     * 示例 2：
     * <p>
     * 输入：nums = [10,26,30,31,47,60], target = 40
     * 输出：[10,30] 或者 [30,10]
     * 1 <= nums.length <= 10^5
     *
     * @param nums   -
     * @param target -
     * @return -
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        if (length <= 2) {
            return nums;
        }
        int[] sums = new int[2];
        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                sums[0] = nums[left];
                sums[1] = nums[right];
                return sums;
            }
        }
        return sums;
    }


    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
     * 例如输入字符串"I am a student. "，则输出"student. a am I"。
     *
     *
     * 示例 1：
     *
     * 输入: "the sky is blue"
     * 输出:"blue is sky the"
     * 示例 2：
     *
     * 输入: " hello world! "
     * 输出:"world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 示例 3：
     *
     * 输入: "a good  example"
     * 输出:"example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     * 说明：
     *
     * 无空格字符构成一个单词。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     * @param s -
     * @return -
     */
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if ("".equals(arr[i])) {
                continue;
            }
            //到头了，append然后去空格
            if (i == 0) {
                result.append(arr[i].trim());
            } else {
                // 怕有多余的空格，去掉，再加上去
                result.append(arr[i].trim()).append(" ");
            }
        }
        return result.toString();
    }
}
