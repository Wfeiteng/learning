//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 399 👎 0

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.ListNode;
import com.train.leetcode.editor.cn.common.ListNodeUtil;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedList83 {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList83().new Solution();
        ListNode head = ListNodeUtil.buildListNode(Arrays.asList(new Integer[]{1, 1, 2, 3, 3}));
        head = solution.deleteDuplicates(head);
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
        public ListNode deleteDuplicates(ListNode head) {

            return _point(head);
        }

        private ListNode _point(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode slow = head, fast = slow.next;
            while (fast != null) {
                if (slow.val == fast.val) {
                    // 删除
                    slow.next = fast.next;
                } else {
                    slow = slow.next;
                }
                fast = fast.next;
            }

            return head;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}