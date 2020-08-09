//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划

package com.train.leetcode.editor.cn;

public class MaximumSubarray53 {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray53().new Solution();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
       // int[] nums = new int[]{1};
        int maxSum = solution.maxSubArray(nums);
        System.out.println("maxSum:" + maxSum);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null) {
                return 0;
            }
            return maxSubArrayOne(nums);
        }

        private int maxSubArrayOne(int[] nums) {
            int size = nums.length;
            int max =  nums[0];
            int sum = nums[0];
            for (int i = 1; i < size; i++) {
                if (sum < 0) {
                    sum = 0;
                }
                sum += nums[i];
                if (sum > max) {
                    max = sum;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}