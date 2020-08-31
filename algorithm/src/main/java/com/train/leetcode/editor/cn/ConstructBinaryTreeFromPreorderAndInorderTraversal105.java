//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 626 👎 0

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal105().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return _buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        /**
         * 范围:[left,right]
         *
         * @param preorder 前序遍历
         * @param preLeft
         * @param preRight
         * @param inorder  中序
         * @param inLeft
         * @param inRight
         * @return
         */
        private TreeNode _buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
            if (preLeft > preRight || inLeft > inRight) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preLeft]);
            int inOrderRoot;
            for (inOrderRoot = 0; inOrderRoot < inorder.length; inOrderRoot++) {
                if (preorder[preLeft] == inorder[inOrderRoot]) {
                    break;
                }
            }
            // 分别构建左右子树
            root.left = _buildTree(preorder, preLeft + 1, preLeft + inOrderRoot - inLeft, inorder, inLeft, inOrderRoot - 1);
            root.right = _buildTree(preorder, preLeft + 1 + inOrderRoot - inLeft, preRight, inorder, inOrderRoot + 1, inRight);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}