package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.6.30
 */
public class Day10Test {

    @Test
    public void test1(){
        Day10Solution solution = new Day10Solution();
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
    }
}


class Day10Solution {

    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     *
     * 示例 1:
     *
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     *
     * 提示：
     *      0 <= num < 2的31
     *
     * @param num -
     * @return -
     */
    public int translateNum(int num) {
        //这里和斐波那契差不多，不过要加一个判断，如果两位的时候，超出25，那就不算了。
        if(num == 0){
            return 1;
        }
        List<Integer> reNumList = new ArrayList<>();
        while(num > 0){
            reNumList.add(num % 10);
            num = num / 10;
        }
        int[] nums = new int[reNumList.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = reNumList.get(nums.length - 1 - i);
        }
        return fib(nums);
    }

    /**
     * 斐波那契
     * @param nums -
     * @return -
     */
    private int fib(int[] nums) {
        int p ;
        int q = 1;
        int r = 1;
        int i = 1;
        while(i < nums.length){
            p = q;
            q = r;
            if(nums[i-1] != 0 && nums[i-1] * 10 + nums[i] < 26){
                r = p + q;
            }else{
                r = q;
            }
            i ++;
        }
        return r;
    }

    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     *
     * 示例1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
     *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
     *
     * @param s -
     * @return -
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int[] appear = new int[128];
        int left = 0;
        int right = 0;
        int maxLength = 1;
        while(right < s.length()){
            if(appear[s.charAt(right)] == 0){
                appear[s.charAt(right)]++;
                maxLength = Math.max(maxLength,right-left+1);
                right++;
            }
            else{
                appear[s.charAt(right)]++;
                while(appear[s.charAt(right)] > 1){
                    appear[s.charAt(left)]--;
                    left++;
                }
                right++;
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring3(String s) {
        int len = 0;

        Set<Character> set = new HashSet<>();
        for(int l = 0, r = 0; r < s.length(); r++){
            char str = s.charAt(r);
            while(set.contains(str)){
                set.remove(s.charAt(l++));
            }
            set.add(str);
            len = Math.max(len,r - l + 1);
        }
        return len;
    }


    public int lengthOfLongestSubstring2(String s) {
        if(s.length() < 1) { return 0; }
        int[] result = new int[128];
        //初始化数组
        Arrays.fill(result, -1);

        int max = 0;
        int count = 0;

        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(result[chars[i]] >= 0){
                max = Math.max(max,count);
                i = result[chars[i]] + 1;
                Arrays.fill(result, -1);
                count = 0;
            }
            result[chars[i]] = i;
            count ++;
        }

        max = Math.max(max,count);
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0){
            return 0;
        }
        int maxLength = 0;
        Set<Character> set = new LinkedHashSet<>();
        LinkedList<Character> list = new LinkedList<>();
        char[] array = s.toCharArray();
        for (char a : array) {
            if (set.contains(a)) {
                maxLength = Math.max(maxLength, set.size());
                set.clear();
                while (a != list.pop());
                set.addAll(list);
            }
            list.add(a);
            set.add(a);
        }
        maxLength = Math.max(maxLength, set.size());
        return maxLength;
    }
}