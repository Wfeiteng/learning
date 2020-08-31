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

public class JumpGameIi45 {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi45().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int jump(int[] nums) {
            // todo
            //  return _dp(nums);
            return _greedy(nums);
        }

        private int _dp(int[] nums) {

            return 0;
        }

        /**
         * 贪心算法
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
                //[]
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