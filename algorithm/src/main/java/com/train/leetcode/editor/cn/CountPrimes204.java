//统计所有小于非负整数 n 的质数的数量。 
//
// 示例: 
//
// 输入: 10
//输出: 4
//解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
// Related Topics 哈希表 数学 
// 👍 439 👎 0

package com.train.leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Arrays;

public class CountPrimes204 {
    public static void main(String[] args) {
        Solution solution = new CountPrimes204().new Solution();
        System.out.println(solution._sumary(499979));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            return _sumary(n);
        }

        private int _sumary(int n) {
            int ans = 0;
            boolean[] flg = new boolean[n];
            Arrays.fill(flg, true);
            // 在2开始
            for (int i = 2; i < n; i++) {
                if (flg[i]) {
                    // 素数的倍数
                    for (long j = (long)i * (long)i; j < n; j = j + i) {
                        flg[(int) j] = false;
                    }
                }
            }

            for (int i = 2; i < n; i++) {
                if (flg[i]) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}