// Source : https://leetcode.com/problems/median-of-two-sorted-arrays/
// Author : Kris
// Date   : 2020-07-27

/***************************************************************************************************** 
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * Example 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 ******************************************************************************************************/

class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null) {
            return 0;
        }
        
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2;
        } else {
            // 第k个，所以奇数情况下应该 (len + 1) / 2
            return findKth(A, 0, B, 0, (len + 1) / 2);
        }
    }
    
    private double findKth(int[] A, int a_start, int[] B, int b_start, int k) {
        if (a_start >= A.length) {
            // [1,2],[3] 求第2个，index = k - 1
            return B[b_start + k - 1];
        }
        
        if (b_start >= B.length) {
            return A[a_start + k - 1];
        }
        
        if (k == 1) {
            return Math.min(A[a_start], B[b_start]);
        }
        
        // [1,2],[3], 求第2个，可能被排除掉部分为两个数组各取第1个元素，index = 0 = k / 2 - 1
        int a_k = a_start + k / 2 - 1 < A.length ? A[a_start + k / 2 - 1] : Integer.MAX_VALUE;
        int b_k = b_start + k / 2 - 1 < B.length ? B[b_start + k / 2 - 1] : Integer.MAX_VALUE;
        
        if (a_k < b_k) {
            // a_start + k / 2 : 从被排除掉的元素的下一个开始 k / 2 - 1 + 1
            // k - k / 2 : 第k个，排除掉了 k / 2 个，还剩 k - k / 2
            return findKth(A, a_start + k / 2, B, b_start, k - k / 2);
        } else {
            return findKth(A, a_start, B, b_start + k / 2, k - k / 2);
        }
    }
}