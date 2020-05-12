//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.ListNode;

import java.util.Objects;

public class SwapNodesInPairs24 {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs24().new Solution();
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
        public ListNode swapPairs(ListNode head) {
            if(Objects.isNull(head)){
                return head;
            }
            ListNode run1 = head;
            ListNode run2 = head.next;
            while(Objects.nonNull(run1)&&Objects.nonNull(run2)){
                int tmp = run1.val;
                run1.val=run2.val;
                run2.val=tmp;
                run1= run2.next;
                if(run2.next!=null){
                    run2 = run2.next.next;
                }
            }
        return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}