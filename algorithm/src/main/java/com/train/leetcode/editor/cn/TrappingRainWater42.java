//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 1697 👎 0

package com.train.leetcode.editor.cn;

import java.util.IntSummaryStatistics;

public class TrappingRainWater42 {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater42().new Solution();
        System.out.println(solution._violence(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            if (height == null || height.length < 1) {
                return 0;
            }
            // return _violence(height);
            // return _memo(height);
            return _pointer(height);
        }

        /**
         * 双指针解法
         * ref: https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/jie-yu-shui
         *
         * @param height
         * @return
         */
        private int _pointer(int[] height) {
            int left = 0, right = height.length - 1;
            int leftMax = height[left], rightMax = height[right];
            int ans = 0;
            while (left <= right) {
                leftMax = Math.max(height[left], leftMax);
                rightMax = Math.max(height[right], rightMax);
                if (leftMax < rightMax) {
                    ans += leftMax - height[left];
                    left++;
                } else {
                    ans += rightMax - height[right];
                    right--;
                }
            }
            return ans;
        }

        /**
         * 暴力算法的优化，备忘录
         *
         * @param height
         * @return
         */
        private int _memo(int[] height) {
            int sum = 0;
            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];
            // 左边的最大值
            leftMax[0] = height[0];
            for (int i = 1; i < height.length; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }
            rightMax[height.length - 1] = height[height.length - 1];
            for (int i = height.length - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
            for (int i = 0; i < height.length; i++) {
                sum += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return sum;
        }

        /**
         * 暴力破解法,求i的盛水，分别找i的左右2侧最高点
         *
         * @param height
         * @return
         */
        private int _violence(int[] height) {
            int sum = 0;
            for (int i = 0; i < height.length; i++) {
                // 左边最高
                int leftHeight = _leftMaxHignt(height, i);
                // 右边最高
                int rightHight = _rightMaxHignt(height, i);
                int target = Math.min(leftHeight, rightHight) - height[i];
                // target有可能是负数，此时取0
                sum += target;
            }
            return sum;
        }

        private int _leftMaxHignt(int[] height, int i) {
            int left = i;
            int maxValue = height[i];
            while (left >= 0) {
                if (height[left] > maxValue) {
                    maxValue = height[left];
                }
                left--;
            }
            return maxValue;
        }

        private int _rightMaxHignt(int[] height, int i) {
            int right = i;
            int maxValue = height[i];
            while (right < height.length) {
                if (height[right] > maxValue) {
                    maxValue = height[right];
                }
                right++;
            }
            return maxValue;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}