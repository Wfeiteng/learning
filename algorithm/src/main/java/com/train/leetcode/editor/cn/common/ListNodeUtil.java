package com.train.leetcode.editor.cn.common;

import java.util.List;

public class ListNodeUtil {
    public static ListNode buildListNode(List<Integer> arrays) {
        ListNode head = new ListNode(0);
        ListNode opt = head;
        for (Integer value : arrays) {
            ListNode tmp = new ListNode(value);
            opt.next = tmp;
            opt = opt.next;
        }
        return head.next;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
