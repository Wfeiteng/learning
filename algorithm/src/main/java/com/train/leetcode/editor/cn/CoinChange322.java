//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划 
// 👍 779 👎 0

package com.train.leetcode.editor.cn;

import java.util.Arrays;

public class CoinChange322 {
    public static void main(String[] args) {
        Solution solution = new CoinChange322().new Solution();
           System.out.println(solution.coinChange(new int[]{2}, 3));
        // System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
       System.out.println(solution.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            // todo 硬币
            //  return _greedy(coins, amount);
            return _dp(coins, amount);
        }

        /**
         * dp[i]=min{dp[i],dp[i-coin]+1,coin 属于coins}
         *
         * @param coins
         * @param amount
         * @return
         */
        private int _dp(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            for (int i = 1; i <= amount; i++) {
                dp[i] = amount + 1;
            }
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    int pos = i - coins[j];
                    if (pos < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[pos] + 1);
                }
            }
            if (dp[amount] > amount) {
                return -1;
            }
            return dp[amount];
        }

        /**
         * 纯贪心解决不了问题？？写的有错？
         * 失败原因解说:https://leetcode-cn.com/problems/coin-change/solution/dpqiu-jie-zui-xiao-ji-ci-ti-chang-jian-cuo-wu-fen-/
         *
         * @param coins
         * @param amount
         * @return
         */
        private int _greedy(int[] coins, int amount) {
            Arrays.sort(coins);
            int cnt = 0;
            for (int i = coins.length - 1; i >= 0; i--) {
                while (amount - coins[i] >= 0) {
                    cnt++;
                    amount -= coins[i];
                }
            }
            System.out.println(amount);
            if (amount != 0) {
                cnt = -1;
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}