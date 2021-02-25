//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学


package com.yuhangma.leetcode.practice.F_number;

/**
 * @author Moore.Ma
 * @since 2020/06/20
 */
public class Q172_FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(6));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Solution();
    }

    static class Solution {
        public int trailingZeroes(int n) {
            return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
        }
    }
}