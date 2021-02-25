//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法


package com.yuhangma.leetcode.practice.I_heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Moore.Ma
 * @since 2020/07/02
 */
public class Q215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(solution.findKthLargest(arr, 4));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Solution();
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
            for (int num : nums) {
                if (queue.size() < k) {
                    queue.add(num);
                } else if (queue.peek() < num) {
                    queue.poll();
                    queue.add(num);
                }
            }
            return queue.poll();
        }
    }

}
