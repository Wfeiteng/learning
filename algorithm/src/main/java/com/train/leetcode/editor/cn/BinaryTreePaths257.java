//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.TreeNode;
import com.train.leetcode.editor.cn.common.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths257().new Solution();
        Integer[] tree = new Integer[]{1, 2, 3, 4, 5};
       // Integer[] tree = new Integer[]{1};
        TreeNode root = TreeNodeUtil.generate(tree);
        List<String> path = solution.binaryTreePaths(root);
        System.out.println(path);
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            processDsf(root, new ArrayList<Integer>(), result);
            // process(root, new ArrayList<Integer>(), result);
          //   dfs(root, new ArrayList<Integer>(), result);
            return result;
        }

        private void dfs(TreeNode root, List<Integer> path, List<String> result) {
            if (root == null) {
                return;
            }
            if (isLeaf(root)) {
                // 叶子结点
                String pathStr = "";
                for (Integer val : path) {
                    pathStr = pathStr + val + "->";
                }
                pathStr = pathStr + root.val;
                result.add(pathStr);
                return;
            }
            //注释: 叶子结点的上级加入了path,因此处理完该非叶子节点后,只需要删除一个进行恢复。
            path.add(root.val);
            dfs(root.left, path, result);
            dfs(root.right, path, result);
            path.remove(path.size() - 1);
        }

        private void process(TreeNode root, List<Integer> nodes, List<String> list) {
            nodes.add(root.val);
            if (isLeaf(root)) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < nodes.size() - 1; i++) {
                    sb.append(nodes.get(i) + "->");
                }
                sb.append(root.val);
                list.add(sb.toString());
            }
            if (root.left != null) {
                process(root.left, nodes, list);
                nodes.remove(nodes.size() - 1);
            }
            if (root.right != null) {
                process(root.right, nodes, list);
                nodes.remove(nodes.size() - 1);
            }
        }

        private void processDsf(TreeNode root, List<Integer> nodes, List<String> list) {
            nodes.add(root.val);
            if (isLeaf(root)) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < nodes.size() - 1; i++) {
                    sb.append(nodes.get(i) + "->");
                }
                sb.append(root.val);
                list.add(sb.toString());
            }

            // 不加判断,导致有部分数据没有加入nodes,多恢复现场了;
            if (root.left != null) {
                // 确实放入了栈中了 所以清除，恢复现场;
                processDsf(root.left, nodes, list);
                nodes.remove(nodes.size() - 1);
            }

            if (root.right != null) {
                processDsf(root.right, nodes, list);
                nodes.remove(nodes.size() - 1);
            }

        }

        /**
         * 是否叶子结点
         *
         * @param root
         * @return
         */
        private boolean isLeaf(TreeNode root) {
            if (root.left == null && root.right == null) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}