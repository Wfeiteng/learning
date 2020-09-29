//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组

package com.train.leetcode.editor.cn;

import com.train.leetcode.editor.cn.common.ArrayUtil;

import java.util.Arrays;

public class JumpGameIi45 {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi45().new Solution();
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int jump(int[] nums) {

            return _dp(nums);
            // return _greedy(nums);
        }

        /**
         * 思路和贪心基本一样，但是效率比贪心低很多,多个一个遍历，时间复杂度o(n^2)
         *
         * @param nums
         * @return
         */
        private int _dp(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, nums.length + 1);
            dp[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                // jump position
                int pos = Math.min(i + nums[i], nums.length - 1);
                for (int j = i + 1; j <= pos; j++) {
                    dp[j] = Math.min(dp[i] + 1, dp[j]);
                }
            }
            return dp[nums.length - 1];
        }

        /**
         * 贪心算法,时间复杂度:o(n)
         *
         * @param nums
         * @return
         */
        private int _greedy(int[] nums) {
            int longest = 0;
            // []
            int start = 0;
            int end = 0;
            int minJumpCnt = 0;
            // end为],end为最后一个时中止
            while (end < nums.length - 1) {
                //[],求[start,end]区间中最远，更新区间与步数
                for (int i = start; i <= end; i++) {
                    longest = Math.max(longest, i + nums[i]);
                }
                start = end + 1;
                end = longest;
                minJumpCnt++;
            }
            return minJumpCnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}