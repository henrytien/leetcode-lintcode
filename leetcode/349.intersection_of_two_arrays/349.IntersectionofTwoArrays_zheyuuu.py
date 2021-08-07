# Source : https://leetcode.com/problems/intersection-of-two-arrays
# Author : zheyuuu
# Date   : 2020-07-27

##################################################################################################### 
#
# Given two arrays, write a function to compute their intersection.
# 
# Example 1:
# 
# Input: nums1 = [1,2,2,1], nums2 = [2,2]
# Output: [2]
# 
# Example 2:
# 
# Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
# Output: [9,4]
# 
# Note:
# 
# 	Each element in the result must be unique.
# 	The result can be in any order.
# 
#####################################################################################################
class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        lookup = set(nums1)
        ans = []
        for num in nums2:
            if num in lookup:
                ans.append(num)
                lookup.remove(num)
        return ans
    
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ans = set()
        if len(nums1)>len(nums2):
            nums1,nums2 = nums2,nums1
        def bs(nums, target):
            l,r = 0, len(nums)
            while(l<r):
                mid = (l+r)//2
                if nums[mid]==target:
                    return True
                elif nums[mid]<target:
                    l = mid+1
                else:
                    r = mid
            return False
        nums2.sort()
        for num in nums1:
            if(bs(nums2, num)):
                ans.add(num)
        return ans
            
