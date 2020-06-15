//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心算法 双指针


package com.yuhangma.leetcode.practice.D_string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Moore.Ma
 * @since 2020/06/15
 */
public class Q763_PartitionLabels {
    public static void main(String[] args) {
        Solution solution = new Q763_PartitionLabels().new Solution();
        System.out.println(solution.partitionLabels("a"));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q763_PartitionLabels().new Solution();
    }

    class Solution {
        public List<Integer> partitionLabels(String s) {
            // 记录 a-z 最后一次出现的位置
            int[] lastIndexArr = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int charIndex = s.charAt(i) - 'a';
                lastIndexArr[charIndex] = i;
            }
            List<Integer> res = new ArrayList<>();
            int first = 0, last = 0;
            for (int i = 0; i < s.toCharArray().length; i++) {
                char c = s.charAt(i);
                int lastIndex = lastIndexArr[c - 'a'];
                last = Integer.max(last, lastIndex);
                if (i == last) {
                    res.add(last - first + 1);
                    first = last + 1;
                }
            }
            return res;
        }
    }

}