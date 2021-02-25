//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划


package com.yuhangma.leetcode.practice.L_DP;

/**
 * @author Moore.Ma
 * @since 2020/07/14
 */
public class Q53_MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(arr));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int lastMax = nums[0];
            int max = lastMax;
            for (int i = 1; i < nums.length; i++) {
                lastMax = Math.max(lastMax + nums[i], nums[i]);
                max = Math.max(max, lastMax);
            }
            return max;
        }
    }

}
