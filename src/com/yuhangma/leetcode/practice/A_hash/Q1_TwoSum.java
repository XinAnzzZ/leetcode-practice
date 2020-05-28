//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


package com.yuhangma.leetcode.practice.A_hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        Solution1 solution1 = new Q1_TwoSum().new Solution1();
        System.out.println(Arrays.toString(solution1.twoSum(nums, 26)));


        Solution2 solution2 = new Q1_TwoSum().new Solution2();
        System.out.println(Arrays.toString(solution2.twoSum(nums, 26)));

    }

    /**
     * 暴力递归，时间复杂度 O(n^2)
     */
    class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
            return result;
        }
    }

    /**
     * 利用 hash map
     */
    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>((int) ((float) nums.length / 0.75F + 1.0F));
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }

}