//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法


package com.yuhangma.leetcode.practice.K_DividAndConquer;

import com.yuhangma.leetcode.practice.base.ListNode;

/**
 * @author Moore.Ma
 * @since 2020/07/09
 */
public class Q23_MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new Q23_MergeKSortedLists().new Solution();
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q23_MergeKSortedLists().new Solution();
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return null;
        }
    }

}
