//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3)
// + (6 -> 3)
//输出：8 -> 7 -> 3
//原因：342 + 36 = 378
// 
// Related Topics 链表 数学


package com.yuhangma.leetcode.practice.B_linkedlist;

import com.yuhangma.leetcode.practice.base.ListNode;

/**
 * @author Moore.Ma
 * @since 2020/05/28
 */
public class Q2_AddTwoNumbers {
    public static void main(String[] args) {
        Solution1 solution = new Q2_AddTwoNumbers().new Solution1();
        ListNode listNode1 = new ListNode(1, new ListNode(1, new ListNode(1)));
        ListNode listNode2 = new ListNode(2, new ListNode(9));
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode2);

        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }

    class Solution1 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 进位数
            int carry = 0;
            ListNode pre = new ListNode(0);
            ListNode cur = pre;
            while (l1 != null || l2 != null) {
                int i = l1 == null ? 0 : l1.val;
                int j = l2 == null ? 0 : l2.val;

                int sum = i + j + carry;
                carry = sum < 10 ? 0 : 1;
                sum = sum < 10 ? sum : sum - 10;

                cur.next = new ListNode(sum);
                cur = cur.next;

                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }

            if (carry == 1) {
                cur.next = new ListNode(1);
            }

            return pre.next;
        }
    }

}
