//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 318 👎 0

package com.train.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString438 {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString438().new Solution();
         List<Integer> result = solution.findAnagrams("aaacab", "aab");
       // List<Integer> result = solution.findAnagrams("baa", "aa");
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            if (s == null || p == null || p.length() > s.length()) {
                return new ArrayList<>();
            }
            return slidingWindow(s, p);
        }

        List<Integer> slidingWindow(String s, String p) {
            List<Integer> result = new ArrayList<>();
            int[] need = new int[26];
            int[] win = new int[26];
            int left = 0, right = 0, valid = 0;
            char[] value = s.toCharArray();
            int endIndex = value.length - 1;
            for (char c : p.toCharArray()) {
                need[c - 'a']++;
            }
            int needSize = 0;
            for (int x : need) {
                if (x != 0) {
                    needSize++;
                }
            }

            while (right <= endIndex) {
                //右侧入窗
                char c = value[right++];
                win[c - 'a']++;
                if (win[c - 'a'] == need[c - 'a']) {
                    valid++;
                }

                while (right - left >= p.length()) {
                    //   System.out.println(s.substring(left, right) + " " + valid);
                    if (valid == needSize) {
                        result.add(left);
                    }
                    // 收缩窗口
                    int leftChar = value[left] - 'a';
                    if (win[leftChar] == need[leftChar]) {
                        valid--;
                    }
                    win[value[left++] - 'a']--;
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}