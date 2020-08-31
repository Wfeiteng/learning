//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7] 左根右
//后序遍历 postorder = [9,15,7,20,3] 左右根
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 266 👎 0

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal106 {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal106().new Solution();
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            // 以空间换时间，与105题思路一致；
            HashMap<Integer, Integer> inOrderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inOrderMap.put(inorder[i], i);
            }
            return _buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inOrderMap);
        }

        private TreeNode _buildTree(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight, HashMap<Integer, Integer> inOrderMap) {
            if (inLeft > inRight || postLeft > postRight) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[postRight]);
            int midIndex = inOrderMap.get(postorder[postRight]);
            root.left = _buildTree(inorder, inLeft, midIndex - 1, postorder, postLeft, postLeft + midIndex - inLeft - 1, inOrderMap);
            root.right = _buildTree(inorder, midIndex + 1, inRight, postorder, postLeft + midIndex - inLeft, postRight - 1, inOrderMap);
            return root;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}