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

import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
        Solution solution = new Subsets78().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            // todo  递归计算+树
            boolean[] xx = new boolean[nums.length];
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}