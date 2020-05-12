//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.ListNode;
import com.train.leetcode.editor.cn.common.ListNodeUtil;

import java.util.Arrays;

public class RemoveNthNodeFromEndOfList19 {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList19().new Solution();
        ListNode head = ListNodeUtil.buildListNode(Arrays.asList(1, 2, 3, 4, 5, 6));
        head = solution.removeNthFromEnd(head, 6);
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

        public ListNode removeNthFromEnd(ListNode head, int k) {
            if (head == null) {
                return head;
            }
            ListNode fast = head;
            // 先走k步
            while (k > 0) {
                fast = fast.next;
                k--;
            }

            ListNode slow = head;
            ListNode pre = null;
            // fast停止在最后位置null，slow停止在倒数k的位置;
            while (fast != null) {
                fast = fast.next;
                pre = slow;
                slow = slow.next;
            }
            if (pre != null) {
                pre.next = slow.next;
            } else {
                // 删除首字母
                head = head.next;
            }


            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}