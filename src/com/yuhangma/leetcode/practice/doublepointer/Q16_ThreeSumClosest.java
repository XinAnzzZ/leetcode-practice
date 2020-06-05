//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针


package com.yuhangma.leetcode.practice.doublepointer;

import java.util.Arrays;

/**
 * @author Moore.Ma
 * @since 2020/06/05
 */
public class Q16_ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new Q16_ThreeSumClosest().new Solution();
        int[] arr = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(solution.threeSumClosest(arr, target));
    }

    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);

            int closestSum = nums[0] + nums[1] + nums[2];
            int l, r;
            for (int i = 0; i < nums.length - 2; i++) {
                l = i + 1;
                r = nums.length - 1;

                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                        closestSum = sum;
                    }

                    if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        break;
                    }
                }
            }
            return closestSum;
        }
    }

}