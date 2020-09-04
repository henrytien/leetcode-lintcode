#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-09-05 06:08:40
LastEditor: John
LastEditTime: 2020-09-05 06:09:06
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/permutation-sequence/
# Author : JohnJim0816
# Date   : 2020-09-05

##################################################################################################### 
#
# The set [1,2,3,...,n] contains a total of n! unique permutations.
# 
# By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
# 
# 	"123"
# 	"132"
# 	"213"
# 	"231"
# 	"312"
# 	"321"
# 
# Given n and k, return the kth permutation sequence.
# 
# Note:
# 
# 	Given n will be between 1 and 9 inclusive.
# 	Given k will be between 1 and n! inclusive.
# 
# Example 1:
# 
# Input: n = 3, k = 3
# Output: "213"
# 
# Example 2:
# 
# Input: n = 4, k = 9
# Output: "2314"
# 
#####################################################################################################

class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        factorial = [1]
        for i in range(1, n):
            factorial.append(factorial[-1] * i)
        
        k -= 1
        ans = list()
        valid = [1] * (n + 1)
        for i in range(1, n + 1):
            order = k // factorial[n - i] + 1
            for j in range(1, n + 1):
                order -= valid[j]
                if order == 0:
                    ans.append(str(j))
                    valid[j] = 0
                    break
            k %= factorial[n - i]

        return "".join(ans)

