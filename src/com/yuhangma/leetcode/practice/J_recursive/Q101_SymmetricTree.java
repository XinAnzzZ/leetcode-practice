//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索


package com.yuhangma.leetcode.practice.J_recursive;

import com.yuhangma.leetcode.practice.base.TreeNode;

/**
 * @author Moore.Ma
 * @since 2020/07/05
 */
public class Q101_SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new Q101_SymmetricTree().new Solution();
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        null, new TreeNode(3)), new TreeNode(2,
                null, new TreeNode(3)));
        System.out.println(solution.isSymmetric(treeNode));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q101_SymmetricTree().new Solution();
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode tree, TreeNode anotherTree) {
            // 全为 null
            if (tree == null && anotherTree == null) {
                return true;
            }
            // 有一个为 null
            if (tree == null ^ anotherTree == null) {
                return false;
            }
            // 都不为 null
            if (tree.val != anotherTree.val) {
                return false;
            }

            return isSymmetric(tree.left, anotherTree.right)
                    && isSymmetric(tree.right, anotherTree.left);
        }
    }

}
