// Source : https://leetcode.com/problems/median-of-two-sorted-arrays/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two 
 * sorted arrays.
 * 
 * Follow up: The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * 
 * Example 2:
 * 
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * Example 3:
 * 
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * 
 * Example 4:
 * 
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * 
 * Example 5:
 * 
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 * 
 * Constraints:
 * 
 * 	nums1.length == m
 * 	nums2.length == n
 * 	0 <= m <= 1000
 * 	0 <= n <= 1000
 * 	1 <= m + n <= 2000
 * 	-106 <= nums1[i], nums2[i] <= 106
 ******************************************************************************************************/

class Solution {
    // O(log(min(m, n)))
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) {
            return findMedianSortedArrays(B, A);
        }
        var m = A.length;
        var n = B.length;
        
        var left = 0;
        var right = m; 
        while (left < right - 1) {
            var midOfA = left + (right - left) / 2; // 左闭右开 [0, midOfA), [midOfA, m)
            var midOfB = (m + n) / 2 - midOfA; // 左闭右开 [0, midOfB), [midOfB, n)
            
            var maxOfA = midOfA == 0 ? Integer.MIN_VALUE : A[midOfA - 1];
            var minOfA = midOfA == m ? Integer.MAX_VALUE : A[midOfA];
            var maxOfB = midOfB == 0 ? Integer.MIN_VALUE : B[midOfB - 1];
            var minOfB = midOfB == n ? Integer.MAX_VALUE : B[midOfB];
            if (maxOfA > minOfB) {
                right = midOfA;
            } else {
                left = midOfA;
            }
        }
        
        // System.out.println(left + ":" + right);
        
        var midOfA = left;
        var midOfB = (m + n) / 2 - midOfA;
        var maxOfA = midOfA == 0 ? Integer.MIN_VALUE : A[midOfA - 1];
        var minOfA = midOfA == m ? Integer.MAX_VALUE : A[midOfA];
        var maxOfB = midOfB == 0 ? Integer.MIN_VALUE : B[midOfB - 1];
        var minOfB = midOfB == n ? Integer.MAX_VALUE : B[midOfB];
        if (Math.max(maxOfA, maxOfB) <= Math.min(minOfA, minOfB)) {
            if ((m + n) % 2 == 0) {
                return (Math.max(maxOfA, maxOfB) + Math.min(minOfA, minOfB)) / 2.0;
            } else {
                return Math.min(minOfA, minOfB);
            }
        } else {
            midOfA = right;
            midOfB = (m + n) / 2 - midOfA;
            maxOfA = midOfA == 0 ? Integer.MIN_VALUE : A[midOfA - 1];
            minOfA = midOfA == m ? Integer.MAX_VALUE : A[midOfA];
            maxOfB = midOfB == 0 ? Integer.MIN_VALUE : B[midOfB - 1];
            minOfB = midOfB == n ? Integer.MAX_VALUE : B[midOfB];

            if ((m + n) % 2 == 0) {
                return (Math.max(maxOfA, maxOfB) + Math.min(minOfA, minOfB)) / 2.0;
            } else {
                return Math.min(minOfA, minOfB);
            }
        }
    }
    
    // O(log(m + n))，每次排除一半
    public double findMedianSortedArrays_2(int[] A, int[] B) {
        if (A == null || B == null) {
            return 0;
        }
        
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2;
        } else {
            return findKth(A, 0, B, 0, (len + 1) / 2);
        }
    }
    
    // k: 第 k 个
    private double findKth(int[] A, int a_start, int[] B, int b_start, int k) {
        if (a_start >= A.length) {
            return B[b_start + k - 1];
        }
        
        if (b_start >= B.length) {
            return A[a_start + k - 1];
        }
        
        if (k == 1) {
            return Math.min(A[a_start], B[b_start]);
        }
        
        int a_k = a_start + k / 2 - 1 < A.length ? A[a_start + k / 2 - 1] : Integer.MAX_VALUE;
        int b_k = b_start + k / 2 - 1 < B.length ? B[b_start + k / 2 - 1] : Integer.MAX_VALUE;
        
        if (a_k < b_k) {
            return findKth(A, a_start + k / 2, B, b_start, k - k / 2);
        } else {
            return findKth(A, a_start, B, b_start + k / 2, k - k / 2);
        }
    }
}