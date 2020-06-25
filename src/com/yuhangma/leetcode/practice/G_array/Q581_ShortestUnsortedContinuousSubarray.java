//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 你找到的子数组应是最短的，请输出它的长度。 
//
// 示例 1: 
//
// 
//输入: [2, 6, 4, 8, 10, 9, 15]
//输出: 5
//解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 说明 : 
//
// 
// 输入的数组长度范围在 [1, 10,000]。 
// 输入的数组可能包含重复元素 ，所以升序的意思是<=。 
// 
// Related Topics 数组


package com.yuhangma.leetcode.practice.G_array;

import java.util.ArrayDeque;

/**
 * @author Moore.Ma
 * @since 2020/06/25
 */
public class Q581_ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new Q581_ShortestUnsortedContinuousSubarray().new Solution();
        int[] arr = {1, 2, 3, 3, 3};
        System.out.println(solution.findUnsortedSubarray(arr));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q581_ShortestUnsortedContinuousSubarray().new Solution();
    }

    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            // 递增栈
            ArrayDeque<Integer> incrStack = new ArrayDeque<>();
            int l = nums.length;
            for (int i = 0; i < nums.length; i++) {
                while (!incrStack.isEmpty() && nums[incrStack.peek()] > nums[i]) {
                    l = Math.min(l, incrStack.pop());
                }
                incrStack.push(i);
            }

            // 递减栈
            ArrayDeque<Integer> decrStack = new ArrayDeque<>();
            int r = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                while (!decrStack.isEmpty() && nums[decrStack.peek()] < nums[i]) {
                    r = Math.max(decrStack.pop(), r);
                }
                decrStack.push(i);
            }
            return l > r ? 0 : r - l + 1;
        }
    }

}
