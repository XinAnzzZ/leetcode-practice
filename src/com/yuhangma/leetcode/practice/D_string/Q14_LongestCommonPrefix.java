//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


package com.yuhangma.leetcode.practice.D_string;

/**
 * @author Moore.Ma
 * @since 2020/06/14
 */
public class Q14_LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Q14_LongestCommonPrefix().new Solution();
        String[] arr = {"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(arr));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q14_LongestCommonPrefix().new Solution();
    }

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < strs[0].toCharArray().length; i++) {
                char cur = strs[0].charAt(i);
                for (String str : strs) {
                    if (str.length() < i + 1 || str.charAt(i) != cur) {
                        return res.toString();
                    }
                }
                res.append(cur);
            }
            return res.toString();
        }
    }
}