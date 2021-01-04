# Source : https://leetcode.com/problems/concatenated-words/
# Author : henrytine
# Date   : 2021-01-04

##################################################################################################### 
#
# Given a list of words (without duplicates), please write a program that returns all concatenated 
# words in the given list of words.
# 
# A concatenated word is defined as a string that is comprised entirely of at least two shorter words 
# in the given array.
# 
# Example 1:
# 
# Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
# Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
# Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
# "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
# "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
# 
# Example 2:
# 
# Input: words = ["cat","dog","catdog"]
# Output: ["catdog"]
# 
# Constraints:
# 
# 	1 <= words.length <= 104
# 	0 <= words[i].length <= 1000
# 	words[i] consists of only lowercase English letters.
# 	0 <= sum(words[i].length) <= 6 * 105
#####################################################################################################

class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        
#         d = set(words)
        
#         def dfs(word):
#             for i in range(1,len(word)):
#                 suffix = word[i:]
#                 prefix = word[:i]
                
#                 if suffix in d and prefix in d:
#                     return True
#                 if suffix in d and dfs(prefix):
#                     return True
#                 if prefix in d and dfs(suffix):
#                     return True
#             return False
        
#         res = []
#         for word in words:
#             if dfs(word):
#                 res.append(word)
#         return res
        d = set(words)
        memo = {}
        def dfs(word):
            if word in memo:
                return memo[word]
            memo[word] = False
            for i in range(1, len(word)):
                prefix = word[:i]
                suffix = word[i:]
                if prefix in d and suffix in d:
                    memo[word] = True 
                    break
                if prefix in d and dfs(suffix):
                    memo[word] = True 
                    break
                if suffix in d and dfs(prefix):
                    memo[word] = True 
                    break
            return memo[word] 
        return [word for word in words if dfs(word)]
