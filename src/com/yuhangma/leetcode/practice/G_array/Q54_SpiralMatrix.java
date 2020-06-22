//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组


package com.yuhangma.leetcode.practice.G_array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Moore.Ma
 * @since 2020/06/22
 */
public class Q54_SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new Q54_SpiralMatrix().new Solution();
        int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        System.out.println(solution.spiralOrder(arr));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q54_SpiralMatrix().new Solution();
    }

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix.length == 0) {
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>(matrix.length * matrix[0].length);
            int top = 0, buttom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
            while (buttom >= top && right >= left) {
                // 左到右
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                top++;
                // 上到下
                for (int i = top; i <= buttom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
                if (top > buttom || left > right) {
                    break;
                }
                // 右到左
                for (int i = right; i >= left; i--) {
                    res.add(matrix[buttom][i]);
                }
                buttom--;
                // 下到上
                for (int i = buttom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
            return res;
        }
    }

}