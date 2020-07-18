//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索


package com.yuhangma.leetcode.practice.N_tree;

import com.yuhangma.leetcode.practice.base.TreeNode;

/**
 * @author Moore.Ma
 * @since 2020/07/29
 */
public class Q110_BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Q110_BalancedBinaryTree().new Solution();
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q110_BalancedBinaryTree().new Solution();
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return false;
        }
    }

}
