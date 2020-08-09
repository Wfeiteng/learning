//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.TreeNode;

import java.util.Stack;

public class InvertBinaryTree226 {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree226().new Solution();
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
        public TreeNode invertTree(TreeNode root) {
            //return invertTreeDiGui(root);
            return invertTreeWithStack(root);
        }

        public TreeNode invertTreeDiGui(TreeNode root) {
            if (root == null) {
                return null;
            }
            // 交换左右结点
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTreeDiGui(root.left);
            invertTreeDiGui(root.right);
            return root;
        }

        public TreeNode invertTreeWithStack(TreeNode root) {
            if (root == null) {
                return root;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            return root;
        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}