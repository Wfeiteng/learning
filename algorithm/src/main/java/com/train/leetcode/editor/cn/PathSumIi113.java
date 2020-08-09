//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
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
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumIi113 {
    public static void main(String[] args) {
        Solution solution = new PathSumIi113().new Solution();
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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> paths = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            paths(root, sum, path, paths);
            return paths;
        }

        private void paths(TreeNode root, int sum, List<Integer> path, List<List<Integer>> paths) {
            if (root == null) {
                return;
            }
            if (isLeaf(root)) {
                int pathSum = 0;
                for (Integer nodeValue : path) {
                    pathSum += nodeValue;
                }
                if (pathSum + root.val == sum) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.addAll(path);
                    tmp.add(root.val);
                    paths.add(tmp);
                }
            }
            path.add(root.val);
            paths(root.left, sum, path, paths);
            paths(root.right, sum, path, paths);
            path.remove(path.size() - 1);
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