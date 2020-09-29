//给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。 
//
// 进阶: 
//如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？ 
//
// 示例: 
//
// 
//// 初始化一个单链表 [1,2,3].
//ListNode head = new ListNode(1);
//head.next = new ListNode(2);
//head.next.next = new ListNode(3);
//Solution solution = new Solution(head);
//
//// getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
//solution.getRandom();
// 
// Related Topics 蓄水池抽样 
// 👍 86 👎 0

package com.train.leetcode.editor.cn;

import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;
import com.train.leetcode.editor.cn.common.ListNode;
import com.train.leetcode.editor.cn.common.ListNodeUtil;

import java.util.Arrays;
import java.util.Random;

public class LinkedListRandomNode382 {
    public static void main(String[] args) {
        ListNode head = ListNodeUtil.buildListNode(Arrays.asList(1, 2, 3));
        Solution solution = new LinkedListRandomNode382().new Solution(head);
        System.out.println(solution.getRandom());
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

        ListNode head;
        Random random;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {

            int res = 0, i = 0;
            ListNode p = head;
            while (p != null) {
                // 等于0的概率是1/i
                if (random.nextInt(++i) == 0) {
                    res = p.val;
                }
                p = p.next;
            }
            return res;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}