//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 数学 二分查找

package com.train.leetcode.editor.cn;

public class DivideTwoIntegers29 {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers29().new Solution();
        System.out.println(solution.divide(-2147483648, 1));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            if (divisor == 0) {
                return 0;
            }
            if (dividend == Integer.MIN_VALUE && divisor == -1) { // min/-1->max
                return Integer.MAX_VALUE;

            }
            int result = 0;
            // x/y
            long x = Math.abs(dividend * 1l);
            long y = Math.abs(divisor * 1l);
            System.out.println(x + " " + y);
            for (int i = 31; i >= 0; i--) {
                if ((x >> i) >= y) {
                    result += 1 << i;
                    // << 位运算的优先级低，比+ - 还低，请注意
                    x = x - (y << i);
                    //  System.out.println("x:" + x + " i: " + i + " y:" + y + "y << i:" + (y << i));
                }
            }

            result = (dividend ^ divisor) >= 0 ? result : -1 * result;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}