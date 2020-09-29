package com.train.leetcode.editor.cn.common;

public class ArrayUtil {
    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
    }

    public static int[] buildIntArray(int... nums) {
        return nums;
    }
}
