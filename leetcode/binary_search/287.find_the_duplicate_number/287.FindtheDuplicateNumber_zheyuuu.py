# Source : https://leetcode.com/problems/find-the-duplicate-number/
# Author : zheyuuu
# Date   : 2020-07-26

##################################################################################################### 
#
# Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
# prove that at least one duplicate number must exist. Assume that there is only one duplicate 
# number, find the duplicate one.
# 
# Example 1:
# 
# Input: [1,3,4,2,2]
# Output: 2
# 
# Example 2:
# 
# Input: [3,1,3,4,2]
# Output: 3
# 
# Note:
# 
# 	You must not modify the array (assume the array is read only).
# 	You must use only constant, O(1) extra space.
# 	Your runtime complexity should be less than O(n2).
# 	There is only one duplicate number in the array, but it could be repeated more than once.
# 
#####################################################################################################

class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        # fast and slow pointer
        # O(n)
        fast = slow = nums[0]
        while(True):
            fast = nums[nums[fast]]
            slow = nums[slow]
            if fast==slow:
                break
        fast = nums[0]
        while(fast!=slow):
            fast = nums[fast]
            slow = nums[slow]
        return fast
    
    def findDuplicate(self, nums):
        # clever binary search solution
        # O(n*logn)
        l,r = 1, len(nums)
        while(l<r):
            mid = (l+r)//2
            cnt = 0
            for num in nums:
                cnt += 1 if num<=mid else 0
            if cnt<=mid:
                l = mid+1
            else:
                r = mid
        return l
        