/*
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL

 */

package com.yuhangma.leetcode.practice.B_linkedlist;

import com.yuhangma.leetcode.practice.B_linkedlist.base.ListNode;

/**
 * @author Moore.Ma
 * @since 2020/05/30
 */
public class Q61_RotateList {
    public static void main(String[] args) {
        Solution2 solution = new Q61_RotateList().new Solution2();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(solution.rotateRight(listNode, 7));
    }

    /**
     * 自己写的
     */
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }

            ListNode tail = head;
            int length = 0;
            while (tail != null) {
                tail = tail.next;
                length++;
            }

            k = k % length;

            if (k == 0) {
                return head;
            }

            ListNode first = head;
            ListNode last = head;
            int i = 0;
            while (first.next != null) {
                first = first.next;
                if (i++ >= k) {
                    last = last.next;
                }
            }
            first.next = head;
            head = last.next;
            last.next = null;
            return head;
        }
    }

    /**
     * 官方解答：
     * <p>
     * 链表中的点已经相连，一次旋转操作意味着：
     * - 先将链表闭合成环
     * - 找到相应的位置断开这个环，确定新的链表头和链表尾
     * <p>
     * 此方法和我写的复杂度是差不多的，但是思路会更清晰，并且代码更优雅。
     */
    @SuppressWarnings("unused")
    class Solution2 {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }

            // 闭环并且求得环长度
            ListNode oldTail = head;
            int length = 1;
            while (oldTail.next != null) {
                length++;
                oldTail = oldTail.next;
            }
            oldTail.next = head;

            // 找到对应的位置断开环
            ListNode cur = head;
            for (int i = 0; i < length - (k % length) - 1; i++) {
                cur = cur.next;
            }
            ListNode newHead = cur.next;
            // 断开环
            cur.next = null;
            return newHead;
        }
    }
}
