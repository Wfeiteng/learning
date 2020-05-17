//峰值元素是指其值大于左右相邻值的元素。 
//
// 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。 
//
// 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。 
//
// 你可以假设 nums[-1] = nums[n] = -∞。 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1]
//输出: 2
//解释: 3 是峰值元素，你的函数应该返回其索引 2。 
//
// 示例 2: 
//
// 输入: nums = [1,2,1,3,5,6,4]
//输出: 1 或 5 
//解释: 你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
// 
//
// 说明: 
//
// 你的解法应该是 O(logN) 时间复杂度的。 
// Related Topics 数组 二分查找

package com.train.leetcode.editor.cn;

public class FindPeakElement162 {
    public static void main(String[] args) {
        Solution solution = new FindPeakElement162().new Solution();
        int[] nums = {1,2,1,3,5,6,4};//{1, 2, 1, 3, 5, 6, 4};
        int index = solution.findPeakElement(nums);
        System.out.println(index);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            return findPeak(nums, 0, nums.length - 1);
        }

        private int findPeak2(int[] nums, int left, int right) {
            if (left == right) {
                return left;
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                return findPeak(nums, mid + 1, right);
            } else {
                return findPeak(nums, left, mid - 1);
            }
        }

        private int findPeak(int[] nums, int left, int right) {

            int mid = left + (right - left) / 2;
            while (left < right) {
                if (nums[mid] < nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}