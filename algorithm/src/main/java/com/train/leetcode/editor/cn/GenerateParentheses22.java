//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法

package com.train.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses22().new Solution();
        List<String> paths = solution.generateParenthesis(3);
        System.out.println(paths);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> paths = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            if (n <= 0) {
                return paths;
            }
            // 方法二
            //  recur(n, 0, 0, "");
            char[] data = new char[2 * n];
            // 方法二
            recur2(2 * n, 0, data);
            return paths;
        }

        // 方法一 数学归纳法 n=1--> n=2 ---> n=3

        // 方法二 搜索（dfs）或搜索+剪枝
        private void recur(int n, int left, int right, String str) {
            if (n == left && n == right) {
                paths.add(str);
                return;
            }
            if (left < n) {
                recur(n, left + 1, right, str + "(");
            }
            if (right < left) {
                recur(n, left, right + 1, str + ")");
            }
        }

        private void recur2(int n, int level, char[] data) {
            if (level == n) {
                //校验
                if (valid(data)) {
                    paths.add(String.valueOf(data));
                }
                return;
            }
            data[level] = '(';
            recur2(n, level + 1, data);
            data[level] = ')';
            recur2(n, level + 1, data);
        }

        public boolean valid(char[] data) {
            int result = 0;
            for (int i = 0; i < data.length; i++) {

                if (data[i] == '(') {
                    result++;
                } else {
                    result--;
                }
                if (result < 0) {
                    return false;
                }
            }
            if (result != 0) {
                return false;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}