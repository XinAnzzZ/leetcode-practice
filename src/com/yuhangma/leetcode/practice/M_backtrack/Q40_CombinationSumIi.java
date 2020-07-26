//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法


package com.yuhangma.leetcode.practice.M_backtrack;

import java.util.*;

/**
 * @author Moore.Ma
 * @since 2020/07/24
 */
public class Q40_CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new Q40_CombinationSumIi().new Solution();
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q40_CombinationSumIi().new Solution();
    }

    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, 0, target, new ArrayDeque<>(), res);
            return res;
        }

        /**
         * @param candidates 候选数组
         * @param begin      起始位置
         * @param residue    剩余
         * @param path       路径
         * @param res        结果集
         */
        private void dfs(int[] candidates, int begin, int residue, Deque<Integer> path, List<List<Integer>> res) {
            if (residue == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = begin; i < candidates.length; i++) {
                if (residue - candidates[i] < 0) {
                    break;
                }
                if (i > begin && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                path.addLast(candidates[i]);
                dfs(candidates, i + 1, residue - candidates[i], path, res);
                path.removeLast();

            }
        }
    }

}
