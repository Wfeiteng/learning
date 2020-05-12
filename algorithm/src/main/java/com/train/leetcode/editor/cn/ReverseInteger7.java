//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学

package com.train.leetcode.editor.cn;

public class ReverseInteger7 {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger7().new Solution();
        int rawValue = 1463847412;
        int result = solution.reverse(rawValue);
        System.out.println("rawValue:" + rawValue + " result:" + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int result = 0;
            int newValue = x;
            while (newValue != 0) {
                int mod = newValue % 10;
                if ((result<=Integer.MAX_VALUE/10 )&&(result >= (Integer.MIN_VALUE ) / 10)) {
                    result = result * 10 + mod;
                    newValue = newValue / 10;
                }else{
                    return 0;
                }

            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}