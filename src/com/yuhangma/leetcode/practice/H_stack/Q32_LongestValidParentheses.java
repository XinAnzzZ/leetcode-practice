//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划


package com.yuhangma.leetcode.practice.H_stack;

import java.util.ArrayDeque;

/**
 * @author Moore.Ma
 * @since 2020/06/28
 */
public class Q32_LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(")))"));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Solution();
    }

    static class Solution {
        public int longestValidParentheses(String s) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            stack.push(-1);
            int maxLength = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        maxLength = Math.max(maxLength, i - stack.peek());
                    }
                }
            }
            return maxLength;
        }
    }

}
