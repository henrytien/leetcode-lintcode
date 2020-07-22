# Source : https://leetcode.com/problems/search-in-rotated-sorted-array/
# Author : yhwhu
# Date   : 2020-07-21

##################################################################################################### 
#
# Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
# 
# (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
# 
# You are given a target value to search. If found in the array return its index, otherwise return -1.
# 
# You may assume no duplicate exists in the array.
# 
# Your algorithm's runtime complexity must be in the order of O(log n).
# 
# Example 1:
# 
# Input: nums = [4,5,6,7,0,1,2], target = 0
# Output: 4
# 
# Example 2:
# 
# Input: nums = [4,5,6,7,0,1,2], target = 3
# Output: -1
#####################################################################################################

from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            if nums[mid] >= nums[0]:  # compare with 0
                if nums[0] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if nums[mid] < target <= nums[len(nums) - 1]:  # # compare with n-1
                    left = mid + 1
                else:
                    right = mid - 1
        return -1

    def search2(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            if nums[mid] >= nums[left]:  # compare with left
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if nums[mid] < target <= nums[right]:  # compare with right
                    left = mid + 1
                else:
                    right = mid - 1
        return -1
