//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReverseNodesInKGroup25 {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(2, 3, 4, 5);
        ListNode head = new ListNode(1);
        ListNode first = head;
        for (int val : data) {
            ListNode tmp = new ListNode(val);
            first.next = tmp;
            first = first.next;
        }
        Solution solution = new ReverseNodesInKGroup25().new Solution();
        ListNode revert = solution.reverseKGroup(head, 5);
        while (revert != null) {
            System.out.println(revert.val);
            revert = revert.next;
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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k < 1) {
                return head;
            }
            ListNode start = head, end = head;
            ListNode pre = null;
            boolean init = false;
            while (Objects.nonNull(end)) {
                for (int i = 1; i < k; i++) {
                    end = end.next;
                    // 不满k个。
                    if (Objects.isNull(end)) {
                        if (pre != null) {
                            pre.next = start;
                        }
                        return head;
                    }
                }

                // [start,end)
                end = end.next;

                ListNode groupPre = reverse(start, end);
                start = end;
                // 拼接
                if (!init) {
                    init = true;
                    pre = groupPre;
                    head = pre;
                    while (Objects.nonNull(pre.next)) {
                        pre = pre.next;
                    }
                } else {
                    pre.next = groupPre;
                    while (Objects.nonNull(pre.next)) {
                        pre = pre.next;
                    }
                }

            }
            return head;
        }

        public ListNode reverse(ListNode start, ListNode end) {
            ListNode pre = null;
            while (Objects.nonNull(start) && start != end) {
                ListNode data = start;
                start = start.next;
                data.next = pre;
                pre = data;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}