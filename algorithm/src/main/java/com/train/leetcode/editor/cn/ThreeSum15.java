//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

package com.train.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ThreeSum15 {
    public static void main(String[] args) {
        Solution solution = new ThreeSum15().new Solution();
        int[] nums = {0,0,0,0};//{-1, 0, 1, 2, -1, -4};// {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.print(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();
            if (Objects.isNull(nums) || nums.length < 3) {
                return result;
            }
            Arrays.sort(nums);
            int length = nums.length;
            for (int a = 0; a < length - 2; a++) {
                // 重复元素
                if (a >= 1 && nums[a] == nums[a - 1]) {
                    continue;
                }
                int left = a + 1, right = length - 1;
                while (left < right) {
                    int value = nums[a] + nums[left] + nums[right];
                    if (value > 0) {
                        right--;
                    } else if (value < 0) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[a], nums[left], nums[right]));
                        // 避免重复
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }

                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}