//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 843 👎 0

package com.train.leetcode.editor.cn;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber17 {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber17().new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            Map<Character, String> target = new HashMap<>();
            target.put('2', "abc");
            target.put('3', "def");
            target.put('4', "ghi");
            target.put('5', "jkl");
            target.put('6', "mno");
            target.put('7', "pqrs");
            target.put('8', "tuv");
            target.put('9', "wxyz");
            List<String> ans = new ArrayList<>();
            if ("".equals(digits)) {
                return ans;
            }
            _letterCombinations(digits, 0, target, "", ans);
            return ans;
        }

        /**
         * 解答成功:
         * 执行耗时:7 ms,击败了33.24% 的Java用户
         * 内存消耗:40.2 MB,击败了11.53% 的Java用户 why?? 这么低??
         *
         * @param digits
         * @param level
         * @param target
         * @param value
         * @param ans
         */
        void _letterCombinations(String digits, int level, Map<Character, String> target, String value, List<String> ans) {
            if (level == digits.length()) {
                ans.add(value);
                return;
            }
            // 获取数字对应的字母
            String tmp = target.get(digits.charAt(level));
            for (int i = 0; i < tmp.length(); i++) {
                _letterCombinations(digits, level + 1, target, value + tmp.charAt(i), ans);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}