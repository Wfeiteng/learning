package com.train.leetcode;


import com.train.leetcode.editor.cn.common.ListNode;
import com.train.leetcode.editor.cn.common.ListNodeUtil;

import java.util.Arrays;

/**
 * @author zhengtengwang
 */
public class Main {

    public static void main(String[] args) {
       ListNode head = ListNodeUtil.buildListNode(Arrays.asList(1,2,3,4,5));
       Main main = new Main();
       ListNode root = main.deletedNNode(head,2);
       ListNodeUtil.printListNode(root);
    }

    public ListNode deletedNNode(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        if (n < 0) {
            return head;
        }
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode fast = root;
        ListNode slow = root;
        ListNode preSlow = root;
        int step = 0;
        while (step < n && fast != null) {
            fast = fast.next;
            step++;
        }
        if (fast == null) {
            return root.next;
        }
        while (fast != null) {
            fast = fast.next;
            preSlow = slow;
            slow = slow.next;
        }
        preSlow.next = slow.next;
        return root.next;

    }
}
