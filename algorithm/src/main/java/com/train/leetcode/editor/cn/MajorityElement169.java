//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法

package com.train.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {
    public static void main(String[] args) {
        Solution solution = new MajorityElement169().new Solution();
        System.out.println(solution.majorityElement(new int[]{6, 6, 6, 7, 7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            // map cnt release
            return _majorityElementByMap(nums);
        }

        /**
         * map计数
         *
         * @param nums
         * @return
         */
        private int _majorityElementByMap(int[] nums) {
            Map<Integer, Integer> cnt = new HashMap<>();
            // 奇数+1
            int targetCnt = nums.length / 2;
            if ((nums.length & 1) == 1) {
                targetCnt++;
            }

            int targetKey = nums[0];
            for (int num : nums) {
                if (!cnt.containsKey(num)) {
                    cnt.put(num, 1);
                } else {
                    int keyCnt = cnt.get(num) + 1;
                    cnt.put(num, keyCnt);
                    if (keyCnt >= targetCnt) {
                        targetKey = num;
                        break;
                    }
                }
            }
            return targetKey;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}