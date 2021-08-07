#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-06 09:18:22
LastEditor: John
LastEditTime: 2020-08-06 09:21:02
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/complex-number-multiplication/
# Author : JohnJim0816
# Date   : 2020-08-06

##################################################################################################### 
#
# 
# Given two strings representing two complex numbers.
# 
# You need to return a string representing their multiplication. Note i2 = -1 according to the 
# definition.
# 
# Example 1:
# 
# Input: "1+1i", "1+1i"
# Output: "0+2i"
# Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
# 
# Example 2:
# 
# Input: "1+-1i", "1+-1i"
# Output: "0+-2i"
# Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
# 
# Note:
# 
# The input strings will not have extra blank.
# The input strings will be given in the form of a+bi, where the integer a and b will both belong to 
# the range of [-100, 100]. And the output should be also in this form.
# 
#####################################################################################################

class Solution:
    ''' (a+ib)×(x+iy)=ax+i^2by+i(bx+ay)=ax−by+i(bx+ay)
    '''
    def complexNumberMultiply(self, a: str, b: str) -> str:
        a = a[:-1]        
        b = b[:-1]
        
        # 以+号为界分开
        a = list(map(int, a.split('+')))
        b = list(map(int, b.split('+')))
        
        re = a[0] * b[0] - a[1] * b[1]
        im = a[0] * b[1] + a[1] * b[0]
        
        re = str(re)
        im = str(im)
        
        ans = re + '+' + im + 'i'
        return ans