# Source : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
# Author : zheyuuu 
# Date   : 2020-07-21

##################################################################################################### 
#
# Given an array of integers nums sorted in ascending order, find the starting and ending position of 
# a given target value.
# 
# Your algorithm's runtime complexity must be in the order of O(log n).
# 
# If the target is not found in the array, return [-1, -1].
# 
# Example 1:
# 
# Input: nums = [5,7,7,8,8,10], target = 8
# Output: [3,4]
# 
# Example 2:
# 
# Input: nums = [5,7,7,8,8,10], target = 6
# Output: [-1,-1]
# 
# Constraints:
# 
# 	0 <= nums.length <= 10^5
# 	-10^9 <= nums[i] <= 10^9
# 	nums is a non decreasing array.
# 	-10^9 <= target <= 10^9
#####################################################################################################
from typing import List
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l,r = 0, len(nums)
        if not nums:
            return [-1,-1]
        while(l<r):
            mid = (l+r)//2
            if nums[mid]<target:
                l = mid+1
            else:
                r = mid
        a = l if l<len(nums) and nums[l]==target else -1
        
        l,r = 0,len(nums)
        while(l<r):
            mid = (l+r)//2
            if nums[mid]<= target:
                l = mid+1
            else:
                r = mid
        b = l-1 if nums[l-1]==target else -1
        return [a,b]