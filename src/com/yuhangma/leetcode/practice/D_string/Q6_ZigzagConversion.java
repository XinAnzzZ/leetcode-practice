//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串


package com.yuhangma.leetcode.practice.D_string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Moore.Ma
 * @since 2020/06/13
 */
public class Q6_ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new Q6_ZigzagConversion().new Solution();

        testCase();
    }

    private static void testCase() {
        Solution solution = new Q6_ZigzagConversion().new Solution();
    }

    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            List<StringBuilder> sbs = new ArrayList<>();
            for (int i = 0; i < Integer.min(numRows, s.length()); i++) {
                sbs.add(new StringBuilder());
            }
            boolean down = false;
            int curRow = 0;
            for (char c : s.toCharArray()) {
                StringBuilder sb = sbs.get(curRow);
                sb.append(c);
                if (curRow == 0 || curRow == numRows - 1) {
                    down = !down;
                }
                curRow = down ? ++curRow : --curRow;
            }

            StringBuilder res = new StringBuilder();
            sbs.forEach(res::append);
            return res.toString();
        }
    }
}