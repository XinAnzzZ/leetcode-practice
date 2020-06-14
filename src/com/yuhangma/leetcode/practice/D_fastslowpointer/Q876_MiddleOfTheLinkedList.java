//给定一个带有头结点 head 的非空单链表，返回链表的中间结点。 
//
// 如果有两个中间结点，则返回第二个中间结点。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,4,5]
//输出：此列表中的结点 3 (序列化形式：[3,4,5])
//返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
//注意，我们返回了一个 ListNode 类型的对象 ans，这样：
//ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = 
//NULL.
// 
//
// 示例 2： 
//
// 输入：[1,2,3,4,5,6]
//输出：此列表中的结点 4 (序列化形式：[4,5,6])
//由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
// 
//
// 
//
// 提示： 
//
// 
// 给定链表的结点数介于 1 和 100 之间。 
// 
// Related Topics 链表


package com.yuhangma.leetcode.practice.D_fastslowpointer;

import com.yuhangma.leetcode.practice.B_linkedlist.base.ListNode;

/**
 * @author Moore.Ma
 * @since 2020/06/
 */
public class Q876_MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Solution solution = new Q876_MiddleOfTheLinkedList().new Solution();
        System.out.println(solution.middleNode(new ListNode(1)));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q876_MiddleOfTheLinkedList().new Solution();
    }

    class Solution {
        public ListNode middleNode(ListNode head) {
            if (head.next == null) {
                return head;
            }
            ListNode slower = head;
            ListNode faster = head;
            while (faster != null && faster.next != null) {

                slower = slower.next;
                faster = faster.next.next;
            }
            return slower;
        }
    }
}