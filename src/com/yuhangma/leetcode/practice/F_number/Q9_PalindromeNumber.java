//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学


package com.yuhangma.leetcode.practice.F_number;

/**
 * @author Moore.Ma
 * @since 2020/06/18
 */
public class Q9_PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(12455421));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int y = x / 10;
            int res = x % 10;
            while (y > 0) {
                int remainder = y % 10;
                res = res * 10 + remainder;
                y /= 10;
            }
            return res == x;
        }
    }

}