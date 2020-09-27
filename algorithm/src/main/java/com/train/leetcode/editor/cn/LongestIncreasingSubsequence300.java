//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划 
// 👍 950 👎 0

package com.train.leetcode.editor.cn;

import java.util.Arrays;

public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence300().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            return _dp(nums);
        }

        /**
         * dp[i] 表示以nums[i]结尾的最长
         *
         * @param nums
         * @return
         */
        private int _dp(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            Arrays.fill(dp, 1);
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int max = dp[0];
            for (int val : dp) {
                if (val > max) {
                    max = val;
                }
            }
            return max;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}