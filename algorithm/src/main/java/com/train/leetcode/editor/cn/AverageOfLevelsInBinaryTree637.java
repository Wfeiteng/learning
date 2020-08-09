//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组. 
//
// 示例 1: 
//
// 输入:
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出: [3, 14.5, 11]
//解释:
//第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
// 
//
// 注意： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree637 {
    public static void main(String[] args) {
        Solution solution = new AverageOfLevelsInBinaryTree637().new Solution();
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
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> avg = new ArrayList<>();
            if (root == null) {
                return avg;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int step = size;
                double total = 0;
                while (step > 0) {
                    TreeNode node = queue.poll();
                    total += node.val;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    step--;
                }
                avg.add(Double.valueOf(total / size));
            }
            return avg;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}