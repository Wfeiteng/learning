//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法

package com.train.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
        Solution solution = new Subsets78().new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            // todo  递归计算+树
            List<List<Integer>> result = new ArrayList<>();
            //  recursion(nums, 0, new ArrayDeque<>(), result);
            iteration(nums, result);
            return result;
        }

        /**
         * 方法一:递归
         *
         * @param nums
         * @return
         */
        private void recursion(int[] nums, int start, Deque<Integer> path, List<List<Integer>> result) {
            // 终止
            result.add(new ArrayList<Integer>(path));
            for (int i = start; i < nums.length; i++) {
                path.addLast(nums[i]);
                recursion(nums, i + 1, path, result);
                path.removeLast();
            }

        }

        /**
         * 方法二:迭代
         *
         * @param nums
         * @param result
         */
        private void iteration(int[] nums, List<List<Integer>> result) {
            // init
            result.add(new ArrayList<>());

            for (int i = 0; i < nums.length; i++) {
                int size = result.size();
                for (int j = 0; j < size; j++) {
                    List<Integer> target = result.get(j);
                    List<Integer> tmp = new ArrayList<>(target);
                    tmp.add(nums[i]);
                    result.add(tmp);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}