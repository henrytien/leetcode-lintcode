#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-09-10 00:22:28
LastEditor: John
LastEditTime: 2020-09-10 00:22:40
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/combination-sum/
# Author : JohnJim0816
# Date   : 2020-09-10

##################################################################################################### 
#
# Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
# find all unique combinations in candidates where the candidate numbers sums to target.
# 
# The same repeated number may be chosen from candidates unlimited number of times.
# 
# Note:
# 
# 	All numbers (including target) will be positive integers.
# 	The solution set must not contain duplicate combinations.
# 
# Example 1:
# 
# Input: candidates = [2,3,6,7], target = 7,
# A solution set is:
# [
#   [7],
#   [2,2,3]
# ]
# 
# Example 2:
# 
# Input: candidates = [2,3,5], target = 8,
# A solution set is:
# [
#   [2,2,2,2],
#   [2,3,3],
#   [3,5]
# ]
# 
# Constraints:
# 
# 	1 <= candidates.length <= 30
# 	1 <= candidates[i] <= 200
# 	Each element of candidate is unique.
# 	1 <= target <= 500
#####################################################################################################

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        def dfs(candidates, begin, size, path, res, target):
            if target < 0:
                return
            if target == 0:
                res.append(path)
                return
            
            for index in range(begin, size):
                
                dfs(candidates, index, size, path + [candidates[index]], res, target - candidates[index])
            print(path)
        size = len(candidates)
        if size == 0:
            return []
        path = []
        res = []
        dfs(candidates, 0, size, path, res, target)
        return res