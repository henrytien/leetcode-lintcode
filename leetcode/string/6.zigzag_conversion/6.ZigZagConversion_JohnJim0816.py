#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-06 00:43:41
LastEditor: John
LastEditTime: 2020-08-06 00:46:51
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/zigzag-conversion/
# Author : JohnJim0816
# Date   : 2020-08-06

##################################################################################################### 
#
# The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
# (you may want to display this pattern in a fixed font for better legibility)
# 
# P   A   H   N
# A P L S I I G
# Y   I   R
# 
# And then read line by line: "PAHNAPLSIIGYIR"
# 
# Write the code that will take a string and make this conversion given a number of rows:
# 
# string convert(string s, int numRows);
# 
# Example 1:
# 
# Input: s = "PAYPALISHIRING", numRows = 3
# Output: "PAHNAPLSIIGYIR"
# 
# Example 2:
# 
# Input: s = "PAYPALISHIRING", numRows = 4
# Output: "PINALSIGYAHRPI"
# Explanation:
# 
# P     I    N
# A   L S  I G
# Y A   H R
# P     I
#####################################################################################################

class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows < 2: return s
        res = ["" for _ in range(numRows)]
        i, flag = 0, -1
        for c in s:
            res[i] += c
            if i == 0 or i == numRows - 1: flag = -flag
            i += flag
        return "".join(res)
