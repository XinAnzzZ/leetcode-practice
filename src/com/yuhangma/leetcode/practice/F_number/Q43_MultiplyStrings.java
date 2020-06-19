//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串


package com.yuhangma.leetcode.practice.F_number;

/**
 * @author Moore.Ma
 * @since 2020/06/19
 */
public class Q43_MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new Q43_MultiplyStrings().new Solution();
        System.out.println(solution.multiply("12", "12"));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q43_MultiplyStrings().new Solution();
    }

    class Solution {
        public String multiply(String num1, String num2) {
            char[] chars1 = num1.toCharArray();
            char[] chars2 = num2.toCharArray();
            int sum = 0;
            int adder = 0;
            for (int i = chars1.length - 1; i >= 0; i--) {
                int x = chars1[i] - '0';
                for (int j = chars2.length - 1; j >= 0; j--) {
                    int y = chars2[j] - '0';
                    int temp = x * y + adder;
                    sum = sum + (temp % 10) * (int) Math.pow(10, chars1.length - i - 1);
                    adder = temp / 10;
                }
            }
            return String.valueOf(sum);
        }
    }
}