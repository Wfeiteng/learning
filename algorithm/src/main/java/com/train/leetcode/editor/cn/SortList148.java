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
        // todo
        public ListNode sortList(ListNode head) {
            if (head != null) {
                return head;
            }
            return null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}