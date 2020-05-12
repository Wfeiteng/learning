//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

package com.train.leetcode.editor.cn;

public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix14().new Solution();
        String[] strs = {"asfg", "ashg", "asjk"};
        String value = solution.longestCommonPrefix(strs);
        System.out.println("" + value);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String commonPrefix = "";
            if (strs == null || strs.length == 0) {
                return commonPrefix;
            }
            int index = 0;
            int len = strs.length;
            String first = strs[0];
            while (index < first.length()) {
                boolean isSuccess = true;
                for (int i = 1; i < len; i++) {
                    if (index < strs[i].length()) {
                        int result = first.charAt(index) ^ strs[i].charAt(index);
                        if (result != 0) {
                            isSuccess = false;
                            break;
                        }
                    } else {
                        isSuccess = false;
                        break;
                    }
                }
                if (!isSuccess) {
                    break;
                }
                index++;
            }

            if (index > 0) {
                commonPrefix = first.substring(0, index);
            }
            return commonPrefix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}