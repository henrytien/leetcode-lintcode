#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-09-10 00:32:01
LastEditor: John
LastEditTime: 2020-09-10 00:32:09
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/combination-sum-ii/
# Author : JohnJim0816
# Date   : 2020-09-10

##################################################################################################### 
#
# Given a collection of candidate numbers (candidates) and a target number (target), find all unique 
# combinations in candidates where the candidate numbers sums to target.
# 
# Each number in candidates may only be used once in the combination.
# 
# Note:
# 
# 	All numbers (including target) will be positive integers.
# 	The solution set must not contain duplicate combinations.
# 
# Example 1:
# 
# Input: candidates = [10,1,2,7,6,1,5], target = 8,
# A solution set is:
# [
#   [1, 7],
#   [1, 2, 5],
#   [2, 6],
#   [1, 1, 6]
# ]
# 
# Example 2:
# 
# Input: candidates = [2,5,2,1,2], target = 5,
# A solution set is:
# [
#   [1,2,2],
#   [5]
# ]
# 
#####################################################################################################

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(candidates, begin, size, path, res, target):
            if target < 0:
                return
            if target == 0:
                res.append(path)
                return
            
            for index in range(begin+1, size):
                
                dfs(candidates, index, size, path + [candidates[index]], res, target - candidates[index])
            print(path)
        size = len(candidates)
        if size == 0:
            return []
        path = []
        res = []
        dfs(candidates, 0, size, path, res, target)
        return res