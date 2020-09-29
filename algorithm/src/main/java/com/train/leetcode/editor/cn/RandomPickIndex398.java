//给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。 
//
// 注意： 
//数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。 
//
// 示例: 
//
// 
//int[] nums = new int[] {1,2,3,3,3};
//Solution solution = new Solution(nums);
//
//// pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
//solution.pick(3);
//
//// pick(1) 应该返回 0。因为只有nums[0]等于1。
//solution.pick(1);
// 
// Related Topics 蓄水池抽样 
// 👍 77 👎 0

package com.train.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickIndex398 {
    public static void main(String[] args) {
        Solution solution = new RandomPickIndex398().new Solution(new int[]{1});
        System.out.println(solution.pick(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Random r;
        int[] nums;

        //空间复杂度若要求为o(n),可以使用hashMap<Integer,List>
        // 空间复杂度为O(1),则时间来凑
        public Solution(int[] nums) {
            r = new Random();
            this.nums = nums;
        }

        public int pick(int target) {
            // return _pick1(target);
            return _pick2(target);
        }

        private Integer _pick2(int target) {
            int ans = 0;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    // 1/cnt
                    if (r.nextInt(++cnt) == 0) {
                        ans = i;
                    }
                }
            }
            return ans;
        }

        private Integer _pick1(int target) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    tmp.add(i);
                }
            }
            return tmp.get(r.nextInt(tmp.size()));
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
//leetcode submit region end(Prohibit modification and deletion)

}