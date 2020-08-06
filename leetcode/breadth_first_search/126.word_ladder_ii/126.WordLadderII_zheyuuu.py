# Source : https://leetcode.com/problems/word-ladder-ii
# Author : zheyuuu
# Date   : 2020-08-04

##################################################################################################### 
#
# Given two words (beginWord and endWord), and a dictionary's word list, find all shortest 
# transformation sequence(s) from beginWord to endWord, such that:
# 
# 	Only one letter can be changed at a time
# 	Each transformed word must exist in the word list. Note that beginWord is not a transformed 
# word.
# 
# Note:
# 
# 	Return an empty list if there is no such transformation sequence.
# 	All words have the same length.
# 	All words contain only lowercase alphabetic characters.
# 	You may assume no duplicates in the word list.
# 	You may assume beginWord and endWord are non-empty and are not the same.
# 
# Example 1:
# 
# Input:
# beginWord = "hit",
# endWord = "cog",
# wordList = ["hot","dot","dog","lot","log","cog"]
# 
# Output:
# [
#   ["hit","hot","dot","dog","cog"],
#   ["hit","hot","lot","log","cog"]
# ]
# 
# Example 2:
# 
# Input:
# beginWord = "hit"
# endWord = "cog"
# wordList = ["hot","dot","dog","lot","log"]
# 
# Output: []
# 
# Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
# 
#####################################################################################################
class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        d = collections.defaultdict(list)
        vis = {}
        n = len(beginWord)
        for word in wordList:
            for i in range(n):
                new = word[:i]+"*"+word[i+1:]
                d[new].append(word)
        q =  [(beginWord, 0, [beginWord])]
        vis[beginWord]=0
        opt = float("inf")
        ans = []
        while(q):
            u, k, path = q.pop(0)
            if k>opt:
                continue
            if u==endWord:
                ans.append(path[:])
                opt = k
                continue
            for i in range(n):
                intermediate = u[:i]+"*"+u[i+1:]
                for w in d[intermediate]:
                    if w not in vis or k==vis[w]:
                        vis[w] = k
                        q.append((w, k+1, path+[w]))
        return ans
