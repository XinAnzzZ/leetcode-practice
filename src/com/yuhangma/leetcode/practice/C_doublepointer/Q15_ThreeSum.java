//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


package com.yuhangma.leetcode.practice.C_doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Moore.Ma
 * @since 2020/06/04
 */
public class Q15_ThreeSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        System.out.println(solution.threeSum(nums));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();

            if (nums.length < 3) {
                return res;
            }

            // 排序
            nums = Arrays.stream(nums).sorted().toArray();

            // 所有数据都大于 0 或者小于 0，则无解
            if (nums[0] > 0 || nums[nums.length - 1] < 0) {
                return res;
            }

            for (int i = 0; i < nums.length - 2; ) {
                int left = i + 1;
                int right = nums.length - 1;

                if (nums[i] > 0) {
                    break;
                }

                while (right > left && nums[right] >= 0) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum < 0) {
                        while (right > left && nums[left] == nums[++left]) ;
                    } else if (sum > 0) {
                        while (right > left && nums[right] == nums[--right]) ;
                    } else {
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);

                        while (right > left && nums[left] == nums[++left]) ;
                        while (right > left && nums[right] == nums[--right]) ;
                    }
                }
                while (i < nums.length - 1 && nums[i] == nums[++i]) ;
            }

            return res;
        }
    }

}