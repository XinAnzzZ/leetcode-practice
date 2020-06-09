//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回
// 0。 
//
// 示例: 
//
// 输入: s = 7, nums = [2,3,1,2,4,3]
//输出: 2
//解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
// 
//
// 进阶: 
//
// 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// Related Topics 数组 双指针 二分查找


package com.yuhangma.leetcode.practice.C_doublepointer;

import com.yuhangma.leetcode.practice.util.ArrayUtils;

import java.util.Arrays;

/**
 * @author Moore.Ma
 * @since 2020/06/09
 */
public class Q209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new Q209_MinimumSizeSubarraySum().new Solution();
        System.out.println(solution.minSubArrayLen(20, new int[]{4, 9, 3, 5, 7, 9, 1}));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q209_MinimumSizeSubarraySum().new Solution();
        for (int i = 0; i < 100; i++) {
            int[] nums = ArrayUtils.genRandomArr(1, 10);
            System.out.println(Arrays.toString(nums));
            System.out.println(solution.minSubArrayLen(20, nums));
            System.out.println("-----------------");
        }
    }

    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            if (nums.length <= 0) {
                return 0;
            }
            int l = 0, r = 0;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            // l4, 9, 3, 5, 7, 9, 1
            while (r < nums.length) {
                sum += nums[r];
                r++;

                while (sum >= s) {
                    sum -= nums[l];
                    min = Math.min(min, r - l);
                    l++;
                }
            }
            if (min == Integer.MAX_VALUE) {
                return 0;
            }
            return min;
        }
    }
}