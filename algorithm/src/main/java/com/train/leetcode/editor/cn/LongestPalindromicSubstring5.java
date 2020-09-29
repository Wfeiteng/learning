//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

package com.train.leetcode.editor.cn;

import java.util.Objects;

public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring5().new Solution();
        String value = "aacdefcaa";//""abadd";// "cbbd";
        String maxValue = solution.longestPalindrome(value);
        System.out.println(maxValue);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 中心轴法
         *
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            char[] values = s.toCharArray();
            int length = s.length();
            int len = 0;
            int midPos = 0;
            String palindrom = "";
            for (int pos = 0; pos < length; pos++) {
                //pos为轴
                int len1 = getLen(values, pos, pos);
                // (pos,pos+1)的为轴
                int len2 = getLen(values, pos, pos + 1);
                if (len1 > len) {
                    midPos = pos;
                    len = len1;
                }
                if (len2 > len) {
                    midPos = pos;
                    len = len2;
                }
            }
            palindrom = s.substring(midPos - (len - 1) / 2, midPos + len / 2 + 1);
            return palindrom;
        }

        private int getLen(char[] values, int left, int right) {
            int l = left;
            int r = right;
            int max = values.length;
            while (l >= 0 && r < max && values[l] == values[r]) {
                l--;
                r++;
            }
            return (r - l - 1);
        }


        /**
         * 方法一: 暴力法,
         *
         * @param s
         * @return
         */
        public String longestPalindromeIter(String s) {
            if (s == null) {
                return "";
            }
            int length = s.length();
            int start = 0;
            String maxValue = "";
            for (; start < length; start++) {
                for (int end = length - 1; end >= start; end--) {
                    if (isPalindrome(s, start, end)) {
                        if (maxValue.length() < (end - start + 1)) {
                            maxValue = s.substring(start, end + 1);
                        }
                    }
                }
            }
            return maxValue;

        }

        private boolean isPalindrome(String value, int start, int end) {
            boolean palindrome = true;
            while (start < end) {
                if (value.charAt(start) == value.charAt(end)) {
                    start++;
                    end--;
                } else {
                    palindrome = false;
                    break;
                }
            }
            return palindrome;
        }


        /**
         * 动态规划: s与s.reverse()的最长公共字串--> 有错误
         * ref:https://juejin.im/post/6844903901884317709
         *
         * @param s
         * @return
         */
        public String longestPalindromeDp(String s) {
            // todo dp 咋求
            return "";
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}