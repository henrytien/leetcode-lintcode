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
        while(imin <= imax):
            i = (imin+imax)//2
            j = (m+n+1)//2-i

            if(i<m and nums2[j-1]>nums1[i]):
                imin = i+1
            elif(i>0 and nums1[i-1]>nums2[j]):
                imax = i
            else:
                # Ensure max(left_part)<=min(right_part)
                leftmax1 = nums1[i-1] if i>0 else float("-inf")
                rightmin1 = nums1[i] if i<m else float("inf")

                leftmax2 = nums2[j-1] if j>0 else float("-inf")
                rightmin2 = nums2[j] if j<n else float("inf")
                if (m+n)%2 == 0:
                    return (max(leftmax1,leftmax2)+min(rightmin1, rightmin2))/2
                else:
                    return max(leftmax1, leftmax2)