package com.pwx.algorithm.offer;

/**
 * @author 彭伟鑫#A04154
 * @date 2022.6.23
 */
public class Day03 {
    public static void main(String[] args) {
        Day03Solution day03Solution = new Day03Solution();
        System.out.println(day03Solution.reverseLeftWords("abcdefg", 2));

    }
}


class Day03Solution {

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"
     * @param s -
     * @return -
     */
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ') {
                sb.append("%20");
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 方法2
     * @param s -
     * @return -
     */
    public String replaceSpace2(String s){
        s = s.replace(" ", "%20");
        return s;
    }

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * @param s -
     * @param n -
     * @return -
     */
    public String reverseLeftWords(String s, int n) {
        if(s == null || s.length() < n){
            return s;
        }
        String substring = s.substring(0, n);
        return s.substring(n) + substring;
    }
}