//珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。 
//
// 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后
//这一小时内不会再吃更多的香蕉。 
//
// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。 
//
// 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入: piles = [3,6,7,11], H = 8
//输出: 4
// 
//
// 示例 2： 
//
// 输入: piles = [30,11,23,4,20], H = 5
//输出: 30
// 
//
// 示例 3： 
//
// 输入: piles = [30,11,23,4,20], H = 6
//输出: 23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 10^4 
// piles.length <= H <= 10^9 
// 1 <= piles[i] <= 10^9 
// 
// Related Topics 二分查找 
// 👍 99 👎 0

package com.train.leetcode.editor.cn;

public class KokoEatingBananas875 {
    public static void main(String[] args) {
        Solution solution = new KokoEatingBananas875().new Solution();
        System.out.println(solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int H) {
            //   return _minEatingSpeed(piles, H);
            return _minEatingSpeedByBinarySearch(piles, H);

        }

        /**
         * 二分查找，左侧边界
         *
         * @param piles
         * @param hour
         * @return
         */
        private int _minEatingSpeedByBinarySearch(int[] piles, int hour) {
            int left = 1, right = maxSpeed(piles);
            while (left < right) {
                int speed = left + (right - left) / 2;
                int costTime = costTime(piles, speed);
                if (costTime <= hour) {
                    right = speed;
                } else {
                    left = speed + 1;
                }
            }

            return right;
        }


        /**
         * 暴力方法,超时
         *
         * @param piles
         * @param hour
         * @return
         */
        private int _minEatingSpeed(int[] piles, int hour) {
            int maxSpeed = maxSpeed(piles);
            int initSpeed = 1;
            while (initSpeed <= maxSpeed) {
                int costTime = costTime(piles, initSpeed);
                System.out.println(initSpeed + " " + costTime + " " + hour);
                if (costTime <= hour) {
                    break;
                }
                initSpeed++;
            }
            return initSpeed;
        }

        int maxSpeed(int[] piles) {
            int ans = piles[0];
            for (int i = 1; i < piles.length; i++) {
                ans = Math.max(ans, piles[i]);
            }
            return ans;
        }

        int costTime(int[] piles, int speed) {
            int ans = 0;
            for (int i = 0; i < piles.length; i++) {
                int weight = piles[i];
                ans += (weight / speed) + (weight % speed == 0 ? 0 : 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}