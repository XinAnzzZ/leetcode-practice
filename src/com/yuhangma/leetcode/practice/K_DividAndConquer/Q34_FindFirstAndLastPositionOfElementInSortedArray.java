//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找


package com.yuhangma.leetcode.practice.K_DividAndConquer;

import java.util.Arrays;

/**
 * @author Moore.Ma
 * @since 2020/07/11
 */
public class Q34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(solution.searchRange(arr, 8)));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] res = {-1, -1};
            if (nums == null || nums.length == 0) {
                return res;
            }
            int start = 0;
            int end = nums.length - 1;
            int firstPosition = -1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] < target) {
                    start = mid + 1;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    for (int i = start; i <= mid; i++) {
                        if (nums[i] == target) {
                            firstPosition = i;
                            break;
                        }
                    }
                    break;
                }
            }
            if (firstPosition == -1) {
                return res;
            }

            start = 0;
            end = nums.length - 1;
            int lastPosition = firstPosition;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] < target) {
                    start = mid + 1;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    for (int i = end; i >= mid; i--) {
                        if (nums[i] == target) {
                            lastPosition = i;
                            break;
                        }
                    }
                    break;
                }
            }
            return new int[]{firstPosition, lastPosition};
        }
    }

}
