//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum112 {
    public static void main(String[] args) {
        Solution solution = new PathSum112().new Solution();
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
        public boolean hasPathSum(TreeNode root, int sum) {
            List<Integer> path = new ArrayList<>();
            return hasPath(root, sum, path);
        }

        private boolean hasPath(TreeNode root, int sum, List<Integer> path) {
            if (root == null) {
                return false;
            }
            path.add(root.val);
            if (isLeaf(root)) {
                int pathValue = 0;
                for (Integer value : path) {
                    pathValue += value;
                }
                if (pathValue == sum) {
                    return true;
                }
                return false;
            }

            boolean leftResult = false;
            boolean rightResult = false;
            if (root.left != null) {
                leftResult = hasPath(root.left, sum, path);
                path.remove(path.size() - 1);
            }
            if (root.right != null) {
                rightResult = hasPath(root.right, sum, path);
                path.remove(path.size() - 1);
            }
            return leftResult || rightResult;
        }

        private boolean isLeaf(TreeNode node) {
            if (node.left == null && node.right == null) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}