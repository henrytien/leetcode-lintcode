#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-27 14:42:30
@LastEditor: John
@LastEditTime: 2020-07-27 14:43:08
@Discription: 
@Environment: python 3.7.7
'''
# Source : https://leetcode.com/problems/jump-game-ii/
# Author : JohnJim0816
# Date   : 2020-07-27

##################################################################################################### 
#
# Given an array of non-negative integers, you are initially positioned at the first index of the 
# array.
# 
# Each element in the array represents your maximum jump length at that position.
# 
# Your goal is to reach the last index in the minimum number of jumps.
# 
# Example:
# 
# Input: [2,3,1,1,4]
# Output: 2
# Explanation: The minimum number of jumps to reach the last index is 2.
#     Jump 1 step from index 0 to 1, then 3 steps to the last index.
# 
# Note:
# 
# You can assume that you can always reach the last index.
#####################################################################################################

class Solution:
    '''贪婪
    '''
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        rightmost, end, step = 0, 0, 0 # end为当前跳跃的边界
        for i in range(n-1): #最后一个元素不必访问
            if i <= rightmost:
                rightmost = max(rightmost,i+nums[i])
            if i == end:
                end = rightmost
                step += 1
        return step
