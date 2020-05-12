//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package com.train.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters3().new Solution();
        String str ="abcabcbb";
        int max  = solution.lengthOfLongestSubstring(str);
        System.out.println(max);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int max = 0;
            if (s == null || "".equals(s)) {
                return max;
            }
            int length = s.length();
            Set<Character> wins = new HashSet<>(length > 256 ? 256 : length);
            char[] chars = s.toCharArray();
            int head = 0;
            int tail = 0;

            while (head < length && tail < length) {
                if (!wins.contains(chars[head])) {
                    wins.add(chars[head]);
                    max = Math.max(max,head-tail+1);
                    head++;
                } else {
                    wins.remove(chars[tail]);
                    tail++;
                }

            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}