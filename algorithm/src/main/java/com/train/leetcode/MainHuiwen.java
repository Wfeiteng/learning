package com.train.leetcode;

import com.train.leetcode.editor.cn.common.ListNode;


/**
 * @author zhengtengwang
 */
public class MainHuiwen {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        MainHuiwen entry = new MainHuiwen();
        String str = "5656bascabbacuiuhbab";
        String subStr = entry.getMaxHuiWen(str);
        System.out.println(subStr);
    }

    public String getMaxHuiWen(String str) {

        if (str == null || "".equalsIgnoreCase(str)) {
            return str;
        }
        int length = str.length();
        int maxLen = 0;
        int position = 0;
        char[] strValues = str.toCharArray();
        for (int i = 0; i < length; i++) {
            int len1 = getMaxLen(strValues, i, i);
            int len2 = getMaxLen(strValues, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                position = i;
            }
        }
        int start = position - (maxLen - 1) / 2;
        int end = position + maxLen / 2;
        return str.substring(start, end + 1);
    }

    private int getMaxLen(char[] str, int left, int right) {
        int length = str.length;
        int low = left;
        int hight = right;
        while (low >= 0 && hight < length) {
            if (str[low] == str[hight]) {
                low--;
                hight++;
            } else {
                break;
            }
        }
        return (hight - low - 1);
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
