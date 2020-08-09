//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。 
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计 
// 👍 331 👎 0

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.TreeNode;

import java.util.*;

public class SerializeAndDeserializeBinaryTree297 {
    public static void main(String[] args) {
        // todo 失败
        Codec solution = new SerializeAndDeserializeBinaryTree297().new Codec();
        String serializeRawValue = new String("[5,2,3,null,null,2,4,3,1]");
        TreeNode root = solution.deserialize(serializeRawValue);
        String serializeValue = solution.serialize(root);
        System.out.println(serializeValue);
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
    public class Codec {


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
        /*    List<String> result = new ArrayList<>();
            sequence_rue(root, result);
            return result.toString();*/
            return sequence(root);
        }

        /**
         * 递归实现
         *
         * @param root
         * @return
         */
        public void sequence_digui(TreeNode root, List<String> result) {
            if (root == null) {
                result.add("null");
                return;
            }
            result.add(String.valueOf(root.val));
            sequence_digui(root.left, result);
            sequence_digui(root.left, result);

        }

        /**
         * 层序遍历实现
         *
         * @param root
         * @return
         */
        public String sequence(TreeNode root) {
            List<String> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    result.add(String.valueOf(node.val));
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    // 填写""
                    result.add("null");
                }
            }
            for (int j = result.size() - 1; j > 0; j--) {
                if (result.get(j) == "null") {
                    result.remove(j);
                } else {
                    break;
                }
            }
            return result.toString();
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            data = data.substring(1, data.length() - 1);
            String[] values = data.split(",");
            // TreeNode root = _deserialize(values, values.length, 0);
            TreeNode root = _deserialize(new LinkedList<String>(Arrays.asList(values)));
            return root;
        }

        /**
         * @param value
         * @return
         */
        private TreeNode _deserialize(Queue<String> value) {
            if (value.isEmpty()) {
                return null;
            }

            String str = value.poll();
            str = str.trim();
            if (str.equals("null")) {
                return null;
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(str));

                // left
                node.left = _deserialize(value);
                // right
                node.right = _deserialize(value);
                return node;
            }

        }

        /**
         * 反序列化:正确的，改为return,对象引用
         *
         * @param values
         * @param n
         * @param pos
         * @return
         */
        private TreeNode _deserialize(String[] values, int n, int pos) {
            if (pos >= n) {
                return null;
            }
            TreeNode node;
            String str = values[pos];
            str = str.trim();
            if (str.equals("null")) {
                node = null;
            } else {
                node = new TreeNode(Integer.parseInt(str));
                // left
                node.left = _deserialize(values, n, 2 * pos + 1);
                // right
                node.right = _deserialize(values, n, 2 * pos + 2);
            }
            return node;
        }

    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}