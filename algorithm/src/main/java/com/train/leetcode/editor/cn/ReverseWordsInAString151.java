//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 进阶： 
//
// 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 字符串 
// 👍 199 👎 0

package com.train.leetcode.editor.cn;

public class ReverseWordsInAString151 {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString151().new Solution();
        solution.reverseWords("  hello world!  ");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            int end = s.length() - 1;
            int start = end;
            char[] values = s.toCharArray();
            StringBuilder result = new StringBuilder();
            while (start >= 0) {
                while (start >= 0 && values[start] != ' ') {
                    start--;
                }
                result.append(String.valueOf(s.substring(start + 1, end + 1))).append(" ");
                while (start >= 0 && values[start] == ' ') {
                    start--;
                }
                end = start;
            }
            return result.toString().trim();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}