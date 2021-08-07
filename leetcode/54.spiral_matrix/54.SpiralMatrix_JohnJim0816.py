#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-08-02 10:54:52
@LastEditor: John
@LastEditTime: 2020-08-02 10:56:37
@Discription: 
@Environment: 
'''
# Source : https://leetcode.com/problems/spiral-matrix/
# Author : JohnJim0816
# Date   : 2020-08-02

##################################################################################################### 
#
# Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral 
# order.
# 
# Example 1:
# 
# Input:
# [
#  [ 1, 2, 3 ],
#  [ 4, 5, 6 ],
#  [ 7, 8, 9 ]
# ]
# Output: [1,2,3,6,9,8,7,4,5]
# 
# Example 2:
# 
# Input:
# [
#   [1, 2, 3, 4],
#   [5, 6, 7, 8],
#   [9,10,11,12]
# ]
# Output: [1,2,3,4,8,12,11,10,9,5,6,7]
#####################################################################################################

class Solution:
    ''' 直接模拟
    '''
    def spiralOrder(self, matrix:[[int]]) -> [int]:
        if not matrix: return []
        l, r, t, b, res = 0, len(matrix[0]) - 1, 0, len(matrix) - 1, []
        while True:
            for i in range(l, r + 1): res.append(matrix[t][i]) # left to right
            t += 1
            if t > b: break
            for i in range(t, b + 1): res.append(matrix[i][r]) # top to bottom
            r -= 1
            if l > r: break
            for i in range(r, l - 1, -1): res.append(matrix[b][i]) # right to left
            b -= 1
            if t > b: break
            for i in range(b, t - 1, -1): res.append(matrix[i][l]) # bottom to top
            l += 1
            if l > r: break
        return res

class Solution:
    ''' 人生苦短，我用python
    '''
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        res = []
        while matrix:
            res += matrix.pop(0)
            matrix = list(zip(*matrix))[::-1]
        return res