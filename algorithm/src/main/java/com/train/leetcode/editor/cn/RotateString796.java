//给定两个字符串, A 和 B。 
//
// A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后
//，A 能变成B，那么返回True。 
//
// 
//示例 1:
//输入: A = 'abcde', B = 'cdeab'
//输出: true
//
//示例 2:
//输入: A = 'abcde', B = 'abced'
//输出: false 
//
// 注意： 
//
// 
// A 和 B 长度不超过 100。 
// 
// 👍 91 👎 0

package com.train.leetcode.editor.cn;

public class RotateString796 {
    public static void main(String[] args) {
        Solution solution = new RotateString796().new Solution();
        boolean result = solution.rotateString("", "");
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean rotateString(String A, String B) {
            if (A.length() != B.length()) {
                return false;
            }
            int index = A.length();
            if (index == 0) {
                return true;
            }
            boolean result = false;
            for (int position = 0; position < index; position++) {
                char[] values = A.toCharArray();
                String tmp = reverse(values, position);
                if (tmp.equals(B)) {
                    result = true;
                    break;
                }
            }
            return result;

        }


        private String reverse(char[] values, int position) {
            int lengh = values.length;
            reverseOne(values, 0, position);
            reverseOne(values, position + 1, lengh - 1);
            reverseOne(values, 0, lengh - 1);
            return String.valueOf(values);
        }

        private void reverseOne(char[] value, int start, int end) {
            while (start < end) {
                char tmp = value[start];
                value[start++] = value[end];
                value[end--] = tmp;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}