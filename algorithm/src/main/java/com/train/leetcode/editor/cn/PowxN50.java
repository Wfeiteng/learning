//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找

package com.train.leetcode.editor.cn;

public class PowxN50 {
    public static void main(String[] args) {
        Solution solution = new PowxN50().new Solution();
        double value = solution.myPow(2, 10);
        System.out.println(value);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            double value = myPow2(x, n);
            if (n < 0) {
                return 1 / value;
            }
            return value;
        }

        /**
         * 递归方式
         *
         * @param x
         * @param n
         * @return
         */
        private double myPow1(double x, int n) {
            if (n == 0) {
                return 1;
            }
            double value = myPow1(x, n / 2);
            if ((n & 1) == 1) {
                // 奇数
                return x * value * value;
            } else {
                return value * value;
            }
        }

        /**
         * 非递归方式
         *
         * @param x
         * @param n
         * @return
         */
        private double myPow2(double x, int n) {
            double value = x;
            int flg = n;

            while (n != 1) {
                value = value * value;
                // n>>1 会把奇数的一个1抹去，故补偿一个。
                if ((n & 1) == 1) {
                    value = value * x;
                }
                n = n >> 1;
            }

            return value;
        }

        private double myPow3(double x, int n) {
            double value = 1;
            int flg = n;

            while (n != 0) {
                value = value * value;
                // n>>1 会把奇数的一个1抹去，故补偿一个。
                if ((n & 1) == 1) {
                    value = value * x;
                }
                n = n >> 1;
            }

            return value;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}