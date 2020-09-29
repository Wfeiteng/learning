//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 648 👎 0

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.ListNode;
import com.train.leetcode.editor.cn.common.ListNodeUtil;

import javax.xml.soap.Node;
import java.util.Arrays;

public class PalindromeLinkedList234 {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList234().new Solution();
        ListNodeUtil.printListNode(solution.getMid(ListNodeUtil.buildListNode(Arrays.asList(1, 2, 3, 4))));
        System.out.println(solution.isPalindrome(ListNodeUtil.buildListNode(Arrays.asList(1, 2, 1))));
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
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            return _isPalindrome(head);
        }

        private boolean _isPalindrome(ListNode head) {
            ListNode mid = getMid(head);
            ListNode tail = reverse(mid);

            ListNode first = head;
            while (tail != first && first != mid) {
                if (tail.val != first.val) {
                    return false;
                }
                tail = tail.next;
                first = first.next;
            }
            return true;
        }

        private ListNode reverse(ListNode mid) {
            ListNode p1 = mid;
            ListNode p2 = mid.next;
            p1.next = null;
            while (p2 != null) {
                ListNode tmp = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = tmp;
            }
            return p1;
        }

        private ListNode getMid(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}