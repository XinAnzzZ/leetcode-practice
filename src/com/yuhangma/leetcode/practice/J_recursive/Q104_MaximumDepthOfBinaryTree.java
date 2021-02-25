//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索


package com.yuhangma.leetcode.practice.J_recursive;

import com.yuhangma.leetcode.practice.base.TreeNode;

/**
 * @author Moore.Ma
 * @since 2020/07/06
 */
public class Q104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1,
            new TreeNode(2,
                null, new TreeNode(3)), new TreeNode(2,
            null, new TreeNode(3)));
        System.out.println(solution.maxDepth(treeNode));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

}
