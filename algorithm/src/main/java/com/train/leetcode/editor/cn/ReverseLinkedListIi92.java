//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.ListNode;
import com.train.leetcode.editor.cn.common.ListNodeUtil;

import java.util.Arrays;

public class ReverseLinkedListIi92 {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi92().new Solution();
        ListNode head = ListNodeUtil.buildListNode(Arrays.asList(1, 2, 3, 4, 5));
        head = solution.reverseBetween(head, 2, 4);
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
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode root = new ListNode(0);
            root.next = head;
            ListNode pre = root;
            ListNode mNode = root;
            int step = 0;
            while (step < m) {
                pre = mNode;
                mNode = mNode.next;
                step++;
            }

            while (step < n) {
                // 头插法
                ListNode removed = mNode.next;
                mNode.next = mNode.next.next;
                removed.next = pre.next;
                pre.next = removed;
                step++;
            }
            return root.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}