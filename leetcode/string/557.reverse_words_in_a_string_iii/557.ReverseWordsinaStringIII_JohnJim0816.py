#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-30 09:23:34
LastEditor: John
LastEditTime: 2020-08-30 09:23:41
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/reverse-words-in-a-string-iii/
# Author : JohnJim0816
# Date   : 2020-08-30

##################################################################################################### 
#
# Given a string, you need to reverse the order of characters in each word within a sentence while 
# still preserving whitespace and initial word order.
# 
# Example 1:
# 
# Input: "Let's take LeetCode contest"
# Output: "s'teL ekat edoCteeL tsetnoc"
# 
# Note:
# In the string, each word is separated by single space and there will not be any extra space in the 
# string.
#####################################################################################################

class Solution(object):
    '''将字符串分割成单词列表 然后把每个单词反转切片
    '''
    def reverseWords(self, s):
        return " ".join(word[::-1] for word in s.split(" "))
