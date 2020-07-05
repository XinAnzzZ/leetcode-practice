//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


package com.yuhangma.leetcode.practice.J_recursive;

import com.yuhangma.leetcode.practice.base.ListNode;

/**
 * @author Moore.Ma
 * @since 2020/07/04
 */
public class Q21_MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new Q21_MergeTwoSortedLists().new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        System.out.println(solution.mergeTwoLists(l1, l2));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q21_MergeTwoSortedLists().new Solution();
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            ListNode head = new ListNode(0);
            ListNode cur = head;
            while (cur1 != null && cur2 != null) {
                if (cur1.val < cur2.val) {
                    cur.next = cur1;
                    cur = cur.next;
                    cur1 = cur1.next;
                } else if (cur1.val == cur2.val) {
                    cur.next = cur1;
                    cur1 = cur1.next;
                    cur = cur.next;

                    cur.next = cur2;
                    cur2 = cur2.next;
                    cur = cur.next;
                } else {
                    cur.next = cur2;
                    cur = cur.next;
                    cur2 = cur2.next;
                }
            }
            if (cur1 == null) {
                cur.next = cur2;
            }
            if (cur2 == null) {
                cur.next = cur1;
            }
            return head.next;
        }
    }

}
