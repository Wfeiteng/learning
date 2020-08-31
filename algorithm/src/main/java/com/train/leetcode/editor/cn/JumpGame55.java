//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组 
// 👍 784 👎 0

package com.train.leetcode.editor.cn;

public class JumpGame55 {
    public static void main(String[] args) {
        Solution solution = new JumpGame55().new Solution();
        int[] nums = new int[]{0};
        System.out.println(solution.canJump(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null) {
                return false;
            }
            // return _canJump(nums);
            return _dp(nums);
        }

        private boolean _dp(int[] nums) {
            int maxFast = 0;
            // 只需要判断[n-1]能否跳到n处即可;
            for (int i = 0; i < nums.length - 1; i++) {
                // 计算最远距离
                maxFast = Math.max(i + nums[i], maxFast);
                // 最远距离小于当前位置，则false;
                if (maxFast <= i) {
                    return false;
                }
            }
            return maxFast >= nums.length - 1;
        }

        private boolean _canJump(int[] nums) {
            if (nums[0] == 0 && nums.length > 1) {
                return false;
            }
            // init
            boolean[] canJump = new boolean[nums.length];
            canJump[0] = true;

            for (int i = 0; i < nums.length; i++) {
                if (canJump[i]) {
                    for (int step = 1; step <= nums[i] && i + step < nums.length; step++) {
                        canJump[i + step] = true;
                    }
                } else {
                    return false;
                }
            }
            return canJump[nums.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}