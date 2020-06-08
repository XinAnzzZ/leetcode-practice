//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


package com.yuhangma.leetcode.practice.C_doublepointer;

import com.yuhangma.leetcode.practice.util.ArrayUtils;

import java.util.Arrays;

/**
 * @author Moore.Ma
 * @since 2020/06/07
 */
public class Q42_TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new Q42_TrappingRainWater().new Solution();
        int[] arr = {3, 9, 1, 7};
        System.out.println(solution.trap(arr));

        testCase();
    }

    private static void testCase() {
        Solution solution = new Q42_TrappingRainWater().new Solution();
        for (int i = 0; i < 100; i++) {
            int[] height = ArrayUtils.genRandomArr();
            System.out.println(Arrays.toString(height));
            System.out.println(solution.trap(height));
        }
    }

    /**
     * 每个柱子能装的雨水量：先找到这个柱子左右两边最高的柱子，然后用两个柱子的较小值 - 当前柱子的高度
     */
    class Solution {
        public int trap(int[] height) {
            int res = 0;

            for (int i = 1; i < height.length - 1; i++) {
                int maxLeft = 0, maxRight = 0;
                for (int j = i; j >= 0; j--) {
                    maxLeft = Math.max(height[j], maxLeft);
                }

                for (int j = i; j < height.length; j++) {
                    maxRight = Math.max(height[j], maxRight);
                }

                int min = Math.min(maxLeft, maxRight);
                res = res + min - height[i];
            }
            return res;
        }
    }
}