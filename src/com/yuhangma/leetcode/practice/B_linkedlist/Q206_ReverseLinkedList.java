//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表


package com.yuhangma.leetcode.practice.B_linkedlist;

import com.yuhangma.leetcode.practice.B_linkedlist.base.ListNode;

/**
 * @author Moore.Ma
 * @since 2020/06/01
 */
public class Q206_ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new Q206_ReverseLinkedList().new Solution();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(solution.reverseList(listNode));
    }

    /**
     * 递归
     */
    class Solution {
        public ListNode reverseList(ListNode head) {

            if (head == null) {
                return null;
            }

            if (head.next == null) {
                return head;
            }

            ListNode listNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;

            return listNode;
        }
    }

    /**
     * 迭代
     */
    class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode prev = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }
            return prev;
        }
    }

}