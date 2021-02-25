//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


package com.yuhangma.leetcode.practice.L_DP;

/**
 * @author Moore.Ma
 * @since 2020/07/13
 */
public class Q5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("aaabaaaa"));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Solution();
    }

    static class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) {
                return s;
            }
            int maxLength = 1;
            int begin = 0;

            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }

            for (int j = 0; j < s.length(); j++) {
                for (int i = 0; i < j; i++) {
                    if (s.charAt(i) != s.charAt(j)) {
                        dp[i][j] = false;
                    } else {
                        if (j - i >= 3) {
                            dp[i][j] = dp[i + 1][j - 1];
                        } else {
                            dp[i][j] = true;
                        }
                    }

                    if (dp[i][j] && j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        begin = i;
                    }
                }
            }

            return s.substring(begin, begin + maxLength);
        }
    }


}
