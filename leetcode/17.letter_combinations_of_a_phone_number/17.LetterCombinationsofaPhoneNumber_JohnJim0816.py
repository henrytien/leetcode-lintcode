#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-26 16:01:18
LastEditor: John
LastEditTime: 2020-08-26 16:02:53
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
# Author : JohnJim0816
# Date   : 2020-08-26

##################################################################################################### 
#
# Given a string containing digits from 2-9 inclusive, return all possible letter combinations that 
# the number could represent.
# 
# A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does 
# not map to any letters.
# 
# Example:
# 
# Input: "23"
# Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
# 
# Note:
# 
# Although the above answer is in lexicographical order, your answer could be in any order you want.
#####################################################################################################

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        ##特殊条件判断
        if len(digits)==0:
            return []   
        ##先定义数字和字母的字典
        dic = {"2":"abc","3":"def","4":"ghi","5":"jkl","6":"mno","7":"pqrs","8":"tuv","9":"wxyz"}
        ##使用BFS来解决
        deque = collections.deque()
        deque.append("")
        for i in range(len(digits)):
            deque_len = len(deque)
            for j in range(deque_len):
                cur_digit = dic[digits[i]]
                saved_digit = deque.popleft()
                for digit in cur_digit:
                    deque.append(saved_digit+digit)
        return list(deque)
