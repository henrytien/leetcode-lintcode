# Source : https://leetcode.com/problems/word-ladder
# Author : zheyuuu
# Date   : 2020-07-29

##################################################################################################### 
#
# Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest 
# transformation sequence from beginWord to endWord, such that:
# 
# 	Only one letter can be changed at a time.
# 	Each transformed word must exist in the word list.
# 
# Note:
# 
# 	Return 0 if there is no such transformation sequence.
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
# Output: 5
# 
# Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
# return its length 5.
# 
# Example 2:
# 
# Input:
# beginWord = "hit"
# endWord = "cog"
# wordList = ["hot","dot","dog","lot","log"]
# 
# Output: 0
# 
# Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
#####################################################################################################

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        n = len(beginWord)
        back = collections.defaultdict(list)
        vis = {}
        for word in wordList:
            
            for i in range(len(word)):
                new = word[:i]+"_"+word[i+1:]
                back[new].append(word)
            vis[word] = False
        q = [(beginWord, 1)]
        vis[beginWord] = True
        vis[endWord] = False
        while(q):
            cur,cnt = q.pop(0)
            if cur == endWord:
                return cnt
            for i in range(n):
                new = cur[:i]+"_"+cur[i+1:]
                for w in back[new]:
                    if not vis[w]:
                        vis[w] = True
                        q.append((w, cnt+1))
        return 0