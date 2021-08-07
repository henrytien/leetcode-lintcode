# Source : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
# Author : yhwhu
# Date   : 2020-07-21

##################################################################################################### 
#
# Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
# 
# (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
# 
# You are given a target value to search. If found in the array return true, otherwise return false.
# 
# Example 1:
# 
# Input: nums = [2,5,6,0,0,1,2], target = 0
# Output: true
# 
# Example 2:
# 
# Input: nums = [2,5,6,0,0,1,2], target = 3
# Output: false
# 
# Follow up:
# 
# 	This is a follow up problem to Search in Rotated Sorted Array, where nums may contain 
# duplicates.
# 	Would this affect the run-time complexity? How and why?
# 
#####################################################################################################

class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return True
            if nums[mid] == nums[left]:
                left += 1
            elif nums[mid] == nums[right]:
                right -= 1
            elif nums[mid] > nums[0]:
                if nums[0] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            elif nums[mid] < nums[0]:
                if nums[mid] < target <= nums[len(nums) - 1]:
                    left = mid + 1
                else:
                    right = mid - 1
        return False