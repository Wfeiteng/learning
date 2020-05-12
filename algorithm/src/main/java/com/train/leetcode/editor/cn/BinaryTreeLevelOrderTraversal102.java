//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
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

package com.train.leetcode.editor.cn;


import com.train.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal102().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();

            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> value = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode tmp = queue.poll();
                    value.add(tmp.val);
                    if (tmp.left != null) {
                        queue.offer(tmp.left);
                    }
                    if (tmp.right != null) {
                        queue.offer(tmp.right);
                    }
                }
                result.add(value);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}