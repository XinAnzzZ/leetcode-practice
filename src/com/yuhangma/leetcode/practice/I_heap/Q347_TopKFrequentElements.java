//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表


package com.yuhangma.leetcode.practice.I_heap;

import java.util.*;

/**
 * @author Moore.Ma
 * @since 2020/07/03
 */
public class Q347_TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4, 1, -1, 2, -1, 2, 3};
        System.out.println(Arrays.toString(solution.topKFrequent(arr, 2)));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            // 统计频率
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int num : nums) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }

            Comparator<Map.Entry<Integer, Integer>> entryComparator = Comparator.comparingInt(Map.Entry::getValue);
            PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(entryComparator);
            frequencyMap.entrySet().forEach(entry -> {
                if (queue.size() < k) {
                    queue.add(entry);
                } else if (queue.peek().getValue() < entry.getValue()) {
                    queue.poll();
                    queue.add(entry);
                }
            });
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = queue.poll().getKey();
            }
            return res;
        }
    }

}
