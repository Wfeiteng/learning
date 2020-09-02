//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
// 
//
// 示例 2: 
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42 
// Related Topics 树 深度优先搜索

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.TreeNode;
import com.train.leetcode.editor.cn.common.TreeNodeUtil;

public class BinaryTreeMaximumPathSum124 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum124().new Solution();
        TreeNode root = TreeNodeUtil.generate(new Integer[]{-10, 9, 20, null, null, 15, 7});
        int maxSum = solution.maxPathSum(root);
        System.out.println("maxSum: " + maxSum);
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
        int ans = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxPathSumRecursive(root);
            return ans;
        }

        private int maxPathSumRecursive(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftRes = Math.max(maxPathSumRecursive(root.left), 0);
            int rightRes = Math.max(maxPathSumRecursive(root.right), 0);

            ans = Math.max(ans, root.val + leftRes + rightRes);
            return Math.max(leftRes, rightRes) + root.val;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

// ref: https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/