//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出: 
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2: 
//
// 输入: 
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出: 
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//] 
//
// 进阶: 
//
// 
// 一个直接的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个常数空间的解决方案吗？ 
// 
// Related Topics 数组


package com.yuhangma.leetcode.practice.G_array;

import java.util.Arrays;

/**
 * @author Moore.Ma
 * @since 2020/06/23
 */
public class Q73_SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution.setZeroes(arr);
        System.out.println(Arrays.deepToString(arr));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Solution();
    }

    static class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix.length == 0) {
                return;
            }
            boolean[][] arr = new boolean[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        arr[i][j] = true;
                    }
                }
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j]) {
                        for (int k = 0; k < arr[0].length; k++) {
                            matrix[i][k] = 0;
                        }
                        for (int k = 0; k < arr.length; k++) {
                            matrix[k][j] = 0;
                        }
                    }
                }
            }
        }
    }

}
