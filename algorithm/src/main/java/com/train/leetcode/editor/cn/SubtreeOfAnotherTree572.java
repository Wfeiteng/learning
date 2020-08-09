//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。 
//
// 示例 1: 
//给定的树 s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t： 
//
// 
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s： 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t： 
//
// 
//   4
//  / \
// 1   2
// 
//
// 返回 false。 
// Related Topics 树

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.TreeNode;
import com.train.leetcode.editor.cn.common.TreeNodeUtil;

public class SubtreeOfAnotherTree572 {
    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree572().new Solution();
        TreeNode s = TreeNodeUtil.generate(new Integer[]{3, 4, 5, 1, 2, null, null, 0});
        TreeNode t = TreeNodeUtil.generate(new Integer[]{4, 1, 2});
        boolean result = solution.isSubtree(s, t);
        System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) {
                return false;
            }
            if (isSame(s, t)) {
                return true;
            }
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        private boolean isSame(TreeNode s, TreeNode t) {
            if (t == null && s == null) {
                return true;
            }
            if (s == null || t == null) {
                return false;
            }
            if (t.val != s.val) {
                return false;
            }
            boolean leftResult = isSame(s.left, t.left);
            boolean rightResult = isSame(s.right, t.right);
            return leftResult && rightResult;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}