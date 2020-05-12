//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.ListNode;

import java.util.Objects;

public class ReverseLinkedList206 {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList206().new Solution();
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
        public ListNode reverseList(ListNode head) {
            ListNode newHead=null, cur = null;
            while (Objects.nonNull(head)) {
                cur = head;
                head = head.next;
                cur.next = newHead;
                newHead = cur;
            }
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}