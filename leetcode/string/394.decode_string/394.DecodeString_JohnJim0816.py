#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-05 21:46:28
LastEditor: John
LastEditTime: 2020-08-05 21:52:33
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/decode-string/
# Author : JohnJim0816
# Date   : 2020-08-05

##################################################################################################### 
#
# Given an encoded string, return its decoded string.
# 
# The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is 
# being repeated exactly k times. Note that k is guaranteed to be a positive integer.
# 
# You may assume that the input string is always valid; No extra white spaces, square brackets are 
# well-formed, etc.
# 
# Furthermore, you may assume that the original data does not contain any digits and that digits are 
# only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
# 
# Example 1:
# Input: s = "3[a]2[bc]"
# Output: "aaabcbc"
# Example 2:
# Input: s = "3[a2[c]]"
# Output: "accaccacc"
# Example 3:
# Input: s = "2[abc]3[cd]ef"
# Output: "abcabccdcdcdef"
# Example 4:
# Input: s = "abc3[cd]xyz"
# Output: "abccdcdcdxyz"
#####################################################################################################

class Solution:
    ''' 辅助栈法
    '''
    def decodeString(self, s: str) -> str:
        stack, res, multi = [], "", 0
        for c in s:
            if c == '[':
                stack.append([multi, res])
                res, multi = "", 0
            elif c == ']':
                cur_multi, last_res = stack.pop()
                res = last_res + cur_multi * res
            elif '0' <= c <= '9':
                multi = multi*10+int(c)  # 可能出现连续数字需要*10         
            else:
                res += c
        return res