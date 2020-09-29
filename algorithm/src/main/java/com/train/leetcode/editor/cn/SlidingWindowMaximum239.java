//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
// Related Topics 堆 Sliding Window

package com.train.leetcode.editor.cn;

import java.util.*;

public class SlidingWindowMaximum239 {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum239().new Solution();
        int[] nums = {1, 3, 1, 2, 0, 5};
        int[] result = solution.maxSlidingWindow(nums, 3);
        for (int val : result) {
            System.out.println(val + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            List<Integer> window = new ArrayList<>();
            if (Objects.isNull(nums) || k < 1) {
                return convertArray(window);
            }
            Deque<Integer> que = new ArrayDeque<>();
            int size = nums.length;
           /* for (int i = 0; i < size; i++) {
                if (que.isEmpty()) {
                    que.offerLast(i);
                } else {
                    if (i - que.peekFirst() == k) {
                        que.pollFirst();
                    }
                    // n>deq[0] 则deq出队列。
                    while (!que.isEmpty() && nums[que.peekFirst()] < nums[i]) {
                        que.pollFirst();
                    }
                    // n>n-1,则n-1出队列。
                    while (!que.isEmpty() && nums[que.peekLast()] < nums[i]) {
                        que.pollLast();
                    }
                    que.offerLast(i);
                }
                if (i >= k - 1) {
                    window.add(nums[que.peekFirst()]);
                }
            }*/
            // 方法二
            if(k==1){
                return nums;
            }
            que.offerLast(0);
            for (int i = 1; i < size; i++) {
                if (i - que.peekFirst() == k) {
                    que.pollFirst();
                }
                // deq[0]<n 则deq出队列。
                while (!que.isEmpty() && nums[que.peekFirst()] < nums[i]) {
                    que.pollFirst();
                }
                // n-1<n,则n-1出队列。
                while (!que.isEmpty() && nums[que.peekLast()] < nums[i]) {
                    que.pollLast();
                }
                que.offerLast(i);

                if (i >= k - 1) {
                    window.add(nums[que.peekFirst()]);
                }
            }

            return convertArray(window);
        }

        int[] convertArray(List<Integer> window) {
            int[] result = new int[window.size()];
            int i = 0;
            for (Integer val : window) {
                result[i] = val;
                i++;
            }
            return result;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}