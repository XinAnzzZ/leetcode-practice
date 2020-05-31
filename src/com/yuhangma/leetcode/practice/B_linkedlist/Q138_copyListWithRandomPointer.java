/*
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的 深拷贝。 

我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 */

package com.yuhangma.leetcode.practice.B_linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Moore.Ma
 * @since 2020/05/31
 */
public class Q138_copyListWithRandomPointer {

    public static void main(String[] args) {
        Node seven = new Node(7);
        Node thirteen = new Node(13);
        Node eleven = new Node(11);
        Node ten = new Node(10);
        Node one = new Node(1);

        seven.next = thirteen;

        thirteen.next = eleven;
        thirteen.random = seven;

        eleven.next = ten;
        eleven.random = one;

        ten.next = one;
        ten.random = eleven;

        one.random = seven;

        System.out.println(seven);
        System.out.println(new Q138_copyListWithRandomPointer().new Solution().copyRandomList(seven));
    }

    class Solution {

        // key 是原链表的 node，value 是 copied 的新的 node
        Map<Node, Node> visitedMap = new HashMap<>();

        // 用旧的 node 获取 copied node，如果不存在，则新建
        public Node getCopiedNode(Node node) {
            if (node == null) {
                return null;
            }

            if (!visitedMap.containsKey(node)) {
                visitedMap.put(node, new Node(node.val));
            }
            return visitedMap.get(node);
        }

        public Node copyRandomList(Node head) {
            Node newNode = new Node(head.val);
            visitedMap.put(head, newNode);

            Node oldCur = head;
            Node newCur = newNode;
            while (oldCur != null) {
                newCur.next = getCopiedNode(oldCur.next);
                newCur.random = getCopiedNode(oldCur.random);

                newCur = newCur.next;
                oldCur = oldCur.next;
            }
            return newNode;
        }
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int x) {
            val = x;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            Node cur = this;
            StringBuilder sb = new StringBuilder();
            while (cur != null) {
                sb.append(cur.val);
                sb.append("|");
                if (cur.random != null) {
                    sb.append(cur.random.val);
                } else {
                    sb.append("null");
                }
                if (cur.next != null) {
                    sb.append("--->");
                }
                cur = cur.next;
            }
            return sb.toString();
        }
    }
}
