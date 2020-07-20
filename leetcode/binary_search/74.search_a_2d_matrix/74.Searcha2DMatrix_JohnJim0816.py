#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-20 08:56:10
@LastEditor: John
@LastEditTime: 2020-07-20 08:56:20
@Discription: 
@Environment: python 3.7.7
'''
# Source : https://leetcode.com/problems/search-a-2d-matrix/
# Author : JohnJim0816
# Date   : 2020-07-20

##################################################################################################### 
#
# Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the 
# following properties:
# 
# 	Integers in each row are sorted from left to right.
# 	The first integer of each row is greater than the last integer of the previous row.
# 
# Example 1:
# 
# Input:
# matrix = [
#   [1,   3,  5,  7],
#   [10, 11, 16, 20],
#   [23, 30, 34, 50]
# ]
# target = 3
# Output: true
# 
# Example 2:
# 
# Input:
# matrix = [
#   [1,   3,  5,  7],
#   [10, 11, 16, 20],
#   [23, 30, 34, 50]
# ]
# target = 13
# Output: false
#####################################################################################################

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        left, right = 0, m*n-1
        while left <= right:
            mid = (left + right) // 2
            mid_elem = matrix[mid//n][mid%n]
            if target == mid_elem:
                return True
            else:
                if target <= mid_elem:
                    right = mid - 1
                else:
                    left = mid + 1
        return False