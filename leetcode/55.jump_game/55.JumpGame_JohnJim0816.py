#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-27 14:19:46
@LastEditor: John
@LastEditTime: 2020-07-27 14:20:11
@Discription: 
@Environment: python 3.7.7
'''
# Source : https://leetcode.com/problems/jump-game/
# Author : JohnJim0816
# Date   : 2020-07-27

##################################################################################################### 
#
# Given an array of non-negative integers, you are initially positioned at the first index of the 
# array.
# 
# Each element in the array represents your maximum jump length at that position.
# 
# Determine if you are able to reach the last index.
# 
# Example 1:
# 
# Input: nums = [2,3,1,1,4]
# Output: true
# Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
# 
# Example 2:
# 
# Input: nums = [3,2,1,0,4]
# Output: false
# Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which 
# makes it impossible to reach the last index.
# 
# Constraints:
# 
# 	1 <= nums.length <= 3 * 10^4
# 	0 <= nums[i][j] <= 10^5
#####################################################################################################

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        rightmost=0
        for i in range(len(nums)):           
            if i > rightmost:
                return False
            if (i+nums[i])>= rightmost:
                rightmost = i+nums[i]
        return True