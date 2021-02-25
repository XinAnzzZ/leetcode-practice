//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


package com.yuhangma.leetcode.practice.C_doublepointer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Moore.Ma
 * @since 2020/06/02
 */
public class Q3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("a"));
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            // 最大长度
            int max = 0;
            // 右指针
            int pointer = 0;
            Set<Character> set = new HashSet<>((int) ((float) chars.length / 0.75F + 1.0F));
            for (int i = 0; i < chars.length && pointer < chars.length; i++) {
                while (set.add(chars[pointer])) {
                    if (++pointer >= chars.length) {
                        break;
                    }
                }
                max = Integer.max(pointer - i, max);
                set.remove(chars[i]);
            }
            return max;
        }
    }

}