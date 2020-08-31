//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
// Related Topics 回溯算法

package com.train.leetcode.editor.cn;

import javafx.geometry.Pos;

import java.util.*;

public class NQueens51 {
    public static void main(String[] args) {
        Solution solution = new NQueens51().new Solution();
        System.out.println(solution.solveNQueens(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            // todo
            List<List<String>> result = new ArrayList<>();
            _solveNQueens(n, 0, new HashSet<>(), new HashSet<>(), new ArrayDeque<>(), result);
            return result;
        }

        /**
         * @param n
         * @param row    行
         * @param pie
         * @param na
         * @param path
         * @param result
         */
        private void _solveNQueens(int n, int row, Set<Integer> pie, Set<Integer> na, Deque<Integer> path, List<List<String>> result) {
            if (path.size() == n) {
                result.add(makeResult(path));
                return;
            }

            for (int col = 0; col < n; col++) {
                // 不同列，不斜线重合
                if (path.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                    continue;
                }
                path.addLast(col);
                pie.add(row + col);
                na.add(row - col);
                _solveNQueens(n, row + 1, pie, na, path, result);
                path.removeLast();
                pie.remove(col + row);
                na.remove(row - col);
            }

        }

        private List<String> makeResult(Deque<Integer> path) {
            List<String> ans = new ArrayList<>();
            for (Integer pos : path) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < pos; i++) {
                    builder.append(".");
                }
                builder.append("Q");
                for (int i = pos + 1; i < path.size(); i++) {
                    builder.append(".");
                }
                ans.add(builder.toString());
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}