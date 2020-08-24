#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-24 10:23:16
LastEditor: John
LastEditTime: 2020-08-24 10:24:16
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/repeated-substring-pattern/
# Author : JohnJim0816
# Date   : 2020-08-24

##################################################################################################### 
#
# Given a non-empty string check if it can be constructed by taking a substring of it and appending 
# multiple copies of the substring together. You may assume the given string consists of lowercase 
# English letters only and its length will not exceed 10000.
# 
# Example 1:
# 
# Input: "abab"
# Output: True
# Explanation: It's the substring "ab" twice.
# 
# Example 2:
# 
# Input: "aba"
# Output: False
# 
# Example 3:
# 
# Input: "abcabcabcabc"
# Output: True
# Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
# 
#####################################################################################################
class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        return (s + s).find(s, 1) !=len(s)
