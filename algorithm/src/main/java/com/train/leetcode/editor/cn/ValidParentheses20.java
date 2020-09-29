//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1885 👎 0

package com.train.leetcode.editor.cn;

import java.util.Stack;

public class ValidParentheses20 {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses20().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s == null) {
                return true;
            }
            int len = s.length();
            Stack<Character> ans = new Stack<>();
            for (int i = 0; i < len; i++) {
                char character = s.charAt(i);
                if (character == '(') {
                    ans.push(')');
                } else if (character == '[') {
                    ans.push(']');
                } else if (character == '{') {
                    ans.push('}');
                } else {
                    if (ans.isEmpty() || ans.pop() != character) {
                        return false;
                    }
                }
            }
            return ans.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}