//给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 
//
// 示例 1: 
//
// 输入: "bcabc"
//输出: "abc"
// 
//
// 示例 2: 
//
// 输入: "cbacdcbc"
//输出: "acdb" 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
// Related Topics 栈 贪心算法


package com.yuhangma.leetcode.practice.H_stack;

import java.util.*;

/**
 * @author Moore.Ma
 * @since 2020/07/01
 */
public class Q316_RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Solution();
    }

    static class Solution {
        public String removeDuplicateLetters(String s) {
            ArrayDeque<Character> stack = new ArrayDeque<>(s.length());
            Map<Character, Integer> lastOccurrence = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                lastOccurrence.put(s.charAt(i), i);
            }

            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!set.contains(c)) {
                    while (!stack.isEmpty() && c < stack.peek() && lastOccurrence.get(stack.peek()) > i) {
                        Character pop = stack.pop();
                        set.remove(pop);
                    }
                    stack.push(c);
                    set.add(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pollLast());
            }
            return sb.toString();
        }
    }

}
