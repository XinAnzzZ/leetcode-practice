//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针


package com.yuhangma.leetcode.practice.B_linkedlist;

import com.yuhangma.leetcode.practice.base.ListNode;

/**
 * @author Moore.Ma
 * @since 2020/05/28
 */
public class Q19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(listNode);
        ListNode newList = solution.removeNthFromEnd(listNode, 3);
        System.out.println(newList);
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 造一个虚拟节点，为了更方便的删除头结点
            ListNode virtualHead = new ListNode(0);
            virtualHead.next = head;
            // 前指针
            ListNode first = virtualHead;
            // 后指针
            ListNode last = virtualHead;

            int count = 0;
            while (last.next != null) {
                // first 走到最后一个节点，last 刚好走到倒数第 n + 1 个位置，只需要删除下一个节点即可。
                if (first.next == null) {
                    last.next = last.next.next;
                    break;
                }

                first = first.next;
                // 前指针先移动，移动了 n 次以后后指针开始移动
                if (count >= n) {
                    last = last.next;
                }
                count++;
            }

            return virtualHead.next;
        }
    }
}