//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找 
// 👍 164 👎 0

package com.train.leetcode.editor.cn;

public class ValidPerfectSquare367 {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare367().new Solution();
      //  System.out.println(Math.sqrt(808201));
        System.out.println(solution.isPerfectSquare(808201));
    //    System.out.println(solution.isPerfectSquare(91));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            boolean ans = false;
            long left = 1, right = num/2+1;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                long square = mid * mid;
                System.out.println("mid:"+mid+"square:"+square+"left:"+left+"right:"+right);
                if (square == num) {
                    return true;
                } else if (square > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}