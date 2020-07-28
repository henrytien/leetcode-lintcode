# Source : https://leetcode.com/problems/median-of-two-sorted-arrays/
# Author : zheyuuu
# Date   : 2020-07-26

##################################################################################################### 
#
# There are two sorted arrays nums1 and nums2 of size m and n respectively.
# 
# Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
# 
# You may assume nums1 and nums2 cannot be both empty.
# 
# Example 1:
# 
# nums1 = [1, 3]
# nums2 = [2]
# 
# The median is 2.0
# 
# Example 2:
# 
# nums1 = [1, 2]
# nums2 = [3, 4]
# 
# The median is (2 + 3)/2 = 2.5
# 
#####################################################################################################

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        m, n = len(nums1), len(nums2)
        imin, imax = 0, m
        #       left_part          |        right_part
        # A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
        # B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
        while(imin <= imax):
            i = (imin+imax)//2
            j = (m+n+1)//2-i

            if(i>=0 and i<m and j-1>=0 and j-1<n and nums2[j-1]>nums1[i]):
                imin = i+1
            elif(i-1>=0 and i-1<m and j>=0 and j<=n and nums1[i-1]>nums2[j]):
                imax = i
            else:
                # Ensure max(left_part)<=min(right_part)
                # 1. nums1's left max <= nums2's right min
                #    - i == 0           left_part of nums1 is empty, max(left_part)<=min(right_part) only determined by condition 2.
                #    - or j == n        right_part of nums2 is empty, max(left_part)<=min(right_part) only determined by condition 2. 
                #    - or nums1[i-1] <= nums2[j]    
                # 2. nums2's left max <= nums1's right min
                #    - j == 0 
                #    - or i == m
                #    - or nums2[j-1] <= nums1[i] 
                leftmax1 = nums1[i-1] if i>0 else float("-inf")
                rightmin1 = nums1[i] if i<m else float("inf")

                leftmax2 = nums2[j-1] if j>0 else float("-inf")
                rightmin2 = nums2[j] if j<n else float("inf")
                if (m+n)%2 == 0:
                    return (max(leftmax1,leftmax2)+min(rightmin1, rightmin2))/2
                else:
                    return max(leftmax1, leftmax2)