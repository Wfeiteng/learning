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
            if (head == null) {
                return head;
            }
            // return raw(head);
            //  return _reverseFun1(head);
            //  return _reverseFun2(head);
            return _reverseFun2(head);
        }

        /**
         * 头插法
         *
         * @param head
         * @return
         */
        public ListNode raw(ListNode head) {
            ListNode newHead = null, cur = null;
            while (Objects.nonNull(head)) {
                cur = head;
                head = head.next;
                cur.next = newHead;
                newHead = cur;
            }
            return newHead;
        }


        /**
         * 递归法
         *
         * @param head
         * @return
         */
        private ListNode _reverseFun1(ListNode head) {
            if (head.next == null) {
                return head;
            }
            ListNode last = _reverseFun1(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }


        /**
         * 迭代法,指向反转
         *
         * @param head
         * @return
         */
        private ListNode _reverseFun2(ListNode head) {
            ListNode pre, cur;
            pre = head;
            cur = pre.next;
            pre.next = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            //  System.out.println(head.val+"-"+pre.val);
            return pre;
        }

        private ListNode _reverseFun2_1(ListNode head) {
            ListNode pre = null, cur;
            cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            //  System.out.println(head.val+"-"+pre.val);
            return pre;
        }

        /**
         * 头插法
         *
         * @param head
         * @return
         */
        private ListNode _reverseFun3(ListNode head) {
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}