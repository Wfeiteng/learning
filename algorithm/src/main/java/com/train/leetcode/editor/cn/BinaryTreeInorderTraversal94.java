//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal94().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> elements = new ArrayList<>();
            traversal(root, elements);
            return elements;
        }

        private void traversal(TreeNode root, List eles) {
            if (root == null) {
                return;
            }
            traversal(root.left, eles);
            eles.add(root.val);
            traversal(root.right, eles);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}