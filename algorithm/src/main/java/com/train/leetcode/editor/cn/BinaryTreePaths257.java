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

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths257().new Solution();
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
            process(root, new ArrayList<Integer>(), result);
         //   dfs(root, new ArrayList<Integer>(), result);
            return result;
        }

        private void dfs(TreeNode root, List<Integer> path, List<String> result) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                // 叶子结点
                String pathStr = "";
                for (Integer val : path) {
                    pathStr = pathStr + val + "->";
                }
                pathStr = pathStr + root.val;
                result.add(pathStr);
                return;
            }
            path.add(root.val);
            dfs(root.left, path, result);
            dfs(root.right, path, result);
            path.remove(path.size() - 1);
        }

        private void process(TreeNode root,List<Integer> nodes,List<String> list){
            if(root == null){
                return;
            }
            if(root.left == null && root.right == null){
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < nodes.size()-1 ; i++) {
                    sb.append(nodes.get(i)+"->");
                }
                sb.append(root.val);
                list.add(sb.toString());
            }
            nodes.add(root.val);
            if(root.left != null){
                process(root.left,nodes,list);
                nodes.remove(nodes.size()-1);
            }
            if(root.right != null){
                process(root.right,nodes,list);
                nodes.remove(nodes.size()-1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}