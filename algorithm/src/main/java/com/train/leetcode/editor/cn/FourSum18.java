//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针

package com.train.leetcode.editor.cn;

import java.util.*;

public class FourSum18 {
    public static void main(String[] args) {
        Solution solution = new FourSum18().new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};//{0,0,0,0};//{1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = solution.fourSum(nums, -1);
        System.out.print(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new LinkedList<>();
            int length = nums.length;
            if (Objects.isNull(nums) || nums.length < 4) {
                return result;
            }
            Arrays.sort(nums);
            for (int first = 0; first < length - 3; first++) {
                if (first >= 1 && nums[first] == nums[first - 1]) {
                    continue;
                }
                for (int a = first + 1; a < length - 2; a++) {
                    // 重复元素
                    if (a - 2 >= first && nums[a] == nums[a - 1]) {
                        continue;
                    }
                    int left = a + 1, right = length - 1;
                    while (left < right) {
                        int value = nums[first]+nums[a] + nums[left] + nums[right];
                        if (value > target) {
                            right--;
                        } else if (value < target) {
                            left++;
                        } else {
                            result.add(Arrays.asList(nums[first], nums[a], nums[left], nums[right]));
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

            }

            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}