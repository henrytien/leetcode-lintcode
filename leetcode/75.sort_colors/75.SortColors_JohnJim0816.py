#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-02 14:52:55
LastEditor: John
LastEditTime: 2020-08-02 14:53:54
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/sort-colors/
# Author : JohnJim0816
# Date   : 2020-08-02

##################################################################################################### 
#
# Given an array with n objects colored red, white or blue, sort them in-place so that objects of the 
# same color are adjacent, with the colors in the order red, white and blue.
# 
# Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
# 
# Note: You are not suppose to use the library's sort function for this problem.
# 
# Example:
# 
# Input: [2,0,2,1,1,0]
# Output: [0,0,1,1,2,2]
# 
# Follow up:
# 
# 	A rather straight forward solution is a two-pass algorithm using counting sort.
# 	First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with 
# total number of 0's, then 1's and followed by 2's.
# 	Could you come up with a one-pass algorithm using only constant space?
# 
#####################################################################################################

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        '''
        荷兰三色旗问题解
        '''
        # 对于所有 idx < p0 : nums[idx < p0] = 0
        # curr是当前考虑元素的下标
        p0 = curr = 0
        # 对于所有 idx > p2 : nums[idx > p2] = 2
        p2 = len(nums) - 1

        while curr <= p2:
            if nums[curr] == 0:
                nums[p0], nums[curr] = nums[curr], nums[p0]
                p0 += 1
                curr += 1
            elif nums[curr] == 2:
                nums[curr], nums[p2] = nums[p2], nums[curr]
                p2 -= 1
            else:
                curr += 1