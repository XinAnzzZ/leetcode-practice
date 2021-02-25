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

import java.util.Random;

/**
 * @author Moore.Ma
 * @since 2020/06/19
 */
public class Q43_MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("123", "456"));
        // testCase();
    }

    private static void testCase() {
        Solution solution = new Solution();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int num1 = random.nextInt(100000);
            int num2 = random.nextInt(100000);
            int correct = num1 * num2;
            int ans = Integer.parseInt(solution.multiply(String.valueOf(num1), String.valueOf(num2)));
            if (correct != ans) {
                System.out.println(num1 + "==" + num2);
                System.out.println("correct=" + correct);
                System.out.println("ans=" + ans);
                throw new RuntimeException();
            }
        }
    }

    static class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            char[] chars1 = num1.toCharArray();
            char[] chars2 = num2.toCharArray();
            int sumLength = chars1.length + chars2.length;
            int[] sumArr = new int[sumLength];
            for (int i = chars1.length - 1; i >= 0; i--) {
                int x = chars1[i] - '0';
                for (int j = chars2.length - 1; j >= 0; j--) {
                    int y = chars2[j] - '0';
                    int temp = x * y + sumArr[i + j + 1];
                    sumArr[i + j + 1] = temp % 10;
                    sumArr[i + j] = sumArr[i + j] + temp / 10;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sumArr.length; i++) {
                if (i == 0 && sumArr[i] == 0) {
                    continue;
                }
                sb.append(sumArr[i]);
            }
            return sb.toString();
        }
    }
}