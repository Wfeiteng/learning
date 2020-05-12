//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。 
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法

package com.train.leetcode.editor.cn;

public class MedianOfTwoSortedArrays4 {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays4().new Solution();
        int[] nums1={1,3};
        int[] nums2={2};
        solution.findMedianSortedArrays(nums1,nums2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int alen = nums1.length;
            int blen = nums2.length;
            if(alen>blen){
               return  findMedianSortedArrays(nums2,nums1);
            }
            int left = 0,right = alen ,halfLen =(alen+blen+1)/2;
            while(left<=right){
                int i = (left+right)/2;
                // 若奇数，left多1，若偶数则平分
                int j = halfLen-i;
                if(i<right&&nums2[j-1]>nums1[i]){
                    left = i+1;
                } else if(i>left&&nums1[i-1]>nums2[j]){
                    right = i-1;
                }else{
                    boolean odd = ((alen+blen)&01)==1;
                    double leftMax = 0;
                    double rightMin =0;
                    if(i==0){
                        leftMax = nums2[j-1];
                    }else if(j==0){
                        leftMax = nums1[i-1];
                    }else{
                        leftMax = Math.max(nums1[i-1],nums2[j-1]);
                    }
                    if(odd) {
                        return leftMax;
                    }

                    if(i==alen){
                        rightMin = nums2[j];
                    } else if(j==blen){
                        rightMin = nums1[i];
                    }else{
                        rightMin = Math.min(nums1[i],nums2[j]);
                    }
                    return (leftMax+rightMin)/2;
                }
            }

            return 0.0;
        }

        public double findMedianSortedArrays2(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            if (m > n) { // to ensure m<=n
                int[] temp = A; A = B; B = temp;
                int tmp = m; m = n; n = tmp;
            }
            int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = halfLen - i;
                if (i < iMax && B[j-1] > A[i]){
                    iMin = i + 1; // i is too small
                }
                else if (i > iMin && A[i-1] > B[j]) {
                    iMax = i - 1; // i is too big
                }
                else { // i is perfect
                    int maxLeft = 0;
                    if (i == 0) { maxLeft = B[j-1]; }
                    else if (j == 0) { maxLeft = A[i-1]; }
                    else { maxLeft = Math.max(A[i-1], B[j-1]); }
                    if ( (m + n) % 2 == 1 ) { return maxLeft; }

                    int minRight = 0;
                    if (i == m) { minRight = B[j]; }
                    else if (j == n) { minRight = A[i]; }
                    else { minRight = Math.min(B[j], A[i]); }

                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
        }

    }

}