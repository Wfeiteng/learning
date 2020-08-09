//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串 
// 👍 236 👎 0

package com.train.leetcode.editor.cn;

public class RepeatedSubstringPattern459 {
    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern459().new Solution();
        boolean result = solution.repeatedSubstringPattern("aabaab");
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            char[] values = s.toCharArray();
            int size = values.length;
            if (size < 2) {
                return false;
            }
            for (int step = 1; step <= size / 2; step++) {
                boolean success = true;
                // 非倍数,一定不符合;
                if (size % step != 0) {
                   continue;
                }
                for (int i = 0; i < size - step; i++) {
                    if (values[i] != values[i + step]) {
                        success = false;
                        break;
                    }
                }

                if (success) {
                    return success;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}