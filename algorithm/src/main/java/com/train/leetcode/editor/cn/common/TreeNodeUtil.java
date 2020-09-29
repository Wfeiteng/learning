package com.train.leetcode.editor.cn.common;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNodeUtil {
    public static TreeNode generate(Integer[] a) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(a[0]);
        queue.add(root);
        for (int i = 1; i < a.length; i += 2) {
            TreeNode treeNode = queue.remove();
            if (a[i] != null) {
                treeNode.left = new TreeNode(a[i]);
                queue.add(treeNode.left);
            }
            if (i + 1 < a.length && a[i + 1] != null) {
                treeNode.right = new TreeNode(a[i + 1]);
                queue.add(treeNode.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtil.generate(new Integer[] { 5, null, 6, null, 8, 7, 9 });
System.out.println(treeNode);
        //https://leetcode-cn.com/problems/increasing-order-search-tree/solution/javazhong-xu-bian-li-die-dai-fa-yi-ji-jia-shang-tr/

    }
}
