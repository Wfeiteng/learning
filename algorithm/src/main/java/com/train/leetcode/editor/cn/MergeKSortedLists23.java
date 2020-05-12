//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.ListNode;
import com.train.leetcode.editor.cn.common.ListNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKSortedLists23 {
    public static void main(String[] args) {
      /*  测试用例:[[1,4,5],[1,3,4],[2,6]]
        测试结果:[2,6,1,3,4,1,4,5]
        期望结果:[1,1,2,3,4,4,5,6]
        */

        Solution solution = new MergeKSortedLists23().new Solution();
        List<ListNode> nodes = new ArrayList<>();
        nodes.add(ListNodeUtil.buildListNode(Arrays.asList(1, 4, 5)));
        nodes.add(ListNodeUtil.buildListNode(Arrays.asList(1, 3, 4)));
        nodes.add(ListNodeUtil.buildListNode(Arrays.asList(2, 6)));
        ListNode[] arrays = new ListNode[3];
        nodes.toArray(arrays);
        ListNode node = solution.mergeKLists(arrays);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {

        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            /**
             * 递归调用
             */
            // return mergeListDiGui(lists, 0, lists.length - 1);
            /**
             * 迭代调用
             */
            return mergeListNodeIter(lists);
        }

        /**
         * 迭代模式的解法
         *
         * @param lists
         * @return
         */
        private ListNode mergeListNodeIter(ListNode[] lists) {
            int k = lists.length;
            while (k != 1) {
                int cnt = 0;
                for (int i = 0; i < k; i = i + 2) {
                    if (i == k - 1) {
                        lists[cnt++] = lists[i];
                    } else if (i + 1 < k) {
                        lists[cnt++] = merge2List(lists[i], lists[i + 1]);
                    }
                }
                k = cnt;
            }
            return lists[0];
        }

        /**
         * 递归方法
         *
         * @param lists
         * @param left
         * @param right
         * @return
         */
        private ListNode mergeListDiGui(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            int mid = left + (right - left) / 2;
            ListNode l1 = mergeListDiGui(lists, left, mid);
            ListNode l2 = mergeListDiGui(lists, mid + 1, right);
            return merge2List(l1, l2);
        }

        private ListNode merge2List(ListNode one, ListNode two) {
            ListNode head = new ListNode(0);
            ListNode first = head;
            while (one != null && two != null) {
                if (one.val < two.val) {
                    head.next = one;
                    one = one.next;
                } else {
                    head.next = two;
                    two = two.next;
                }
                head = head.next;
            }
            if (one != null) {
                head.next = one;
            }
            if (two != null) {
                head.next = two;
            }
            return first.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}