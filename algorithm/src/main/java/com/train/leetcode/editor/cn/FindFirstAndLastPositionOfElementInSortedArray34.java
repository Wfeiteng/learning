//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找

package com.train.leetcode.editor.cn;


import com.sun.xml.internal.bind.v2.TODO;
import sun.security.util.Length;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray34().new Solution();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] targetIndex = solution.searchRange(nums, target);
        System.out.println(targetIndex[0] + " " + targetIndex[1]);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] bound = {-1, -1};
            if (nums == null || nums.length == 0) {
                return bound;
            }
            bound[0] = leftBound(nums, target);
            bound[1] = rightBound(nums, target);
            return bound;
        }

        private int leftBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid - 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            if (left == nums.length || nums[left] != target) {
                return -1;
            } else {
                return left;
            }

        }

        private int rightBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                }
            }

            if (right < 0 || nums[right] != target) {
                return -1;
            } else {
                return right;
            }
        }
    }
}

