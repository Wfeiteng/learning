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

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.TreeNode;

public class MaximumDepthOfBinaryTree104 {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree104().new Solution();
        TreeNode root = new TreeNode(10);
        int maxDep = solution.maxDepth(root);
        System.out.println("maxDep:" + maxDep);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return maxDfs(root);
        }

        private int maxDfs(TreeNode node) {
            if (node == null) {
                return 0;
            }

            //todo haha for循环->{再调用子节点}可以dfs,
            /**
             * 左右子树
             */
            int leftDep = maxDfs(node.left);
            int rightDep = maxDfs(node.right);

            return Math.max(leftDep, rightDep) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}