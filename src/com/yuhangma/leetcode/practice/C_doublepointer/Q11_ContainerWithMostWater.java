//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针


package com.yuhangma.leetcode.practice.C_doublepointer;

/**
 * @author Moore.Ma
 * @since 2020/06/
 */
public class Q11_ContainerWithMostWater {
    public static void main(String[] args) {
        Solution2 solution = new Q11_ContainerWithMostWater().new Solution2();
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(arr));
    }

    /**
     * 解题思路：双指针，扫一遍，面积 = (firstPointer - lastPointer) * min(arr[firstPointer], arr[lastPointer])
     */
    class Solution {
        public int maxArea(int[] height) {
            int max = 0;

            for (int i = 0; i < height.length; i++) {
                for (int j = i; j < height.length; j++) {
                    int area = (j - i) * (Integer.min(height[j], height[i]));
                    max = Integer.max(area, max);
                }
            }

            return max;
        }
    }

    /**
     * 官方解题思路：双指针，分别指向第一个位置 (arr[0]) 和最后一个位置 (arr[n])，每次移动 min(arr[left], arr[right]).
     */
    class Solution2 {
        public int maxArea(int[] height) {
            int max = 0;

            int left = 0;
            int right = height.length - 1;

            while (left < right) {
                int area = (right - left) * (Integer.min(height[right], height[left]));
                max = Integer.max(area, max);
                if (height[left] > height[right]) {
                    right--;
                } else {
                    left++;
                }
            }

            return max;
        }
    }

}