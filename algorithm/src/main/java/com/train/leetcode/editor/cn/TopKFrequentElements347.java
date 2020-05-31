//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表

package com.train.leetcode.editor.cn;

import java.util.*;

public class TopKFrequentElements347 {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements347().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            int[] result = new int[k];
            Map<Integer, Integer> sumary = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (sumary.containsKey(nums[i])) {
                    sumary.put(nums[i], sumary.get(nums[i]) + 1);
                } else {
                    sumary.put(nums[i], 1);
                }
            }
            // 桶排序,频率作为mark数组的索引;
            List<Integer>[] mark = new ArrayList[nums.length + 1];
            sumary.forEach((key, value) -> {
                if (mark[value] == null) {
                    mark[value] = new ArrayList<Integer>();
                }
                mark[value].add(key);
            });
            List<Integer> res = new ArrayList<>();
            for (int index = nums.length; res.size() < k; index--) {
                if (mark[index] == null) {
                    continue;
                }
                res.addAll(mark[index]);
            }
            ListIterator<Integer> li = res.listIterator();
            int pos = 0;
            while (li.hasNext()) {
                result[pos] = li.next();
                pos++;
            }
            return result;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}