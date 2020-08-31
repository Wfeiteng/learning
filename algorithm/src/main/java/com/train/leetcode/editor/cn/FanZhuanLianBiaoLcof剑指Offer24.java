//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 86 👎 0

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.ListNode;

public class FanZhuanLianBiaoLcof剑指Offer24 {
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof剑指Offer24().new Solution();
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
             return _reverseFun1(head);
           // return _reverseFun2(head);
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
            ListNode last = _reverseFun2(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }


        /**
         * 迭代法
         *
         * @param head
         * @return
         */
        private ListNode _reverseFun2(ListNode head) {
            return null;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}