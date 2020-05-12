//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划

package com.train.leetcode.editor.cn;


public class MinimumPathSum64 {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum64().new Solution();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int count = solution.minPathSum(grid);
        System.out.println(count);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid == null) {
                return 0;
            }
            int m = grid.length;
            int n = grid[0].length;
            int dp[][] = new int[m][n];
            int i = m - 2, j = n - 2;
            // 初始化
            dp[m - 1][n - 1] = grid[m - 1][n - 1];
            for (; i >= 0; i--) {
                dp[i][n - 1] = dp[i + 1][n - 1] + grid[i][n - 1];
            }
            for (; j >= 0; j--) {
                dp[m - 1][j] = dp[m - 1][j + 1] + grid[m - 1][j];
            }

            for (i = m - 2; i >= 0; i--) {
                for (j = n - 2; j >= 0; j--) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
                }
            }
            return dp[0][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}