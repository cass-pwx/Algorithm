package com.pwx.algorithm.offer;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 彭伟鑫
 * @date 2022.7.18
 */
public class Day26Test {

    @Test
    public void test1() {
    }

}

class Day26Solution {

    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * <p>
     * 数值（按顺序）可以分成以下几个部分：
     * <p>
     * 若干空格
     * 一个 小数 或者 整数
     * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
     * 若干空格
     * <p>
     * 小数（按顺序）可以分成以下几个部分：
     * （可选）一个符号字符（'+' 或 '-'）
     * 下述格式之一：
     * 至少一位数字，后面跟着一个点 '.'
     * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
     * 一个点 '.' ，后面跟着至少一位数字
     * <p>
     * 整数（按顺序）可以分成以下几个部分：
     * （可选）一个符号字符（'+' 或 '-'）
     * 至少一位数字
     * 部分数值列举如下：
     * <p>
     * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
     * 部分非数值列举如下：
     * <p>
     * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "0"
     * 输出：true
     * <p>
     * 示例 2：
     * <p>
     * 输入：s = "e"
     * 输出：false
     * <p>
     * 示例 3：
     * <p>
     * 输入：s = "."
     * 输出：false
     * <p>
     * 示例 4：
     * <p>
     * 输入：s = "    .1  "
     * 输出：true
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 20
     * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
     *
     * 解题方法：确定有限状态自动机
     * 确定有限状态自动机（以下简称「自动机」）是一类计算模型。它包含一系列状态，这些状态中：
     *      有一种特殊的状态，被称作「初始状态」。
     *      还有一系列状态被称为「接受状态」，它们组成了一个特殊的集合。其中，一个状态可能既是「初始状态」，也是「接受状态」。
     *
     *  起初，这个自动机处于「初始状态」。
     *  随后，它顺序地读取字符串中的每一个字符，并根据当前状态和读入的字符，按照某个事先约定好的「转移规则」，从当前状态转移到下一个状态；
     *  当状态转移完成后，它就读取下一个字符。当字符串全部读取完毕后，如果自动机处于某个「接受状态」，则判定该字符串「被接受」；否则，判定该字符串「被拒绝」。
     *
     *  注意：如果输入的过程中某一步转移失败了，即不存在对应的「转移规则」，此时计算将提前中止。在这种情况下我们也判定该字符串「被拒绝」。
     *
     * 一个自动机，总能够回答某种形式的「对于给定的输入字符串 S，判断其是否满足条件 P」的问题。在本题中，条件 P 即为「构成合法的表示数值的字符串」。
     *
     * 自动机驱动的编程，可以被看做一种暴力枚举方法的延伸：它穷尽了在任何一种情况下，对应任何的输入，需要做的事情。
     *
     * 自动机在计算机科学领域有着广泛的应用。在算法领域，它与大名鼎鼎的字符串查找算法「KMP」算法有着密切的关联；在工程领域，它是实现「正则表达式」的基础。
     *
     * @param s -
     * @return -
     */
    public boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<>();
        Map<CharType, State> initialMap = new HashMap<>();
        initialMap.put(CharType.CHAR_SPACE, State.STATE_INITIAL);
        initialMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        initialMap.put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        initialMap.put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        transfer.put(State.STATE_INITIAL, initialMap);

        Map<CharType, State> intSignMap = new HashMap<>();
        intSignMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        intSignMap.put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        transfer.put(State.STATE_INT_SIGN, intSignMap);

        Map<CharType, State> integerMap = new HashMap<>();
        integerMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        integerMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        integerMap.put(CharType.CHAR_POINT, State.STATE_POINT);
        integerMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_INTEGER, integerMap);

        Map<CharType, State> pointMap = new HashMap<>();
        pointMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        pointMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        pointMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_POINT, pointMap);

        Map<CharType, State> pointWithoutIntMap = new HashMap<>();
        pointWithoutIntMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);

        Map<CharType, State> fractionMap = new HashMap<>();
        fractionMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        fractionMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        fractionMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_FRACTION, fractionMap);

        Map<CharType, State> expMap = new HashMap<>();
        expMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        expMap.put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        transfer.put(State.STATE_EXP, expMap);

        Map<CharType, State> expSignMap = new HashMap<>();
        expSignMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        transfer.put(State.STATE_EXP_SIGN, expSignMap);

        Map<CharType, State> expNumberMap = new HashMap<>();
        expNumberMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        expNumberMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

        Map<CharType, State> endMap = new HashMap<>();
        endMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_END, endMap);

        int length = s.length();
        State state = State.STATE_INITIAL;

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                state = transfer.get(state).get(type);
            }
        }
        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
    }

    public CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    enum State {
        //起始的空格
        STATE_INITIAL,
        //符号位
        STATE_INT_SIGN,
        //整数部分
        STATE_INTEGER,
        //左侧有整数的小数点
        STATE_POINT,
        //左侧无整数的小数点（根据前面的第二条额外规则，需要对左侧有无整数的两种小数点做区分）
        STATE_POINT_WITHOUT_INT,
        //小数部分
        STATE_FRACTION,
        //字符e
        STATE_EXP,
        //指数部分的符号位
        STATE_EXP_SIGN,
        //指数部分的整数部分
        STATE_EXP_NUMBER,
        //末尾的空格
        STATE_END
    }

    enum CharType {
        //整数部分，即由若干字符 0-90−9 组成的字符串
        CHAR_NUMBER,
        //指数部分，其中包含开头的字符 e（大写小写均可）、可选的符号位，和整数部分
        CHAR_EXP,
        //小数点
        CHAR_POINT,
        //整数部分，即由若干字符 0-90−9 组成的字符串
        CHAR_SIGN,
        //空格
        CHAR_SPACE,
        CHAR_ILLEGAL
    }

    /**
     * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
     * <p>
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * <p>
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * <p>
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     * <p>
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     * <p>
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     * <p>
     * 说明：
     * <p>
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
     * 如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "42"
     * 输出: 42
     * 示例 2:
     * <p>
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * 示例 3:
     * <p>
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * 示例 4:
     * <p>
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     * 因此无法执行有效的转换。
     * 示例 5:
     * <p>
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     * 因此返回 INT_MIN (−231) 。
     *
     * @param str -
     * @return -
     */
    public int strToInt(String str) {
        return -1;
    }
}
