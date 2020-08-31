//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 327 👎 0

package com.train.leetcode.editor.cn;

import java.util.*;

public class Combinations77 {
    public static void main(String[] args) {
        Solution solution = new Combinations77().new Solution();
        List<List<Integer>> result = solution.combine(4, 2);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            if (k > n || n <= 0 || k <= 0) {
                return result;
            }

            Deque<Integer> path = new ArrayDeque<>();
            _combine(n, k, 1, path, result);
            //  findCombinations(n, k, 1, new Stack<>(), result);
            return result;
        }


        private void findCombinations(int n, int k, int begin, Stack<Integer> pre, List<List<Integer>> res) {
            if (pre.size() == k) {
                // 够数了，就添加到结果集中
                res.add(new ArrayList<>(pre));
                return;
            }
            // 关键在于分析出 i 的上界
            for (int i = begin; i <= n; i++) {
                pre.add(i);
                findCombinations(n, k, i + 1, pre, res);
                int tmp = pre.pop();
                System.out.println("i:" + i + " tmp:" + tmp);
            }
        }


        private void _combine(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> result) {
            if (k == path.size()) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = begin; i <= n; i++) {
                path.addLast(i);
                // 不能使用begin+1,可以理解为第一层begin为1，则1，，，n,第二层为2.....n+1,因此针对这个选择，begin应该为i+1;
                /**
                 *  1,2,3,4
                 *  234,34,4,null
                 *
                 *  层数:begin+1
                 *
                 */
                _combine(n, k, i + 1, path, result);
                int tmp = path.removeLast();
                // System.out.println("begin:" + begin + " i:" + i + " tmp:" + tmp);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}