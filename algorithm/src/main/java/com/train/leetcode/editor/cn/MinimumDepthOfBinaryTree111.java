//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.TreeNode;

public class MinimumDepthOfBinaryTree111 {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree111().new Solution();
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
        public int minDepth(TreeNode root) {
            return minDfs(root);
        }

        private int minDfs(TreeNode node) {
            if (node == null) return 0;
            /**
             * 单树只算一边
             */
            if (node.left == null) return 1 + minDfs(node.right);
            if (node.right == null) return 1 + minDfs(node.left);

            int leftValue = minDfs(node.left);
            int rightValue = minDfs(node.right);
            return Math.min(leftValue, rightValue) + 1;
        }

        // todo bfs解法也尝试下

    }
//leetcode submit region end(Prohibit modification and deletion)

}