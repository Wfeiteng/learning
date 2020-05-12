//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

package com.train.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum1 {
    public static void main(String[] args) {
        Solution solution = new TwoSum1().new Solution();
        int[] nums = {3, 3};
        int[] indexs = solution.twoSum(nums, 6);
        for (int index : indexs) {
            System.out.print(indexs[index] + " ");
            System.out.print(nums[indexs[index]] + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            /**
             * key:value
             * value:index
             */
            HashMap<Integer, List<Integer>> mapping = new HashMap<>();
            int[] index = new int[2];
            int length = nums.length;
            for (int j = 0; j < length; j++) {
                if (mapping.containsKey(nums[j])) {
                    mapping.get(nums[j]).add(j);
                } else {
                    List<Integer> location = new ArrayList<>();
                    location.add(j);
                    mapping.put(nums[j], location);
                }

            }

            for(Map.Entry<Integer,List<Integer>> first: mapping.entrySet()){
                int second = target - first.getKey();
                if (mapping.containsKey(second)) {
                    if (second == first.getKey()) {
                        if (first.getValue().size() >= 2) {
                            index[0] = first.getValue().get(0);
                            index[1] = first.getValue().get(1);
                            break;
                        }
                    } else {
                        index[0] = first.getValue().get(0);
                        index[1] = mapping.get(second).get(0);
                        break;
                    }

                }
            }


            return index;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}