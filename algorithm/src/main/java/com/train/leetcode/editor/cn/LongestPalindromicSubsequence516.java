//给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。 
//
// 
//
// 示例 1: 
//输入: 
//
// "bbbab"
// 
//
// 输出: 
//
// 4
// 
//
// 一个可能的最长回文子序列为 "bbbb"。 
//
// 示例 2: 
//输入: 
//
// "cbbd"
// 
//
// 输出: 
//
// 2
// 
//
// 一个可能的最长回文子序列为 "bb"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含小写英文字母 
// 
// Related Topics 动态规划 
// 👍 282 👎 0

package com.train.leetcode.editor.cn;

public class LongestPalindromicSubsequence516 {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubsequence516().new Solution();
        System.out.println(solution._dp("bbbab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindromeSubseq(String s) {
            return _dp(s);
        }

        /**
         * dp[i][j] = s(i,j)的回文子串序列
         * dp[i][j] = dp[i+1][j-1]+2 if s[i]=s[j]
         * dp[i][j] = max(dp[i][j-1],dp[i+1][j])  s[i]!=s[j]
         *
         * @param s
         * @return
         */
        private int _dp(String s) {
            int len = s.length();
            int[][] dp = new int[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = 1;
            }

            for (int i = len - 2; i >= 0; i--) {
                for (int j = i + 1; j < len; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }
            //   print(dp);
            return dp[0][len - 1];
        }

        private void print(int[][] dp) {
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp.length; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}