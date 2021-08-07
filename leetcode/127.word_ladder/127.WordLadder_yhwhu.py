# Source : https://leetcode.com/problems/word-ladder/
# Author : yhwhu
# Date   : 2020-07-31

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
    def ladderLength(self, beginWord: str, endWord: str, wordList) -> int:
        wordlist = set(wordList)
        queue = [beginWord]
        step = 1
        while queue:
            for _ in range(len(queue)):
                cur_str = queue.pop(0)
                if cur_str == endWord:
                    return step
                for i in range(len(beginWord)):
                    for s in "abcdefghijklmnopqrstuvwxyz":
                        new_str = cur_str[:i] + s + cur_str[i + 1:]
                        if new_str in wordlist:
                            queue.append(new_str)
                            wordlist.remove(new_str)
            step += 1
        return 0
