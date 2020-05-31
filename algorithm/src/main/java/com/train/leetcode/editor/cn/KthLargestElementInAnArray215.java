//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法

package com.train.leetcode.editor.cn;

import java.lang.annotation.Target;
import java.util.Arrays;

public class KthLargestElementInAnArray215 {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray215().new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        //  int midIndex = solution.partion(nums, 0, nums.length - 1);
        int target = solution.findKthLargest(nums, 2);
        System.out.println(target);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // return heap(nums, k);
            return quickSort(nums, k);
        }

        /**
         * 方法一:快排方式
         *
         * @param nums
         * @param k
         * @return
         */
        public int quickSort(int[] nums, int k) {
            int left = 0;
            int right = nums.length - 1;
            int targetIndex = nums.length - k;
            int mid = partion(nums, left, right);
            while (mid != targetIndex) {
                if (mid > targetIndex) {
                    right = mid - 1;
                    mid = partion(nums, left, right);
                } else {
                    left = mid + 1;
                    mid = partion(nums, left, right);
                }
            }
            return nums[mid];
        }

        private int partion(int[] nums, int left, int right) {
            int target = nums[left];
            int base = left;
            while (left < right) {
                while (left < right && nums[right] >= target) {
                    right--;
                }
                while (left < right && nums[left] <= target) {
                    left++;
                }
                swap(nums, left, right);
            }
            nums[base] = nums[left];
            nums[left] = target;
            return left;
        }

        /**
         * 堆
         *
         * @return
         */
        public int heap(int[] nums, int k) {
            buildHeap(nums, k);
            for (int i = k; i < nums.length; i++) {
                if (nums[i] > nums[0]) {
                    swap(nums, 0, i);
                    sink(nums, k, 0);
                }
            }
            return nums[0];
        }


        private void buildHeap(int[] nums, int k) {
            for (int i = k / 2 - 1; i >= 0; i--) {
                sink(nums, k, i);
            }
        }

        /**
         * 下沉，最小堆
         *
         * @param nums
         * @param k        堆的大小
         * @param position 位置
         */
        private void sink(int[] nums, int k, int position) {
            int pos = position;
            int minPos = pos;
            while (true) {
                int left = pos * 2 + 1;
                int right = left + 1;
                if (left < k && nums[left] < nums[minPos]) {
                    minPos = left;
                }
                if (right < k && nums[right] < nums[minPos]) {
                    minPos = right;
                }
                if (minPos == pos) {
                    break;
                } else {
                    swap(nums, pos, minPos);
                    pos = minPos;
                }
            }

        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}