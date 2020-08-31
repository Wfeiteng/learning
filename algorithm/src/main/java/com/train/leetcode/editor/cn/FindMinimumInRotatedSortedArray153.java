//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 你可以假设数组中不存在重复元素。 
//
// 示例 1: 
//
// 输入: [3,4,5,1,2]
//输出: 1 
//
// 示例 2: 
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0 
// Related Topics 数组 二分查找

package com.train.leetcode.editor.cn;

public class FindMinimumInRotatedSortedArray153 {
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArray153().new Solution();
        int[] arrays = {4, 5, 6, 7, 0, 1, 2};
        int value = solution.findMin(arrays);
        System.out.println(value);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            if (nums == null) {
                return 0;
            }
            int left = 0;
            int right = nums.length - 1;
            // 因为left最多为nums[right],不存在left超出边界的情况。
            // 当left<=right时的终止条件为left=right+1,此时超出边界
            while (left < right) {
                int mid = left + (right - left) / 2;
                int midValue = nums[mid];
                if (nums[right] < midValue) {
                    // 向右端逼近
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}