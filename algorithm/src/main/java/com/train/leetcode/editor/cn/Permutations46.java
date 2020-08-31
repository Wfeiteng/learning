//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 831 👎 0

package com.train.leetcode.editor.cn;

import java.util.*;

public class Permutations46 {
    public static void main(String[] args) {
        Solution solution = new Permutations46().new Solution();
        List<List<Integer>> result = solution.permute(new int[]{1, 2, 3});
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }
            boolean[] used = new boolean[nums.length];
            permute(nums, 0, used, new ArrayDeque<Integer>(), result);
            // permute(nums, 0, new ArrayDeque<>(), result);
            return result;
        }

        /**
         * 带剪枝功能
         *
         * @param nums
         * @param dep
         * @param used
         * @param value
         * @param result
         */
        private void permute(int[] nums, int dep, boolean[] used, ArrayDeque<Integer> value, List<List<Integer>> result) {
            if (dep == nums.length) {
                result.add(new ArrayList<>(value));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                value.addLast(nums[i]);
                used[i] = true;
                permute(nums, dep + 1, used, value, result);
                used[i] = false;
                value.removeLast();
            }
        }


        /**
         * 全排列-递归，使用Deque,使用List上次出错了
         *
         * @param nums
         * @param depth
         * @param value
         * @param result
         */
        private void permute(int[] nums, int depth, Deque<Integer> value, List<List<Integer>> result) {
            if (depth == nums.length) {
                if (isValid(value)) {
                    result.add(new ArrayList<>(value));
                }
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                value.addLast(nums[i]);
                permute(nums, depth + 1, value, result);
                value.removeLast();
            }
        }

        private boolean isValid(Deque<Integer> value) {
            Set<Integer> valid = new HashSet<>();
            for (Integer var : value) {
                if (valid.contains(var)) {
                    return false;
                }
                valid.add(var);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}