#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-27 08:23:22
LastEditor: John
LastEditTime: 2020-08-27 08:23:34
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/reconstruct-itinerary/
# Author : JohnJim0816
# Date   : 2020-08-27

##################################################################################################### 
#
# Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], 
# reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, 
# the itinerary must begin with JFK.
# 
# Note:
# 
# 	If there are multiple valid itineraries, you should return the itinerary that has the 
# smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has 
# a smaller lexical order than ["JFK", "LGB"].
# 	All airports are represented by three capital letters (IATA code).
# 	You may assume all tickets form at least one valid itinerary.
# 	One must use all the tickets once and only once.
# 
# Example 1:
# 
# Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
# Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
# 
# Example 2:
# 
# Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
# Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
# Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
#              But it is larger in lexical order.
#####################################################################################################

import collections
class Solution:
    def findItinerary(self, tickets):
        paths = collections.defaultdict(list)
        # 存储路线
        for start, tar in tickets:
            paths[start].append(tar)
        for start in paths:
            paths[start].sort(reverse=True) # 配合后面的pop()这里应该是反序
        s = []

        def dfs(start):
            while paths[start]:
                dfs(paths[start].pop())
            s.append(start)
        search("JFK")
        # 先执行的dfs再append，所以最后是倒序
        return s[::-1]