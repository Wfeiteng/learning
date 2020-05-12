//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.ListNode;
import com.train.leetcode.editor.cn.common.ListNodeUtil;

import java.util.Arrays;

public class SortList148 {

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.buildListNode(Arrays.asList(-1, 5, 3, 4, 0));
        Solution solution = new SortList148().new Solution();
        head = solution.sortList(head);
        ListNodeUtil.printListNode(head);
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
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode first = head, tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            return guibing(first, tail);
        }

        private ListNode guibing(ListNode head, ListNode tail) {
            if (head == tail) {
                return head;
            }
            ListNode mid = getMid(head);
            ListNode l2Start = mid.next;
            mid.next = null;
            ListNode l1 = guibing(head, mid);
            ListNode l2 = guibing(l2Start, tail);
            return merge(l1, l2);
        }

        /**
         * 2个链表合并
         *
         * @param l1
         * @param l2
         * @return
         */
        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode root = new ListNode(0);
            ListNode head = root;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    root.next = l1;
                    l1 = l1.next;
                } else {
                    root.next = l2;
                    l2 = l2.next;
                }
                root = root.next;
            }

            if (l1 != null) {
                root.next = l1;
            }
            if (l2 != null) {
                root.next = l2;
            }
            return head.next;
        }

        /**
         * 得到中间值
         *
         * @param head
         * @return
         */
        private ListNode getMid(ListNode head) {
            ListNode root = new ListNode(0);
            root.next = head;
            ListNode slow = root, fast = root;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}