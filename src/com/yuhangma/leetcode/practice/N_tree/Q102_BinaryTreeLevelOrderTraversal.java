//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


package com.yuhangma.leetcode.practice.N_tree;

import com.yuhangma.leetcode.practice.base.TreeNode;

import java.util.List;

/**
 * @author Moore.Ma
 * @since 2020/07/28
 */
public class Q102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q102_BinaryTreeLevelOrderTraversal().new Solution();
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q102_BinaryTreeLevelOrderTraversal().new Solution();
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            return null;
        }
    }

}
