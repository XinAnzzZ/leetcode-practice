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

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Moore.Ma
 * @since 2020/07/09
 */
public class Q23_MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node3 = new ListNode(2, new ListNode(6));
        ListNode[] nodes = {node1, node2, node3};
        System.out.println(solution.mergeKLists(nodes));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Solution();
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null) {
                return null;
            }
            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
            for (ListNode node : lists) {
                if (node != null) {
                    queue.add(node);
                }
            }

            ListNode node = new ListNode(0);
            ListNode cur = node;
            while (!queue.isEmpty()) {
                ListNode minNode = queue.poll();
                cur.next = minNode;
                cur = cur.next;
                minNode = minNode.next;
                if (minNode != null) {
                    queue.add(minNode);
                }
            }
            return node.next;
        }
    }

}
