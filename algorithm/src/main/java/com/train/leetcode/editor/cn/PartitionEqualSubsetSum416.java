//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 382 👎 0

package com.train.leetcode.editor.cn;

public class PartitionEqualSubsetSum416 {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum416().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            return _dp(nums);
        }

        /**
         * @param nums
         * @return
         */
        private boolean _dp(int[] nums) {
            return false;
        }

        // ref:https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485103&idx=1&sn=8a9752e18ed528e5c18d973dcd134260&chksm=9bd7f8a7aca071b14c736a30ef7b23b80914c676414b01f8269808ef28da48eb13e90a432fff&scene=21#wechat_redirect
    }
//leetcode submit region end(Prohibit modification and deletion)

}