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

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Moore.Ma
 * @since 2020/07/01
 */
public class Q316_RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new Q316_RemoveDuplicateLetters().new Solution();
        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q316_RemoveDuplicateLetters().new Solution();
    }

    class Solution {
        public String removeDuplicateLetters(String s) {
            ArrayDeque<Character> stack = new ArrayDeque<>(s.length());
            Set<Character> set = new HashSet<>();
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (!set.contains(c)) {
                    set.add(c);
                    stack.push(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.toString();
        }
    }

}
