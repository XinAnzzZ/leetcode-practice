//给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。 
//
// 
//
// 示例 1： 
//
// 输入：matrix =
//[
//  [0,1,1,1],
//  [1,1,1,1],
//  [0,1,1,1]
//]
//输出：15
//解释： 
//边长为 1 的正方形有 10 个。
//边长为 2 的正方形有 4 个。
//边长为 3 的正方形有 1 个。
//正方形的总数 = 10 + 4 + 1 = 15.
// 
//
// 示例 2： 
//
// 输入：matrix = 
//[
//  [1,0,1],
//  [1,1,0],
//  [1,1,0]
//]
//输出：7
//解释：
//边长为 1 的正方形有 6 个。 
//边长为 2 的正方形有 1 个。
//正方形的总数 = 6 + 1 = 7.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 300 
// 1 <= arr[0].length <= 300 
// 0 <= arr[i][j] <= 1 
// 
// Related Topics 数组 动态规划


package com.yuhangma.leetcode.practice.L_DP;

/**
 * @author Moore.Ma
 * @since 2020/07/21
 */
public class Q1277_CountSquareSubmatricesWithAllOnes {
    public static void main(String[] args) {
        Solution solution = new Q1277_CountSquareSubmatricesWithAllOnes().new Solution();
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q1277_CountSquareSubmatricesWithAllOnes().new Solution();
    }

    class Solution {
        public int countSquares(int[][] matrix) {
            return 0;
        }
    }

}
