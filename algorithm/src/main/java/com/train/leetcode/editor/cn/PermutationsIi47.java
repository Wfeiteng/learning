//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法 
// 👍 370 👎 0

package com.train.leetcode.editor.cn;

import java.util.*;

public class PermutationsIi47 {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi47().new Solution();
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> result = solution.permuteUnique(nums);
        System.out.println(result);
        Stack<Character> stack = new Stack();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }
            Arrays.sort(nums);
            Deque<Integer> path = new ArrayDeque<>();
            boolean[] used = new boolean[nums.length];

            _permuteUnique(nums, 0, used, path, result);
            return result;
        }


        private void _permuteUnique(int[] nums, int dep, boolean[] used, Deque<Integer> path, List<List<Integer>> result) {
            if (dep == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                // 剪枝
                if (used[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }

                path.addLast(nums[i]);
                used[i] = true;
                _permuteUnique(nums, dep + 1, used, path, result);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}