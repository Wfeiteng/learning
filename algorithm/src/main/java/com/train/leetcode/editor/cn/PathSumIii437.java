//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.TreeNode;
import com.train.leetcode.editor.cn.common.TreeNodeUtil;

public class PathSumIii437 {
    public static void main(String[] args) {
        Solution solution = new PathSumIii437().new Solution();
        TreeNode root = TreeNodeUtil.generate(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        int cnt = solution.pathSum(root, 8);
        System.out.println("cnt:" + cnt);
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
        public int pathSum(TreeNode root, int sum) {
            int[] path = new int[1000];
            return path(root, sum, path, 0);
        }

        private int path(TreeNode node, int sum, int[] path, int position) {
            if (node == null) {
                return 0;
            }
            int cnt = 0;
            path[position] = node.val;

            int tmp = 0;
            int index = position;
            while (index >= 0) {
                tmp += path[index];
                index--;
                if (tmp == sum) {
                    cnt += 1;
                }
            }
            int leftCnt = path(node.left, sum, path, (position + 1));
            int rightCnt = path(node.right, sum, path, position + 1);
            return cnt + leftCnt + rightCnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}