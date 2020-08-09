//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1176 👎 0

package com.train.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs70 {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs70().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, Integer> cache = new HashMap<>();

        public int climbStairs(int n) {
            if (n <= 0) {
                return 0;
            }
            //  return reverse(n);
            return dp(n);
        }

        private int dp(int n) {
            if (n <= 2) {
                return n;
            }
            int tmp1 = 1, tmp2 = 2;
            int result = 0;
            for (int i = 3; i <= n; i++) {
                result = tmp1 + tmp2;
                tmp1 = tmp2;
                tmp2 = result;
            }
            return result;
        }

        /**
         * 递归写法
         *
         * @param n
         * @return
         */
        private int reverse(int n) {
            if (n <= 2) {
                return n;
            }
            if (cache.containsKey(n)) {
                return cache.get(n);
            }
            int num = reverse(n - 1) + reverse(n - 2);
            cache.put(n, num);
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}