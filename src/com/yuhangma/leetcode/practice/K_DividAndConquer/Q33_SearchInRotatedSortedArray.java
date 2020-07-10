//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找


package com.yuhangma.leetcode.practice.K_DividAndConquer;

/**
 * @author Moore.Ma
 * @since 2020/07/10
 */
public class Q33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Q33_SearchInRotatedSortedArray().new Solution();
        int[] arr = {4, 5, 6, 7, 8, 0, 1, 2};
        System.out.println(solution.search(arr, 3));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q33_SearchInRotatedSortedArray().new Solution();
    }

    class Solution {
        public int search(int[] nums, int target) {
            // 二分法找到数组中元素的最大值的索引
            int maxValueIndex = getMaxValueIndex(nums, 0, nums.length - 1);
            // 从 0 开始到最大值所在的索引位置之间进行二分搜索
            int i = binarySearch(nums, 0, maxValueIndex, target);
            if (i != -1) {
                return i;
            }
            // 从最大值索引 + 1 位置开始到数组末尾进行二分搜索
            int j = binarySearch(nums, maxValueIndex + 1, nums.length - 1, target);
            if (j != -1) {
                return j;
            }
            return -1;
        }

        private int getMaxValueIndex(int[] nums, int start, int end) {
            if (start == end) {
                return start;
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[0]) {
                return getMaxValueIndex(nums, start, mid - 1);
            } else {
                return getMaxValueIndex(nums, mid + 1, end);
            }
        }

        private int binarySearch(int[] nums, int start, int end, int target) {
            if (start == end) {
                return -1;
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                return binarySearch(nums, start, mid - 1, target);
            } else if (nums[mid] < target) {
                return binarySearch(nums, mid + 1, end, target);
            } else {
                return mid;
            }
        }
    }

}
