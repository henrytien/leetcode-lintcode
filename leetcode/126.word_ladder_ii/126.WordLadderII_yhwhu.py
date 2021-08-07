# Source : https://leetcode.com/problems/word-ladder-ii/
# Author : yhwhu
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

class Solution(object):
    def findLadders(self, beginWord, endWord, wordList):

        wordlist = set(wordList)
        queue = {}
        queue[beginWord] = [[beginWord]]
        res = []
        while queue:
            next_queue = collections.defaultdict(list)
            for cur_word in queue:
                if cur_word == endWord:
                    res.extend(j for j in queue[cur_word])
                    return res
                else:
                    for i in range(len(beginWord)):
                        for s in "abcdefghijklmnopqrstuvwxyz":
                            next_word = cur_word[:i] + s + cur_word[i + 1:]
                            if next_word in wordlist:
                                next_queue[cur_word] += [j + [next_word] for j in queue[cur_word]]
            wordlist -= set(next_queue.keys())
            queue = next_queue

        return res