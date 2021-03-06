//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


package com.yuhangma.leetcode.practice.M_backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Moore.Ma
 * @since 2020/07/23
 */
public class Q22_GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(4));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Solution();
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            dfs("", n, n, res);
            return res;
        }

        private void dfs(String curStr, int left, int right, List<String> res) {
            if (left == 0 && right == 0) {
                res.add(curStr);
                return;
            }

            if (left > right) {
                return;
            }

            if (left > 0) {
                dfs(curStr + "(", left - 1, right, res);
            }

            if (right > 0) {
                dfs(curStr + ")", left, right - 1, res);
            }
        }
    }

}
