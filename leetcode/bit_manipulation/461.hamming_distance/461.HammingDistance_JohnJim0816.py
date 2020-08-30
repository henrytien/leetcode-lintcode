#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-30 09:27:46
LastEditor: John
LastEditTime: 2020-08-30 09:27:59
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/hamming-distance/
# Author : JohnJim0816
# Date   : 2020-08-30

##################################################################################################### 
#
# The Hamming distance between two integers is the number of positions at which the corresponding 
# bits are different.
# 
# Given two integers x and y, calculate the Hamming distance.
# 
# Note:
# 0 &le; x, y < 231.
# 
# Example:
# 
# Input: x = 1, y = 4
# 
# Output: 2
# 
# Explanation:
# 1   (0 0 0 1)
# 4   (0 1 0 0)
#        &uarr;   &uarr;
# 
# The above arrows point to positions where the corresponding bits are different.
# 
#####################################################################################################

class Solution:
    '''布赖恩·克尼根算法
    '''
    def hammingDistance(self, x, y):
        xor = x ^ y
        distance = 0
        while xor:
            distance += 1
            # remove the rightmost bit of '1'
            xor = xor & (xor - 1)
        return distance
